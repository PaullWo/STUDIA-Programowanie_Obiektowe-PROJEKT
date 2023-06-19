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

public class OknoPlatnosci extends JFrame{
        //Panele
    private JPanel panel_logo;
    private final JPanel panel_sklep;
    private final JPanel panel_klawiatura;
    private final JPanel panel_placenie;
    //Pola tekstowe

    //Przyciski

    //Listy

    
    public OknoPlatnosci(){
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
        panel_sklep = new JPanel();
        panel_sklep.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel_sklep.setBackground(Color.decode("#ffffcc"));
        panel_sklep.setPreferredSize(new Dimension(884, 489));
        panel_sklep.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_sklep);
        //Panel z klawiatura numeryczna
        panel_klawiatura = new JPanel();
        panel_klawiatura.setBackground(Color.decode("#ffffcc"));
        panel_klawiatura.setPreferredSize(new Dimension(528, 485));
        panel_klawiatura.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_klawiatura);

        //Panel z placeniem
        panel_placenie = new JPanel();
        panel_placenie.setBackground(Color.decode("#ffffcc"));
        panel_placenie.setPreferredSize(new Dimension(350, 485));
        panel_placenie.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_placenie);

        
      //Obsluga przyciskow
      
        setVisible(true);
        setResizable(false);

    }
}
