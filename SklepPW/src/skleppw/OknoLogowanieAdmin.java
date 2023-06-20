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


public class OknoLogowanieAdmin extends JFrame{
    private Sklep sklepROPUCHA;
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_logowanie;
    //Pola tekstowe
    private final JTextField textfield_login;
    private final JTextField textfield_haslo;
    //Przyciski
    private final JButton button_zaloguj;

    
    public OknoLogowanieAdmin(Sklep sklep){
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
        JPanel panel_logowanie1=new JPanel();
        panel_logowanie1.setLayout(new GridBagLayout());
        panel_logowanie1.setBackground(Color.decode("#ffffcc"));
        panel_logowanie1.setPreferredSize(new Dimension(884, 466));
        panel_logowanie1.setBounds(0,100,884,462);
        panel_logowanie1.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_logowanie1);
        panel_logowanie = new JPanel();
        panel_logowanie.setLayout(new GridLayout(0,2,10,10));
        panel_logowanie.setBackground(Color.decode("#ffffcc"));
        panel_logowanie.setPreferredSize(new Dimension(180, 90));
        panel_logowanie1.add(panel_logowanie);
        textfield_login = new JTextField(17);
        textfield_login.setBorder(BorderFactory.createLineBorder(Color.black));
        textfield_haslo = new JTextField(17);
        textfield_haslo.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_logowanie.add(new JLabel("Login:"));
        panel_logowanie.add(textfield_login);
        panel_logowanie.add(new JLabel("Hasło: "));
        panel_logowanie.add(textfield_haslo);
        button_zaloguj = new JButton("Zaloguj");
        button_zaloguj.setBackground(Color.decode("#999966"));
        button_zaloguj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_logowanie.add(button_zaloguj);
      //Dodawanie paska menu
        JMenuBar mb=new JMenuBar();  
        JMenu menu=new JMenu("Menu");
        JMenuItem menu_opcja1=new JMenuItem("Zaloguj jako pracownik");
        menu.add(menu_opcja1);
        mb.add(menu);
        setJMenuBar(mb);
        
      //Obsluga przyciskow
        //Przycisk "Zaloguj"
        button_zaloguj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login=textfield_login.getText();
                String haslo=textfield_haslo.getText();
                if("admin".equals(login) && "admin".equals(haslo)){
                    dispose();
                    JFrame f=new OknoAdmin(sklepROPUCHA);
                }else{
                    JOptionPane.showMessageDialog(panel_logowanie,"Dane podane do logowania są nieprawidłowe!");
                }
            }
        });
        setVisible(true);
        setResizable(false);
    }
}
