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

public class OknoAdmin extends JFrame{
    private Sklep sklepROPUCHA;
    private DefaultListModel<String> model;
    //Panele
    private JPanel panel_logo;
    private JPanel panel_logowanie;
    private final JPanel panel_lewy;
    private final JPanel panel_prawy;
    //Pola tekstowe
    private final JTextField textfield_nazwa;
    private final JTextField textfield_nazwa_nowa;
    private final JTextField textfield_cena_nowa;
    private final JTextField textfield_ilosc_nowa;
    private final JTextField textfield_nazwa_dodaj;
    private final JTextField textfield_cena_dodaj;
    private final JTextField textfield_ilosc_dodaj;
    private final JTextField textfield_ilosc_papieru;
    private final JTextField textfield_ilosc_pieniedzy;
    //Buttony
    private final JButton button_usun;
    private final JButton button_edytuj;
    private final JButton button_dodaj;
    private final JButton button_wplatomat;
    private final JButton button_drukarka;
    private final JButton button_awarie;
    private final JButton button_wyloguj;
    
    //Label
    private final JLabel label_edycja;
    private final JLabel label_dodawanie;
    private final JLabel label_wplatomat;
    private final JLabel label_drukarka;
    private JLabel label_papier;
    private JLabel label_pieniadze;
    private JList lista_produktow;
    public OknoAdmin(Sklep sklep){
        sklepROPUCHA=sklep;
        setTitle("SKLEP ROPUCHA-tryb administratora");
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
        JPanel panel_logowanie=new JPanel();
        panel_logowanie.setLayout(new GridBagLayout());
        panel_logowanie.setBackground(Color.decode("#ffffcc"));
        panel_logowanie.setPreferredSize(new Dimension(884, 490));
        panel_logowanie.setBounds(0,100,884,462);
        panel_logowanie.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_logowanie);
        panel_lewy = new JPanel();
        panel_lewy.setLayout(new GridLayout(0,2,10,10));
        panel_lewy.setBackground(Color.decode("#ffffcc"));
        panel_lewy.setPreferredSize(new Dimension(400, 450));
        panel_logowanie.add(panel_lewy);
        //Lista towarow
        model = sklepROPUCHA.getListaTowarowWyswietlAdmin();
        lista_produktow = new JList(model);
        //Scroll do listy
        JScrollPane scroll_lista_produktow = new JScrollPane();
        scroll_lista_produktow.setViewportView(lista_produktow);
        panel_lewy.add(scroll_lista_produktow);
        panel_prawy = new JPanel();
        panel_prawy.setLayout(new GridLayout(0,2,10,10));
        panel_prawy.setBackground(Color.decode("#ffffcc"));
        panel_prawy.setPreferredSize(new Dimension(450, 450));
        panel_logowanie.add(panel_prawy);
        
