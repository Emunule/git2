import java.util.Scanner;

public class BankovyUcet {

    private String menoMajitela;
    private double zostatok;

    public BankovyUcet(String menoMajitela, double pociatocnyZostatok) {
        this.menoMajitela = menoMajitela;
        this.zostatok = pociatocnyZostatok;
    }

    public void vloz(double ciastka) {
        if (ciastka > 0) {
            this.zostatok += ciastka;
            System.out.println("Vklad úspešný. Nový zostatok: " + this.zostatok);
        } else {
            System.out.println("Chyba: Zadajte kladnú čiastku pre vklad.");
        }
    }

    public void vyber(double ciastka) {
        if (ciastka > 0 && ciastka <= this.zostatok) {
            this.zostatok -= ciastka;
            System.out.println("Výber úspešný. Nový zostatok: " + this.zostatok);
        } else {
            System.out.println("Chyba: Neplatná čiastka pre výber alebo nedostatok prostriedkov.");
        }
    }

    public void zobrazZostatok() {
        System.out.println("Zostatok na účte " + this.menoMajitela + ": " + this.zostatok);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vitajte v simulácii bankového účtu!");

        System.out.print("Zadajte meno majiteľa účtu: ");
        String meno = scanner.nextLine();

        System.out.print("Zadajte počiatočný zostatok na účte: ");
        double pociatocnyZostatok = scanner.nextDouble();

        BankovyUcet ucet = new BankovyUcet(meno, pociatocnyZostatok);

        // Simulácia transakcií
        ucet.zobrazZostatok();

        System.out.print("Zadajte sumu pre vklad: ");
        double vklad = scanner.nextDouble();
        ucet.vloz(vklad);

        System.out.print("Zadajte sumu pre výber: ");
        double vyber = scanner.nextDouble();
        ucet.vyber(vyber);

        ucet.zobrazZostatok();
    }
}
