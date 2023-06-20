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
    public void usunTowarIndex(int index){
        lista_towarow.remove(index); 
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
    
}
