package skleppw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sklep implements Opisy,Serializable{
    private String nazwa;
    private String adres;
    private List<Uzytkownik> lista_uzytkownikow = new ArrayList<>();
    private DefaultListModel<TowarSklep> lista_towarow; 
    private List<Zakup> lista_zakupow = new ArrayList<>();
    private Wplatomat wplatomat;
    private Drukarka drukarka;
    
    public Sklep(){
        lista_towarow = new DefaultListModel<>();
    }
    public Sklep(String nazwa,String adres){
        this.nazwa=nazwa;
        this.adres=adres;
        lista_towarow = new DefaultListModel<>();
    }
    
    //Podstawowe metody
    public String getNazwa(){
        return nazwa;
    }
    public String getAdres(){
        return adres;
    }
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }
    public void setAdres(String adres){
       this.adres=adres;
    }
    @Override
    public String opis(){
        return "Sklep "+nazwa+" w "+adres+".";
    }
    public String opisHTML(){
        return "<html><b>Nazwa sklepu:<b></html>"+nazwa+"<html><br></html>"
                + "<html><b>Adres sklepu:<b></html>"+adres+"<html><br></html>";
    }
    
    //Obsluga towarow
    public void dodajTowar(TowarSklep towar){
        lista_towarow.addElement(towar);
    }
    public void dodajTowary(DefaultListModel<TowarSklep> lista_towarow){
        this.lista_towarow=lista_towarow;
    }
    public TowarSklep getTowarIndex(int index){
        return lista_towarow.elementAt(index);
    }
    public DefaultListModel<TowarSklep> getListaTowarow(){
        return lista_towarow;
    }
    public DefaultListModel<String> getListaTowarowWyswietl(){
        DefaultListModel<String> pomoc=new DefaultListModel<>();
        for(int i=0;i<lista_towarow.getSize();i++){
            pomoc.add(i, lista_towarow.elementAt(i).opis());
        }
        return pomoc;
    }
    public DefaultListModel<String> getListaTowarowWyswietlAdmin(){
        DefaultListModel<String> pomoc=new DefaultListModel<>();
        for(int i=0;i<lista_towarow.getSize();i++){
            pomoc.add(i, lista_towarow.elementAt(i).opisTowarSklep());
        }
        return pomoc;
    }
    public void usunTowarIndex(int index){
        lista_towarow.remove(index); 
    }
    public TowarSklep getTowarOpis(String sprawdzany_opis){
        for(int i=0;i<lista_towarow.getSize();i++){
            if(lista_towarow.elementAt(i).opis().equals(sprawdzany_opis)){
                return lista_towarow.elementAt(i);
            }
        }
            return null;    
    }
    public void usunTowarNazwa(String nazwa,JPanel panel){
        int pomoc=0;
        for(int i=0;i<lista_towarow.getSize();i++){
            if(lista_towarow.elementAt(i).getNazwa().equals(nazwa)){
                lista_towarow.remove(i);
                pomoc=1;
                JOptionPane.showMessageDialog(panel,"Zmiany będą widoczne po ponownym zalogowaniu!");
            }
        }
        if(pomoc==0){
            JOptionPane.showMessageDialog(panel,"Nie ma takiego towaru!"); 
        }
    }
    public void edytujTowarNazwa(String nazwa,JPanel panel,String nazwa_nowa,double cena,int ilosc){
        int pomoc=0;
        for(int i=0;i<lista_towarow.getSize();i++){
            if(lista_towarow.elementAt(i).getNazwa().equals(nazwa)){
                lista_towarow.elementAt(i).setNazwa(nazwa_nowa);
                lista_towarow.elementAt(i).setCena(cena);
                lista_towarow.elementAt(i).setIloscNaStanie(ilosc);
                pomoc=1;
                JOptionPane.showMessageDialog(panel,"Zmiany będą widoczne po ponownym zalogowaniu!");
            }
        }
        if(pomoc==0){
            JOptionPane.showMessageDialog(panel,"Nie ma takiego towaru!"); 
        }
    }
    //Obsluga uzytkownikow
    public void TESTDODAJ(Uzytkownik uzytkownik){
        lista_uzytkownikow.add(uzytkownik);
    }
    public void dodajUzytkownika(Uzytkownik uzytkownik,JPanel panel_logowanie2){
        int pomoc=0;
        for(int i=0;i<lista_uzytkownikow.size();i++){
            if(uzytkownik.sprawdzLogin(lista_uzytkownikow.get(i).getLogin())){
                pomoc=1;
            }
        }
        if(pomoc==0){
            lista_uzytkownikow.add(uzytkownik);
            JOptionPane.showMessageDialog(panel_logowanie2,"Rejestracja przebiegła pomyślenie! Zaloguj się, aby kontynuuować."); 
        }else{
            JOptionPane.showMessageDialog(panel_logowanie2,"Podany login już istnieje!"); 
        }
    }
    public int logowanie(String login,String haslo){
        for(int i=0;i<lista_uzytkownikow.size();i++){
            if(lista_uzytkownikow.get(i).sprawdzLoginHaslo(login,haslo)){
                return i;
            }
        }
        return -1;
    }
    public Uzytkownik getUzytkownikID(int index){
        return lista_uzytkownikow.get(index);
    }
    
    //Obsluga sprzetow
    public Wplatomat getWplatomat(){
        return wplatomat;
    }
    public void setWplatomat(Wplatomat wplatomat){
        this.wplatomat=wplatomat;
    }
    public Drukarka getDrukarka(){
        return drukarka;
    }
    public void setDrukarka(Drukarka drukarka){
        this.drukarka=drukarka;
    }
    public void sprawdzAwarieSprzetow(JPanel panel){
        wplatomat.sprawdzAwarie(panel);
        drukarka.sprawdzAwarie(panel);
    }
    //Obsluga zamowien
    public void dodajZakup(Zakup zakup){
        lista_zakupow.add(zakup);
    }
    public Zakup getZakupIndex(int index){
        return lista_zakupow.get(index);
    }
    public List<Zakup> getZakupIndex(){
        return lista_zakupow;
    }
    public String wyswietlZakupyHTML(){
        String opis="<html>Lista zakupów: <br></html>";
        for(int i=0;i<lista_zakupow.size();i++){
            opis+=lista_zakupow.get(i).opisHTML();
            opis+="<html><br>-------------------------<br></html>";
        }
        return opis;
    }
    public Zakup getOstatniZakup(){
        int pomoc= (lista_zakupow.size()-1);
        return lista_zakupow.get(pomoc);
    }
}
