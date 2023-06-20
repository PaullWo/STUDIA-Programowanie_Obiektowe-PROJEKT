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

public class OknoSklep extends JFrame{
    private int zalogowanie;
    private Sklep sklepROPUCHA;
    private Uzytkownik uzytkownik;
    private Zakup pomocniczy_zakup;
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
    private JList lista_zamowien;
    //Label
    private JLabel label_koszt;
    
    public OknoSklep(int zalogowanie,Uzytkownik uzytkownik,Sklep sklep){
        this.zalogowanie=zalogowanie;
        this.uzytkownik=uzytkownik;
        sklepROPUCHA=sklep;
        setTitle("SKLEP ROPUCHA");
        pomocniczy_zakup=new Zakup(sklepROPUCHA,0,0);
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
          //Lista z produktami
          lista_produktow = new JList(sklepROPUCHA.getListaTowarowWyswietl());
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
          //Koszyk, lista z zamowieniem, kwota, usun element, zapłać
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
          panel_koszyk.add(panel_koszyk2);
          
          //Panel z wyswietleniem zamowienia
          JPanel panel_podglad_zamowienia=new JPanel();
          panel_podglad_zamowienia.setBackground(Color.decode("#ffffcc"));
          panel_podglad_zamowienia.setPreferredSize(new Dimension(300, 280));
          panel_podglad_zamowienia.setBounds(0,0,300,300);
          panel_koszyk.add(panel_podglad_zamowienia);
          DefaultListModel<String> model = new DefaultListModel<>();
          lista_zamowien = new JList(model); 
          JScrollPane scroll_lista_zamowien = new JScrollPane();
          scroll_lista_zamowien.setViewportView(lista_zamowien);
          scroll_lista_zamowien.setPreferredSize(new Dimension(250, 250));
          scroll_lista_zamowien.setBorder(BorderFactory.createLineBorder(Color.black,1));
          panel_podglad_zamowienia.add(scroll_lista_zamowien);
          

          label_koszt=new JLabel("Łączna kwota zamówienia: "+pomocniczy_zakup.getKoszt()+"zł");
          panel_podglad_zamowienia.add(label_koszt);
          //Przyciski dodaj/usun produkt i zaplac + pole ilosc
          JPanel panel_przyciski= new JPanel(new GridLayout(0,2,5,5));
          panel_przyciski.setPreferredSize(new Dimension(170, 70));
          panel_przyciski.setBackground(Color.decode("#ffffcc"));
          textfield_ilosc = new JTextField("1",2);
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
        if(zalogowanie==1){
            JMenuItem menu_opcja2=new JMenuItem("Zmień dane do faktury");
            menu.add(menu_opcja2);
            //Obsługa przycisku w menu "Zmień dane do faktury"
            menu_opcja2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    JFrame fdane=new OknoWprowadzanieDanych(zalogowanie,uzytkownik,sklepROPUCHA);
                }
            });
        }
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
        //Przycisk "Zapłać"
        button_zaplac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                sklepROPUCHA.dodajZakup(pomocniczy_zakup);
                JFrame fplatnosc=new OknoPlatnosci(zalogowanie,uzytkownik,sklepROPUCHA);
            }
        });
        //Przycisk "Usun"
        setResizable(false);
        button_usun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(lista_produktow.getSelectedValue()!=null){
                    String sprawdzany_opis=(String)lista_zamowien.getSelectedValue();
                    ZakupionyTowar pomocniczy_zakupiony_towar=pomocniczy_zakup.getTowarOpis(sprawdzany_opis);
                    pomocniczy_zakup.usunTowar(pomocniczy_zakupiony_towar);
                    label_koszt.setText("Łączna kwota zamówienia: "+pomocniczy_zakup.getKoszt()+"zł");
                    int selectedIndex = lista_zamowien.getSelectedIndex();
                    if (selectedIndex != -1) {
                       model.remove(selectedIndex);
                    }
                    System.out.println(pomocniczy_zakup.opisHTML());
                }
            }
        });
        //Przycisk "Dodaj"
        setResizable(false);
        button_dodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(lista_produktow.getSelectedValue()!=null){
                    int ilosc=Integer.parseInt(textfield_ilosc.getText());
                    String sprawdzany_opis=(String)lista_produktow.getSelectedValue();
                    TowarSklep pomocniczy_towar=sklepROPUCHA.getTowarOpis(sprawdzany_opis);
                    ZakupionyTowar pomocniczy_zakupiony_towar=new ZakupionyTowar(pomocniczy_towar,ilosc);
                    pomocniczy_zakup.dodajTowar(pomocniczy_zakupiony_towar);
                    label_koszt.setText("Łączna kwota zamówienia: "+pomocniczy_zakup.getKoszt()+"zł");
                    model.addElement(pomocniczy_zakupiony_towar.opis());
                    System.out.println(pomocniczy_zakup.opisHTML());
                }
            }
        });
        
        setVisible(true);
        setResizable(false);
    }
    
    //Ustawianie styli komórek, sposob z internetu
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