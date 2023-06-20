package skleppw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

//Okno do wprowadzania danych
public class OknoWprowadzanieDanych extends JFrame{
    private int zalogowanie;
    private Sklep sklepROPUCHA;
    private Uzytkownik uzytkownik;
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_sklep;
    private final JPanel panel_sklep1;

    //Pola tekstowe
    private JTextField textfield_imie;
    private JTextField textfield_nazwisko;
    private JTextField textfield_miejscowosc;
    private JTextField textfield_rok;
    //Combobox
    private JComboBox combobox_dzien;
    private JComboBox combobox_miesiac;
    //Przyciski
    private final JButton button_zatwierdz;

    public OknoWprowadzanieDanych(int zalogowanie,Uzytkownik uzytkownik,Sklep sklep){
        this.zalogowanie=zalogowanie;
        this.uzytkownik=uzytkownik;
        sklepROPUCHA=sklep;
        setTitle("SKLEP ROPUCHA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setSize(900, 628);
      //Ustawienie ikony na pasku
        ImageIcon ikona = new ImageIcon("ikona.png");
        setIconImage(ikona.getImage());
      //Tworzenie dwóch paneli(gorny logo, dolny logowanie i info)
        panel_logo = new JPanel();
        panel_logo.setBackground(Color.decode("#999966"));
        panel_logo.setPreferredSize(new Dimension(884, 100));
        panel_logo.setBounds(0,0,884,100);
        panel_logo.setBorder(BorderFactory.createLineBorder(Color.black,3));
        //Ustawianie tła logo
        BufferedImage logo;
        try {
            logo = ImageIO.read(new File("logo.png"));
            JLabel ikona_label = new JLabel(new ImageIcon(logo));
            panel_logo.add(ikona_label);
        } catch (IOException ex) {
            Logger.getLogger(OknoGlowne.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(panel_logo);
      //Panel dolny
        panel_sklep1 = new JPanel();
        panel_sklep1.setLayout(new GridBagLayout());
        panel_sklep1.setBackground(Color.decode("#ffffcc"));
        panel_sklep1.setPreferredSize(new Dimension(884, 489));
        panel_sklep1.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_sklep1);
        panel_sklep = new JPanel();
        panel_sklep.setLayout(new GridLayout(0,2,10,10));
        panel_sklep.setBackground(Color.decode("#ffffcc"));
        panel_sklep.setPreferredSize(new Dimension(300, 250));
        panel_sklep1.add(panel_sklep);
        panel_sklep.add(new JLabel("Podaj dane do faktury: "));
        panel_sklep.add(new JLabel(" "));
        panel_sklep.add(new JLabel("Imię: "));
        textfield_imie = new JTextField(10);
        panel_sklep.add(textfield_imie);
        panel_sklep.add(new JLabel("Nazwisko: "));
        textfield_nazwisko = new JTextField(10);
        panel_sklep.add(textfield_nazwisko);
        panel_sklep.add(new JLabel("Miejscowość: "));
        textfield_miejscowosc = new JTextField(10);
        panel_sklep.add(textfield_miejscowosc);
        panel_sklep.add(new JLabel("Dzien urodzenia: "));
        String[] dni=new String[31];
        for(int i=0;i<31;i++){
            dni[i]=Integer.toString(i+1);
        }
        combobox_dzien=new JComboBox(dni);
        panel_sklep.add(combobox_dzien);
        panel_sklep.add(new JLabel("Miesiąc urodzenia: "));
        String[] miesiace={"styczeń","luty","marzec","kwiecień","maj","czerwiec","lipiec","sierpień","wrzesień","październik","listopad","grudzień"};
        combobox_miesiac=new JComboBox(miesiace);
        panel_sklep.add(combobox_miesiac);
        panel_sklep.add(new JLabel("Rok urodzenia: "));
        textfield_rok = new JTextField(10);
        panel_sklep.add(textfield_rok);
        button_zatwierdz = new JButton("Zatwierdź");
        button_zatwierdz.setBackground(Color.decode("#999966"));
        button_zatwierdz.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_sklep.add(button_zatwierdz);
  
      //Obsluga przyciskow
        button_zatwierdz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textfield_imie.getText().isEmpty() || textfield_nazwisko.getText().isEmpty() || textfield_miejscowosc.getText().isEmpty() || textfield_rok.getText().isEmpty()
                        || combobox_dzien.getSelectedItem()==null || combobox_miesiac.getSelectedItem()==null){
                    //Okno dialogowe z komunikatem
                    JOptionPane.showMessageDialog(panel_sklep,"Wypełnij wszytskie pola!"); 
                }else{
                    try{
                    String imie=textfield_imie.getText();
                    String nazwisko=textfield_nazwisko.getText();
                    String miejscowosc=textfield_miejscowosc.getText();
                    String dzien=(String)combobox_dzien.getSelectedItem();
                    String miesiac=(String)combobox_miesiac.getSelectedItem();
                    String rok=textfield_rok.getText();
                    int rokInt=Integer.parseInt(rok);
                    if(rokInt<1900 || rokInt >2023) throw new ArithmeticException("Błedny rok!");
                    uzytkownik.ustawDane(imie, nazwisko, miejscowosc, dzien, miesiac, rok);
                    sklepROPUCHA.getUzytkownikID(sklepROPUCHA.logowanie(uzytkownik.getLogin(), uzytkownik.getHaslo())).ustawDane(imie, nazwisko, miejscowosc, dzien, miesiac, rok);
                    JOptionPane.showMessageDialog(panel_sklep,"Dane zostały zapamietane!");
                    dispose();
                    JFrame f=new OknoSklep(zalogowanie,uzytkownik,sklepROPUCHA);  
                    }catch(NumberFormatException f){
                        JOptionPane.showMessageDialog(panel_sklep,"Błedny typ danych! Spróbuj ponownie."); 
                    }catch(ArithmeticException g){
                        JOptionPane.showMessageDialog(panel_sklep,g.getMessage()); 
                    }
                }
            }
        });
        setVisible(true);
        setResizable(false);

    }
}