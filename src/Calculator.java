import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* "public" znaci da se metoda moze pozvati od strane objekata drugog tipa*/

public class Calculator {
    /*"static" slicno kao i "public" znaci da je metoda povezana s klasom, ali ne i sa specificnim objektima te klase. Sto znaci da mozemo kreirati "static class" metodu bez da kreiramo objekte od te klase*/
    /*"void" znaci da metoda nevraca vrijednost, primjerice ako metoda vraca "int" (intager ili cijelobrojnu vrijednost) nece ispisati njegovu vrijednost te bi onda koristili "int" umjesto "void".*/
    public static void main(String[] args) {
        /* Kreiranje novog programskog sucelja */
        JPanel windowContent = new JPanel();

        /* Kreiranje labela i podrucija za unos teksta*/
        JLabel l1 = new JLabel("Prvi Broj:");
        JTextField f1 = new JTextField(8);
        JLabel l2 = new JLabel("Drugi Broj:");
        JTextField f2 = new JTextField(8);
        JLabel l3 = new JLabel("Rezultat:");
        JTextField r = new JTextField(15);
        /* "r.setEditable(false)"- kako bi neomogucili unosenje unutar podrucija rezerviranog za rezultat*/
        r.setEditable(false);
        /* Kreiranje funkciskih tipki i stvaranje dogadaja za svaki gumb */
        JButton go = new JButton("Zbroji");
        go.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                /* "Double.parseDouble" je slican kao i "valueOf()", razlika je sto "parseDouble" vraca klasu "double" sa vrijednoscu odredengo stringa, dok "valueOf" vraca vec pohranjenu vrijednost klase*/
                double r1 = (Double.parseDouble(f1.getText()) + Double.parseDouble(f2.getText()));
                r.setText(String.valueOf(r1));
            }
        });

        JButton go1 = new JButton("Oduzmi");
        go1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                double r2 = (Double.parseDouble(f1.getText()) - Double.parseDouble(f2.getText()));
                r.setText(String.valueOf(r2));

            }
        });

        JButton go2 = new JButton("Pomnozi");
        go2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double r3 = (Double.parseDouble(f1.getText()) * Double.parseDouble(f2.getText()));
                r.setText(String.valueOf(r3));
            }
        });

        JButton go3 = new JButton("Podjeli");
        go3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double r4 = (Double.parseDouble(f1.getText()) / Double.parseDouble(f2.getText()));
                r.setText(String.valueOf(r4));
            }
        });

        JButton go4 = new JButton("Obrisi");
        go4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f2.setText("");
                r.setText("");
            }
        });
        JButton go5 = new JButton("Ostatak pri djeljenju");
        go5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double r5 = (Double.parseDouble(f1.getText()) % Double.parseDouble(f2.getText()));
                r.setText(String.valueOf(r5));
            }
        });
        JButton pop = new JButton("O programu");
        pop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Filip Pandi\n20.7.2015\n1.0v");
            }
        });

        /* Odvojeno dodavanje komponenata (labela, tekst podrucija i gumba) unutar okvira programa. Obicno se dodaje odmah nakon kreiranja "panel-a". Primjerice JPanel ~ime panel-a~ = new JPanel(); ~ime panel-a~.add(~ime gumba,tekst podrucija ili slicno~ predhodno kreiranog);*/

        windowContent.add(l1);
        windowContent.add(f1);
        windowContent.add(l2);
        windowContent.add(l3);
        windowContent.add(f2);
        windowContent.add(l3);
        windowContent.add(r);
        windowContent.add(go);
        windowContent.add(go1);
        windowContent.add(go2);
        windowContent.add(go3);
        windowContent.add(go5);
        windowContent.add(go4);
        windowContent.add(pop);


        /* Odredivanje velicine, imena i vrste samog okvira sucelja */

        JFrame frame = new JFrame();
        frame.setTitle("Kalkulator 1.0v");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(windowContent);

        frame.setSize(600, 150);
        frame.setVisible(true);

    }
}