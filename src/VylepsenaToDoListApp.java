import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VylepsenaToDoListApp extends JFrame implements ActionListener {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public VylepsenaToDoListApp() {
        setTitle("Vylepšená To-Do List");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Pridať úlohu");
        addButton.addActionListener(this);

        JButton removeButton = new JButton("Odstrániť označené");
        removeButton.addActionListener(this);

        JButton doneButton = new JButton("Označit ako hotové");
        doneButton.addActionListener(this);

        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(doneButton);
        add(inputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Pridať úlohu")) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText("");
            }
        } else if (actionCommand.equals("Odstrániť označené")) {
            int[] selectedIndices = taskList.getSelectedIndices();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                listModel.removeElementAt(selectedIndices[i]);
            }
        } else if (actionCommand.equals("Označiť ako hotové")) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedTask = listModel.getElementAt(selectedIndex);
                listModel.setElementAt("[Hotovo] " + selectedTask, selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VylepsenaToDoListApp().setVisible(true);
        });
    }
}
