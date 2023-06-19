package skleppw;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sklep {
    private List<Uzytkownik> lista_uzytkownikow = new ArrayList<>();
    
    public Sklep(){
    }
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
