/* Zadatak je prikazati koliko neto placu mozemo imati na temelju ulaznih podataka: bruto dohoda, broj djece i mjesto prebivalista.
Na temelju tih varijabli mozemo dobiti ostale podatke kao sto su porezna osnovica, porez, prirez, neto dohodak itd. Broj djece je ograni�en do
�etvero, ali ima sve do 10. U ovoj aplikaciji nisu ura�unate osobe za koje se brinete. Prirez ima zasad sest gradova, a to su: Osijek, Zagreb, 
Dubrovnik, Rijeka, Split, Zadar i Makarska. */


import javax.swing.*;
import java.util.Scanner;

public class NetoCalculator {
    public static void main(String[] args) {
        //Omogucavanje unosa podataka preko tipkovnice

        Scanner input = new Scanner(System.in);

        //Ulazne varijabla brutoDohodak

        String brutoDohodakString = JOptionPane.showInputDialog(null, "Unesite iznos bruto dohodka: ");

        //Pretvaranje stringa u double

        double brutoDohodak = Double.parseDouble(brutoDohodakString);

        //Ulazne varijabla brojDjece

        String brojDjeceString = JOptionPane.showInputDialog(null, "Koliko imate djece: ");

        int brojDjece = Integer.parseInt(brojDjeceString);

        //Ulazne varijabla mjesto prebivalista

        String prebivalisteString = JOptionPane.showInputDialog(null, "Upisite naziv vaseg prebivalista (npr. Osijek, Zagreb, itd.): ");

        //Odredivanje osobnog odbitka (koeficjent), odreduje se prema broju djece

        double osobniOdbitak = 1; // inicijalizacija varijable

        if (brojDjece == 0)
            osobniOdbitak = 1;
        else if (brojDjece == 1)
            osobniOdbitak = 0.5;
        else if (brojDjece == 2)
            osobniOdbitak = 0.7;
        else if (brojDjece == 3)
            osobniOdbitak = 1;
        else if (brojDjece == 4)
            osobniOdbitak = 1.4;

        //Prirez za mjesto prebivalista

        double prirez = 0; // inicijaliziranje varijable

        switch (prebivalisteString) {
            case "Osijek":
                prirez = 13;
                break;
            case "Zagreb":
                prirez = 18;
                break;
            case "Rijeka":
                prirez = 15;
                break;
            case "Split":
                prirez = 10;
                break;
            case "Makarska":
                prirez = 10;
                break;
            case "Dubrovnik":
                prirez = 10;
                break;
            case "Zadar":
                prirez = 12;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Prebivaliste se ne nalazi u bazi!");
                System.exit(0);
        }

        //Racunanje

        // (int)(vrijednost * 100 ) / 100.0 se koristi da bi se vrijednost prikazala kao broj sa dvije decimale

        double mirovinskoOsiguranje = (int) (brutoDohodak * 0.20 * 100) / 100.0; //Od bruto place se oduzima 20 posto za mirovinsko

        double dohodak = (int) (brutoDohodak - mirovinskoOsiguranje) * 100 / 100.0;

        double odbitak = osobniOdbitak * 2600;                // 2600 kn porezna olaksica koja moze biti sve do 2.200 kn

        double poreznaOsnovica = 0;

        if (dohodak <= odbitak)
            poreznaOsnovica = 0;
        else
            poreznaOsnovica = dohodak - odbitak;

        double osnovica = (int) (poreznaOsnovica * 100) / 100.0;


        //Porez

        double porez = 1;

        if (poreznaOsnovica <= 2200.0)                    //do 2.200 kn porez je 12%
            porez = poreznaOsnovica * 0.12;
        else if (poreznaOsnovica > 2200.0 && poreznaOsnovica <= 8800.0)    //od 2.200 kn do 8.800 kn porez je 12%
            porez = 264.00 + (poreznaOsnovica - 2200.0) * 0.25;
        else                                //preko 8.800 kn porez je 40%
            porez = 2464.00 + (poreznaOsnovica - 8800.0) * 0.4;

        //Porez i prirez ukupno - pip

        double postotak = prirez / 100;                    // pretvorba iz postotka u broj
        prirez = (int) (postotak * porez * 100) / 100.0;
        double pip = (int) ((porez + prirez) * 100) / 100.0;

        //Neto placa

        double neto = (int) ((brutoDohodak - mirovinskoOsiguranje - pip) * 100) / 100.0;

        //Ispis dobivenih rezultata u message box-u

        String output = "Bruto dohodak: " + (int) (brutoDohodak * 100) / 100.0 +
                "\nMirovinsko: " + mirovinskoOsiguranje +
                "\nDohodak: " + (int) (dohodak * 100) / 100.0 +
                "\nOsobni odbitak: " + (int) (odbitak * 100) / 100.0 +
                "\nOsnovica za obra�un poreza: " + osnovica +
                "\nUkupni porez: " + porez +
                "\nPrirez: " + prirez +
                "\nUkupni porez i prirez: " + pip +
                "\nNeto dohodak: " + neto;

        JOptionPane.showMessageDialog(null, output);
    }
}