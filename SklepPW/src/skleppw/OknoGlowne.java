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

public class OknoGlowne extends JFrame{
    private int zalogowanie;
    private Sklep sklepROPUCHA;
    private Uzytkownik uzytkownik;
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_logowanie;
    private final JPanel panel_powitanie;
    private final JPanel panel_logowanie2;
    //Pola tekstowe
    private final JTextField textfield_login;
    private final JTextField textfield_haslo;
    //Przyciski
    private final JButton button_zaloguj;
    private final JButton button_zarejestruj;
    private final JButton button_gosc;
    
    public OknoGlowne(Sklep sklep){
        sklepROPUCHA=sklep;
        uzytkownik=null;
        zalogowanie=0;
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
        panel_logowanie = new JPanel();
        panel_logowanie.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel_logowanie.setBackground(Color.decode("#ffffcc"));
        panel_logowanie.setPreferredSize(new Dimension(884, 466));
        panel_logowanie.setBounds(0,100,884,462);
        panel_logowanie.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_logowanie);
        //Panel z komunikatem
        panel_powitanie = new JPanel();
        panel_powitanie.setLayout(new GridBagLayout());
        panel_powitanie.setBackground(Color.decode("#ffffcc"));
        panel_powitanie.setPreferredSize(new Dimension(350, 461));
        panel_powitanie.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_logowanie.add(panel_powitanie);
        JLabel label_powitanie= new JLabel("<html><center><font size='5'>Witamy w sklepie <e>\"Ropucha\"</e>!</font><br><font color=#535353 size='3'><i>*Jeśli chcesz dokonać kupna hurtowego stwórz konto,<br> jeśli interesuje Cię kupno detaliczne kontynuuj jako gość.*</i></font></html>");
        panel_powitanie.add(label_powitanie);
        //Panel z logowaniem
        panel_logowanie2 = new JPanel();
        //panel_logowanie2.setLayout(new GridBagLayout());
        panel_logowanie2.setBackground(Color.decode("#ffffcc"));
        panel_logowanie2.setPreferredSize(new Dimension(528, 461));
        panel_logowanie2.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_logowanie.add(panel_logowanie2);
        //Panel pomocniczy, żeby to ładnie wyśrodkować --wypadałoby to ogarnąc jakims ustawieniem layouta ale nwm jak adsjbjsa
        JPanel panel_pomoc1 = new JPanel();
        panel_pomoc1.setPreferredSize(new Dimension(490, 195));
        panel_pomoc1.setBackground(Color.decode("#ffffcc"));
        panel_logowanie2.add(panel_pomoc1);
        textfield_login = new JTextField(17);
        textfield_login.setBorder(BorderFactory.createLineBorder(Color.black));
        textfield_haslo = new JTextField(17);
        textfield_haslo.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_logowanie2.add(new JLabel("Login:"));
        panel_logowanie2.add(textfield_login);
        panel_logowanie2.add(new JLabel("Hasło: "));
        panel_logowanie2.add(textfield_haslo);
        button_zaloguj = new JButton("Zaloguj");
        button_zaloguj.setBackground(Color.decode("#999966"));
        button_zaloguj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_logowanie2.add(button_zaloguj);
        button_zarejestruj = new JButton("Zarejestruj");
        button_zarejestruj.setBackground(Color.decode("#999966"));
        button_zarejestruj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_logowanie2.add(button_zarejestruj);
        button_gosc = new JButton("Kontynuuj jako gość");
        button_gosc.setBackground(Color.decode("#999966"));
        button_gosc.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_logowanie2.add(button_gosc);
      //Dodawanie paska menu
        JMenuBar mb=new JMenuBar();  
        JMenu menu=new JMenu("Menu");
        JMenuItem menu_opcja1=new JMenuItem("Zaloguj jako pracownik");
        menu.add(menu_opcja1);
        menu_opcja1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame fadmin=new OknoLogowanieAdmin(sklepROPUCHA);
            }
        });
        mb.add(menu);
        setJMenuBar(mb);
        
      //Obsluga przyciskow
        //Przycisk "Kontynuuj jako gosc"
        button_gosc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame f=new OknoSklep(zalogowanie,uzytkownik,sklepROPUCHA);
            }
        });
        //Przycisk "Zarejestruj"
        button_zarejestruj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textfield_login.getText().isEmpty() || textfield_haslo.getText().isEmpty()){
                    //Okno dialogowe z komunikatem
                    JOptionPane.showMessageDialog(panel_logowanie2,"Wypełnij wszytskie pola!"); 
                }else{
                    String login=textfield_login.getText();
                    String haslo=textfield_haslo.getText();
                    Uzytkownik uzytkownik=new Uzytkownik(login,haslo);
                    sklepROPUCHA.dodajUzytkownika(uzytkownik, panel_logowanie2);
                }
            }
        });
        button_zaloguj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textfield_login.getText().isEmpty() || textfield_haslo.getText().isEmpty()){
                    //Okno dialogowe z komunikatem
                    JOptionPane.showMessageDialog(panel_logowanie2,"Wypełnij wszytskie pola!"); 
                }else{
                    String login=textfield_login.getText();
                    String haslo=textfield_haslo.getText();
                    if(sklepROPUCHA.logowanie(login, haslo)==-1){
                        JOptionPane.showMessageDialog(panel_logowanie2,"Dane podane do logowania są nieprawidłowe!");
                    }else{
                        zalogowanie=1;
                        uzytkownik=sklepROPUCHA.getUzytkownikID(sklepROPUCHA.logowanie(login, haslo));
                        if(uzytkownik.sprawdzDane()){
                            dispose();
                            JFrame fdane=new OknoWprowadzanieDanych(zalogowanie,uzytkownik,sklepROPUCHA);
                        }else{
                            dispose();
                            JFrame f=new OknoSklep(zalogowanie,uzytkownik,sklepROPUCHA);
                        }
                    }
                }
            }
        });
        setVisible(true);
        setResizable(false);
    }
}
