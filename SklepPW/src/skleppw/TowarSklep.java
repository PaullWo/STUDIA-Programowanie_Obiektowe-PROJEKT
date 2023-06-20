package skleppw;

import java.io.Serializable;

public class TowarSklep extends Towar implements Serializable{
    private int ilosc_na_stanie;
    
    public TowarSklep(String nazwa,double cena,int ilosc_na_stanie){
        super(nazwa,cena);
        this.ilosc_na_stanie=ilosc_na_stanie;
    }
    public int getIloscNaStanie(){
        return ilosc_na_stanie;
    }
    public void setIloscNaStanie(int ilosc_na_stanie){
        this.ilosc_na_stanie=ilosc_na_stanie;
    }
    public void odejmijIloscNaStanie(int ilosc){
        ilosc_na_stanie=ilosc_na_stanie-ilosc;
    }
    public void dodajIloscNaStanie(int ilosc){
        ilosc_na_stanie=ilosc_na_stanie+ilosc;
    }
    public String opisTowarSklep(){
        return opis()+", ilosc na stanie: "+ilosc_na_stanie;
    }
}
