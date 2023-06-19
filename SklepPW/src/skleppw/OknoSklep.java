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
    private final JTextField textfield_ilosc;
    //Przyciski
    private final JButton button_dodaj;
    private final JButton button_usun;
    private final JButton button_zaplac;
    //Listy
    private JList lista_produktow;
    TowarySklep lista_towarow;
    private final JList lista_zamowien;
    
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
        panel_towary.setBackground(Color.decode("#ffffcc"));
        panel_towary.setPreferredSize(new Dimension(528, 461));
        panel_towary.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_towary);
          //Tabela z produktami
          lista_towarow= new TowarySklep();
          TowarSklep testtowar1=new TowarSklep("BUŁKA",2.99,70);
          TowarSklep testtowar2=new TowarSklep("CHLEB",4.50,20);
          TowarSklep testtowar3=new TowarSklep("MASŁO",7,50);
          TowarSklep testtowar4=new TowarSklep("KEFIR",3.2,20);
          TowarSklep testtowar5=new TowarSklep("MLEKO",4.5,60);
          TowarSklep testtowar6=new TowarSklep("COCA-COLA",7.5,50);
          TowarSklep testtowar7=new TowarSklep("PEPSI",7.6,20);
          TowarSklep testtowar8=new TowarSklep("CHUSTECZKI",4.5,30);
          TowarSklep testtowar9=new TowarSklep("RĘCZNIK PAPIEROWY",9.99,67);
          TowarSklep testtowar10=new TowarSklep("KURCZAK",15.2,20);
          TowarSklep testtowar11=new TowarSklep("MIĘSO MIELONE",9.99,30);
          TowarSklep testtowar12=new TowarSklep("KABANOSY",7.4,50);
          lista_towarow.dodajTowar(testtowar1);
          lista_towarow.dodajTowar(testtowar2);
          lista_towarow.dodajTowar(testtowar3);
          lista_towarow.dodajTowar(testtowar4);
          lista_towarow.dodajTowar(testtowar5);
          lista_towarow.dodajTowar(testtowar6);
          lista_towarow.dodajTowar(testtowar7);
          lista_towarow.dodajTowar(testtowar8);
          lista_towarow.dodajTowar(testtowar9);
          lista_towarow.dodajTowar(testtowar10);
          lista_towarow.dodajTowar(testtowar11);
          lista_towarow.dodajTowar(testtowar12);
          lista_produktow = new JList(lista_towarow.getListaTowarowWyswietl());
          //Scroll do listy
          JScrollPane scroll_lista_produktow = new JScrollPane();
          scroll_lista_produktow.setViewportView(lista_produktow);
          panel_towary.add(scroll_lista_produktow);
          //Style listy
          lista_produktow.setFixedCellHeight(50);
          lista_produktow.setFixedCellWidth(400);
          lista_produktow.setBackground(Color.decode("#cccc99"));
          lista_produktow.setSelectionBackground(Color.decode("#ffffcc"));
          lista_produktow.setBorder(BorderFactory.createLineBorder(Color.black,2));
          lista_produktow.setCellRenderer(getRenderer());
          
        //Panel z koszykiem
        panel_koszyk = new JPanel();
        panel_koszyk.setBackground(Color.decode("#ffffcc"));
        panel_koszyk.setPreferredSize(new Dimension(350, 461));
        panel_koszyk.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel_sklep.add(panel_koszyk);
          //Koszyk, tabela z zamowieniem, kwota, usun element, zapłać
          JPanel panel_koszyk2=new JPanel();
          panel_koszyk2.setBackground(Color.decode("#ffffcc"));
          panel_koszyk2.setPreferredSize(new Dimension(200, 80));
          panel_koszyk2.setBounds(0,0,200,90);
          //Ustawianie zdjęcia koszyka
          BufferedImage koszyk;
          try {
            koszyk = ImageIO.read(new File("koszyk.png"));
            JLabel koszyk_label = new JLabel(new ImageIcon(koszyk));
            panel_koszyk2.add(koszyk_label);
          } catch (IOException ex) {
            Logger.getLogger(OknoGlowne.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          //Panel z wyswietleniem zamowienia
          panel_koszyk.add(panel_koszyk2);
          JPanel panel_podglad_zamowienia=new JPanel();
          panel_podglad_zamowienia.setBackground(Color.decode("#ffffcc"));
          panel_podglad_zamowienia.setPreferredSize(new Dimension(300, 280));
          panel_podglad_zamowienia.setBounds(0,0,300,300);
          panel_koszyk.add(panel_podglad_zamowienia);
          lista_zamowien = new JList(lista_towarow.getListaTowarowWyswietl()); //zmienic na liste zamowien!!
          JScrollPane scroll_lista_zamowien = new JScrollPane();
          scroll_lista_zamowien.setViewportView(lista_zamowien);
          scroll_lista_zamowien.setPreferredSize(new Dimension(180, 250));
          scroll_lista_zamowien.setBorder(BorderFactory.createLineBorder(Color.black,1));
          panel_podglad_zamowienia.add(scroll_lista_zamowien);
          panel_podglad_zamowienia.add(new JLabel("Łączna kwota zamówienia: "+100.02));    //zsumowac zamowienie
          //Przyciski dodaj/usun produkt i zaplac + pole ilosc
          JPanel panel_przyciski= new JPanel(new GridLayout(0,2,5,5));
          panel_przyciski.setPreferredSize(new Dimension(170, 70));
          panel_przyciski.setBackground(Color.decode("#ffffcc"));
          textfield_ilosc = new JTextField(2);
          panel_przyciski.add(new JLabel("Ilosc:"));
          panel_przyciski.add(textfield_ilosc);
          button_dodaj = new JButton("Dodaj");
          button_dodaj.setBackground(Color.decode("#999966"));
          button_dodaj.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
          panel_przyciski.add(button_dodaj);
          button_usun = new JButton("Usun");
          button_usun.setBackground(Color.decode("#999966"));
          button_usun.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
          panel_przyciski.add(button_usun);
          button_zaplac = new JButton("Zapłać");
          button_zaplac.setBackground(Color.decode("#999966"));
          button_zaplac.setBorder(BorderFactory.createEmptyBorder(5,10,5,30));
          panel_przyciski.add(button_zaplac);
          panel_koszyk.add(panel_przyciski);
          
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
    
    //Ustawianie styli komórek, sposob z internetu musze ogarnac jeszcze
    private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(1,0, 2, 0, Color.BLACK));
                listCellRendererComponent.setHorizontalAlignment(SwingConstants.CENTER);
                listCellRendererComponent.setFont(new Font("Serif", Font.BOLD, 15));
                return listCellRendererComponent;
            }
    };
  }
}
