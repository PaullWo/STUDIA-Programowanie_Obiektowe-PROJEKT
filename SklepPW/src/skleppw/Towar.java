package skleppw;

import java.io.Serializable;

public class Towar implements Serializable{
    private String nazwa;
    private double cena;
    
    public Towar(String nazwa,double cena){
        this.nazwa=nazwa;
        this.cena=cena;
    }
    public String getNazwa(){
        return nazwa;
    }
    public double getCena(){
        return cena;
    }
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }
    public void setCena(double cena){
        this.cena=cena;
    }
    public String opis(){
        return nazwa+", "+cena+"zl";
    }
}
