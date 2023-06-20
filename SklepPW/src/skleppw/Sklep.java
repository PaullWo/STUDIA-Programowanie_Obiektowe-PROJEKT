package skleppw;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sklep {
    private List<Uzytkownik> lista_uzytkownikow = new ArrayList<>();
    private DefaultListModel<TowarSklep> lista_towarow;  
    public Sklep(){
        lista_towarow = new DefaultListModel<>();
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
}
