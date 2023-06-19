package skleppw;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class OknoSklep extends JFrame{
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_sklep;
    private final JPanel panel_towary;
    private final JPanel panel_koszyk;
    //Pola tekstowe

    //Przyciski

    
    public OknoSklep(){
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
        panel_sklep = new JPanel();
        panel_sklep.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel_sklep.setBackground(Color.decode("#ffffcc"));
        panel_sklep.setPreferredSize(new Dimension(884, 466));
        panel_sklep.setBounds(0,100,884,462);
        panel_sklep.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_sklep);
        //Panel z towarami
        panel_towary = new JPanel();
        panel_towary.setLayout(new GridBagLayout());
        panel_towary.setBackground(Color.decode("#ffffcc"));
        panel_towary.setPreferredSize(new Dimension(528, 461));
        panel_towary.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_towary);
          //Tabela z produktami
          
          
          
        //Panel z koszykiem
        panel_koszyk = new JPanel();
        //panel_logowanie2.setLayout(new GridBagLayout());
        panel_koszyk.setBackground(Color.decode("#ffffcc"));
        panel_koszyk.setPreferredSize(new Dimension(350, 461));
        panel_koszyk.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_koszyk);
          //Koszyk, tabela z zamowieniem, kwota, usun element, zapłać
          
          
          
      //Dodawanie paska menu
        JMenuBar mb=new JMenuBar();  
        JMenu menu=new JMenu("Menu");
        JMenuItem menu_opcja1=new JMenuItem("Zaloguj jako pracownik");
        menu.add(menu_opcja1);
        mb.add(menu);
        setJMenuBar(mb);
        
        setVisible(true);
        setResizable(false);
    }
}
