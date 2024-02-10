import java.util.Scanner;

public class CalcualtorTerminal {
    static int op = 0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double prvibroj, drugibroj, rezultat;
        do {
            System.out.println("1-zbrajanje, 2-oduzimanje, 3-mnozenje, 4-djeljenje");
            op = scan.nextInt();
        } while (op < 1 && op > 4);
        if (op == 1) {
            System.out.println("Unesite prvi broj:");
            prvibroj = scan.nextDouble();
            System.out.println("Unesite drugi broj:");
            drugibroj = scan.nextDouble();

            rezultat = prvibroj + drugibroj;
            System.out.println(rezultat);
        }
        if (op == 2) {
            System.out.println("Unesite prvi broj:");
            prvibroj = scan.nextDouble();
            System.out.println("Unesite drugi broj:");
            drugibroj = scan.nextDouble();

            rezultat = prvibroj - drugibroj;
            System.out.println(rezultat);
        }
        if (op == 3) {
            System.out.println("Unesite prvi broj:");
            prvibroj = scan.nextDouble();
            System.out.println("Unesite drugi broj:");
            drugibroj = scan.nextDouble();

            rezultat = prvibroj * drugibroj;
            System.out.println(rezultat);
        }
        if (op == 4) {
            System.out.println("Unesite prvi broj:");
            prvibroj = scan.nextDouble();
            System.out.println("Unesite drugi broj:");
            drugibroj = scan.nextDouble();

            rezultat = prvibroj / drugibroj;
            System.out.println(rezultat);
        }
    }
}