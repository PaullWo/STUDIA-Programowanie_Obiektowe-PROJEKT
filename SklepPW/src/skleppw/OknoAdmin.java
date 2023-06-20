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
    private final JButton button_usun;
    private final JButton button_edytuj;
    private final JButton button_dodaj;
    private final JButton button_wplatomat;
    private final JButton button_drukarka;
    private final JButton button_awarie;
    //Label
    //private final JLabel label_lista;
    private final JLabel label_edycja;
    private final JLabel label_dodawanie;
    private final JLabel label_wplatomat;
    private final JLabel label_drukarka;
    
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
        panel_logowanie.setPreferredSize(new Dimension(884, 466));
        panel_logowanie.setBounds(0,100,884,462);
        panel_logowanie.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_logowanie);
        panel_lewy = new JPanel();
        panel_lewy.setLayout(new GridLayout(0,2,10,10));
        panel_lewy.setBackground(Color.decode("#ffffcc"));
        panel_lewy.setPreferredSize(new Dimension(400, 450));
        panel_logowanie.add(panel_lewy);
        panel_prawy = new JPanel();
        panel_prawy.setLayout(new GridLayout(0,2,10,10));
        panel_prawy.setBackground(Color.decode("#ffffcc"));
        panel_prawy.setPreferredSize(new Dimension(400, 450));
        panel_logowanie.add(panel_prawy);
        
        label_edycja=new JLabel("USUN/EDYTUJ TOWAR:");
        panel_prawy.add(label_edycja);
        panel_prawy.add(new JLabel(""));
        panel_prawy.add(new JLabel("Podaj nazwe edytowanego towaru:"));
        textfield_nazwa = new JTextField(10);
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
        panel_prawy.add(new JLabel("Aktualna ilość: "+sklepROPUCHA.getWplatomat().getIloscPieniedzy()));
        
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
        panel_prawy.add(new JLabel("Aktualna ilość: "+sklepROPUCHA.getDrukarka().getIloscPapieru()));
        
        button_awarie = new JButton("Sprawdź awarie");
        button_awarie.setBackground(Color.decode("#999966"));
        button_awarie.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_prawy.add(button_awarie);


     
      //Obsluga przyciskow
        //Przycisk "usun"
        button_usun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        //Przycisk "edytuj"
        button_edytuj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        //Przycisk "dodaj"
        button_dodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        //Przycisk "zmien" dla wplatomatu
        button_wplatomat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        //Przycisk "zmien" dla drukarki
        button_drukarka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        //Przycisk "sprawdz Awarie"
        button_awarie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        setVisible(true);
        setResizable(false);
    }
}