        label_edycja=new JLabel("USUN/EDYTUJ TOWAR:");
        panel_prawy.add(label_edycja);
        panel_prawy.add(new JLabel(""));
        panel_prawy.add(new JLabel("Podaj nazwe edytowanego towaru:"));
        textfield_nazwa = new JTextField(10);
        textfield_nazwa.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_nazwa);
        button_usun = new JButton("Usuń");
        button_usun.setBackground(Color.decode("#999966"));
        button_usun.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_usun);
        panel_prawy.add(new JLabel(""));
        
        panel_prawy.add(new JLabel("Nowa nazwa:"));
        textfield_nazwa_nowa = new JTextField(10);
        textfield_nazwa_nowa.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_nazwa_nowa);
        panel_prawy.add(new JLabel("Nowa cena:"));
        textfield_cena_nowa = new JTextField(10);
        textfield_cena_nowa.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_cena_nowa);
        panel_prawy.add(new JLabel("Nowa ilosc:"));
        textfield_ilosc_nowa = new JTextField(10);
        textfield_ilosc_nowa.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_ilosc_nowa);
        button_edytuj = new JButton("Edytuj");
        button_edytuj.setBackground(Color.decode("#999966"));
        button_edytuj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_edytuj);
        panel_prawy.add(new JLabel(""));
        
        label_dodawanie=new JLabel("DODAJ TOWAR:");
        panel_prawy.add(label_dodawanie);
        panel_prawy.add(new JLabel(""));
        panel_prawy.add(new JLabel("Nazwa:"));
        textfield_nazwa_dodaj = new JTextField(10);
        textfield_nazwa_dodaj.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_nazwa_dodaj);
        panel_prawy.add(new JLabel("Cena:"));
        textfield_cena_dodaj = new JTextField(10);
        textfield_cena_dodaj.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_cena_dodaj);
        panel_prawy.add(new JLabel("Ilosc:"));
        textfield_ilosc_dodaj = new JTextField(10);
        textfield_ilosc_dodaj.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_ilosc_dodaj);
        button_dodaj = new JButton("Dodaj");
        button_dodaj.setBackground(Color.decode("#999966"));
        button_dodaj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_dodaj);
        panel_prawy.add(new JLabel(""));
        
        label_wplatomat=new JLabel("WPŁATOMAT:");
        panel_prawy.add(label_wplatomat);
        panel_prawy.add(new JLabel(""));
        panel_prawy.add(new JLabel("Nowa ilość pieniędzy:"));
        textfield_ilosc_pieniedzy = new JTextField(10);
        textfield_ilosc_pieniedzy.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_ilosc_pieniedzy);
        button_wplatomat = new JButton("Zmień");
        button_wplatomat.setBackground(Color.decode("#999966"));
        button_wplatomat.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_wplatomat);
        label_pieniadze=new JLabel("Aktualna ilość: "+sklepROPUCHA.getWplatomat().getIloscPieniedzy());
        panel_prawy.add(label_pieniadze);
        
        label_drukarka=new JLabel("DRUKARKA:");
        panel_prawy.add(label_drukarka);
        panel_prawy.add(new JLabel(""));
        panel_prawy.add(new JLabel("Nowa ilość papieru:"));
        textfield_ilosc_papieru = new JTextField(10);
        textfield_ilosc_papieru.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_prawy.add(textfield_ilosc_papieru);
        button_drukarka = new JButton("Zmień");
        button_drukarka.setBackground(Color.decode("#999966"));
        button_drukarka.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_drukarka);
        label_papier=new JLabel("Aktualna ilość: "+sklepROPUCHA.getDrukarka().getIloscPapieru());
        panel_prawy.add(label_papier);
        
        button_awarie = new JButton("Sprawdź awarie");
        button_awarie.setBackground(Color.decode("#999966"));
        button_awarie.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_awarie);
        panel_prawy.add(new JLabel(""));
        button_wyloguj = new JButton("Zapisz i wyloguj");
        button_wyloguj.setBackground(Color.decode("#999966"));
        button_wyloguj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_wyloguj);


     
      //Obsluga przyciskow
        //Przycisk "usun"
        button_usun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nazwa=textfield_nazwa.getText();
                sklepROPUCHA.usunTowarNazwa(nazwa,panel_prawy);
            }
        });
        //Przycisk "edytuj"
        button_edytuj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String nazwa=textfield_nazwa.getText();
               String nazwa_nowa=textfield_nazwa_nowa.getText(); 
               int ilosc_nowa=Integer.parseInt(textfield_ilosc_nowa.getText()); 
               double cena_nowa=Double.parseDouble(textfield_cena_nowa.getText()); 
               sklepROPUCHA.edytujTowarNazwa(nazwa, panel_prawy, nazwa_nowa, cena_nowa, ilosc_nowa);
            }
        });
        //Przycisk "dodaj"
        button_dodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String nazwa=textfield_nazwa.getText();
               String nazwa_dodaj=textfield_nazwa_dodaj.getText(); 
               int ilosc_dodaj=Integer.parseInt(textfield_ilosc_dodaj.getText());
               double cena_dodaj=Double.parseDouble(textfield_cena_dodaj.getText());
               TowarSklep towar=new TowarSklep(nazwa_dodaj,cena_dodaj,ilosc_dodaj);
               sklepROPUCHA.dodajTowar(towar);
               model.addElement(towar.opisTowarSklep());
            }
        });
        //Przycisk "zmien" dla wplatomatu
        button_wplatomat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ilosc=Integer.parseInt(textfield_ilosc_pieniedzy.getText());
                sklepROPUCHA.getWplatomat().setIloscPieniedzy(ilosc);
                label_pieniadze.setText("Aktualna ilość: "+sklepROPUCHA.getWplatomat().getIloscPieniedzy());
            }
        });
        //Przycisk "zmien" dla drukarki
        button_drukarka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ilosc=Integer.parseInt(textfield_ilosc_papieru.getText());
                sklepROPUCHA.getDrukarka().setIloscPapieru(ilosc);
                label_papier.setText("Aktualna ilość: "+sklepROPUCHA.getDrukarka().getIloscPapieru());
            }
        });
        //Przycisk "sprawdz Awarie"
        button_awarie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               sklepROPUCHA.getWplatomat().sprawdzAwarie(panel_prawy);
               sklepROPUCHA.getDrukarka().sprawdzAwarie(panel_prawy);
            }
        });
        //Przycisk "Wyloguj"
        button_wyloguj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            //Zapis do pliku
            try {
                ObjectOutputStream plik;
                plik = new ObjectOutputStream(new FileOutputStream("bazadanych_sklepROPUCHA.ser"));
                plik.writeObject(sklepROPUCHA);
                plik.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OknoRachunek.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OknoRachunek.class.getName()).log(Level.SEVERE, null, ex);
            }
               dispose();
               JFrame f=new OknoGlowne(sklepROPUCHA); 
            }
        });
        setVisible(true);
        setResizable(false);
    }
}
