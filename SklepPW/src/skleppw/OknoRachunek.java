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

public class OknoRachunek extends JFrame{
    private int zalogowanie;
    private Sklep sklepROPUCHA;
    private Uzytkownik uzytkownik;
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_sklep;
    private final JPanel panel_sklep1;
    //Przyciski
    private final JButton button_wroc;
    //Label
    private final JLabel label_rachunek;
    public OknoRachunek(int zalogowanie,Uzytkownik uzytkownik,Sklep sklep){
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
        panel_sklep.setLayout(new BoxLayout(panel_sklep, BoxLayout.PAGE_AXIS));
        panel_sklep.setBackground(Color.decode("#ffffcc"));
        panel_sklep1.add(panel_sklep);
        //Wyswietlanie rachunku
        label_rachunek=new JLabel("<html>Tu bedzie tresc<br>zamowienia.</html>");   //Dodac funkcjonalnosc tego!!
        label_rachunek.setOpaque(true);
        label_rachunek.setBackground(Color.decode("#FFFFFF"));
        label_rachunek.setPreferredSize(new Dimension(100, 300));
        JScrollPane scroll_rachunek = new JScrollPane();
        scroll_rachunek.setViewportView(label_rachunek);
        scroll_rachunek.setPreferredSize(new Dimension(100, 320));
        scroll_rachunek.setBorder(BorderFactory.createLineBorder(Color.black,1));
        panel_sklep.add(scroll_rachunek);
        panel_sklep.add(new JLabel("Dziękujemy za dokonanie zakupu!"));
        button_wroc= new JButton("Wróc do sklepu");
        button_wroc.setBackground(Color.decode("#999966"));
        button_wroc.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_sklep.add(button_wroc);
      //Obsluga przyciskow
        //Przycisk "Wróc do sklepu"
        button_wroc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    JFrame f=new OknoGlowne();    
            }
        });
        setVisible(true);
        setResizable(false);

    }
}
