package skleppw;

import java.io.Serializable;
import javax.swing.JPanel;

public abstract class Sprzet implements Serializable{
    private String nazwa;
    
    public Sprzet(String nazwa){
        this.nazwa=nazwa;
    }
    //Podstawowe metody
    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }
    //Metody abstrakcyjne
    public abstract void sprawdzAwarie(JPanel panel);
    public abstract String opis();
}
