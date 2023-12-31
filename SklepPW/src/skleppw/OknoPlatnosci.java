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
    private int zalogowanie;
    private Sklep sklepROPUCHA;
    private Uzytkownik uzytkownik;
    private String pomocnicza_wpisanakwota="";
    //Panele
    private JPanel panel_logo;
    private final JPanel panel_sklep;
    private final JPanel panel_klawiatura;
    private final JPanel panel_placenie1;
    private final JPanel panel_placenie;
    //Pola tekstowe
    private final JTextField textfield_kwota;
    //Przyciski
    private final JButton button_1;
    private final JButton button_2;
    private final JButton button_3;
    private final JButton button_4;
    private final JButton button_5;
    private final JButton button_6;
    private final JButton button_7;
    private final JButton button_8;
    private final JButton button_9;
    private final JButton button_0;
    private final JButton button_kropka;
    private final JButton button_usun;
    private final JButton button_zaplac;
    //Label
    private JLabel label_kwota;
    private JLabel label_reszta;
    //Radiobutton
    private JRadioButton radio_rachunek;
    private JRadioButton radio_faktura;


    public OknoPlatnosci(int zalogowanie,Uzytkownik uzytkownik,Sklep sklep){
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
        panel_sklep = new JPanel();
        panel_sklep.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel_sklep.setBackground(Color.decode("#ffffcc"));
        panel_sklep.setPreferredSize(new Dimension(884, 489));
        panel_sklep.setBorder(BorderFactory.createLineBorder(Color.black,3));
        add(panel_sklep);
        //Panel z klawiatura numeryczna
        panel_klawiatura = new JPanel(new GridLayout(4,3,2,2));
        panel_klawiatura.setBackground(Color.decode("#ffffcc"));
        panel_klawiatura.setPreferredSize(new Dimension(528, 485));
        panel_klawiatura.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_klawiatura);
        //Dodawanie przyciskow klawiatury +ładnie by wyglądało zmienić kolory aktywnych buttonow
        button_1 = new JButton("<html><font size='10' color='white'>1</font></html>");
        button_1.setBackground(Color.decode("#1f1f1f"));
        button_1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_1);
        button_2 = new JButton("<html><font size='10' color='white'>2</font></html>");
        button_2.setBackground(Color.decode("#1f1f1f"));
        button_2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_2);
        button_3 = new JButton("<html><font size='10' color='white'>3</font></html>");
        button_3.setBackground(Color.decode("#1f1f1f"));
        button_3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_3);
        button_4 = new JButton("<html><font size='10' color='white'>4</font></html>");
        button_4.setBackground(Color.decode("#1f1f1f"));
        button_4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_4);
        button_5 = new JButton("<html><font size='10' color='white'>5</font></html>");
        button_5.setBackground(Color.decode("#1f1f1f"));
        button_5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_5);
        button_6 = new JButton("<html><font size='10' color='white'>6</font></html>");
        button_6.setBackground(Color.decode("#1f1f1f"));
        button_6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_6);
        button_7 = new JButton("<html><font size='10' color='white'>7</font></html>");
        button_7.setBackground(Color.decode("#1f1f1f"));
        button_7.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_7);
        button_8 = new JButton("<html><font size='10' color='white'>8</font></html>");
        button_8.setBackground(Color.decode("#1f1f1f"));
        button_8.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_8);
        button_9 = new JButton("<html><font size='10' color='white'>9</font></html>");
        button_9.setBackground(Color.decode("#1f1f1f"));
        button_9.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_9);
        button_0 = new JButton("<html><font size='10' color='white'>0</font></html>");
        button_0.setBackground(Color.decode("#1f1f1f"));
        button_0.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_0);
        button_kropka = new JButton("<html><font size='10' color='white'>.</font></html>");
        button_kropka.setBackground(Color.decode("#1f1f1f"));
        button_kropka.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_kropka);
        button_usun = new JButton("<html><font size='10' color='white'>usuń</font></html>");
        button_usun.setBackground(Color.decode("#1f1f1f"));
        button_usun.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_klawiatura.add(button_usun);
        
        //Panel z placeniem
        panel_placenie1 = new JPanel(new GridBagLayout());
        panel_placenie1.setBackground(Color.decode("#ffffcc"));
        panel_placenie1.setPreferredSize(new Dimension(350, 485));
        panel_placenie1.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_placenie1);
        panel_placenie = new JPanel(new GridLayout(0,1,10,10));
        panel_placenie.setBackground(Color.decode("#ffffcc"));
        panel_placenie.setPreferredSize(new Dimension(150, 200));
        panel_placenie1.add(panel_placenie);
        label_kwota = new JLabel("Kwota do zapłaty: "+sklepROPUCHA.getOstatniZakup().getKoszt()+"zł");  //Dodac sumowanie!!
        panel_placenie.add(label_kwota);
        panel_placenie.add(new JLabel("Wpisana kwota: "));
        textfield_kwota = new JTextField(10);
        panel_placenie.add(textfield_kwota);
        //label_reszta = new JLabel("Reszta: "+100+"zł");  //Dodac obliczenia!
        //panel_placenie.add(label_reszta);
        radio_rachunek=new JRadioButton("rachunek");
        radio_rachunek.setBackground(Color.decode("#ffffcc"));
        panel_placenie.add(radio_rachunek);
        radio_faktura=new JRadioButton("faktura");
        radio_faktura.setBackground(Color.decode("#ffffcc"));
        panel_placenie.add(radio_faktura);
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radio_rachunek);
        bgroup.add(radio_faktura);
        button_zaplac=new JButton("Zapłać");
        button_zaplac.setBackground(Color.decode("#999966"));
        button_zaplac.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
        panel_placenie.add(button_zaplac);

      //Obsluga przyciskow
        //Przycisk "Zapłać"
        button_zaplac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    double pomoc= Double.parseDouble(pomocnicza_wpisanakwota);
                    if(pomoc<sklepROPUCHA.getOstatniZakup().getKoszt()) throw new ArithmeticException("Za mała kwota aby zapłacić!");
                    sklepROPUCHA.getOstatniZakup().setZaplaconaKwota(pomoc);
                    if(radio_rachunek.isSelected()){
                    dispose();
                    JFrame frachunek=new OknoRachunek(zalogowanie,uzytkownik,sklepROPUCHA);
                }else if(radio_faktura.isSelected()){
                    if(zalogowanie==1){
                        dispose();
                        JFrame ffaktura1=new OknoFakturaDane(uzytkownik.getImie(),uzytkownik.getMiesiac(),uzytkownik.getDzien(),uzytkownik.getMiesiac(),uzytkownik.getRok(),uzytkownik.getMiejscowosc(),zalogowanie,uzytkownik,sklepROPUCHA);
                    }else{
                        dispose();
                        JFrame ffaktura2=new OknoFaktura(zalogowanie,uzytkownik,sklepROPUCHA);
                    }
                }else{
                    //Okno dialogowe z komunikatem
                    JOptionPane.showMessageDialog(panel_placenie,"Wybierz fakturę/rachunek."); 
                }
                }catch(NumberFormatException f){
                        JOptionPane.showMessageDialog(panel_sklep,"Błedny typ danych! Spróbuj ponownie."); 
                }catch(ArithmeticException g){
                        JOptionPane.showMessageDialog(panel_sklep,g.getMessage()); 
                }
                
            }
        });
        //Przycisk "1"
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="1";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "2"
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="2";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "3"
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="3";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "4"
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="4";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "5"
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="5";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "6"
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="6";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "7"
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="7";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "8"
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="8";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "9"
        button_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="9";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "."
        button_kropka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+=".";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "usun"
        button_usun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota="";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        //Przycisk "0"
        button_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pomocnicza_wpisanakwota+="0";
                textfield_kwota.setText(pomocnicza_wpisanakwota);
            }
        });
        
        setVisible(true);
        setResizable(false);

    }
}