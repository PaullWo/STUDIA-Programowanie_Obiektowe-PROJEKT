package skleppw;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Wplatomat extends Sprzet implements Serializable{
    //jak bede miec czas rozbudowac klase na ilosc banknotow i monet
    private double ilosc_pieniedzy;
    
    public Wplatomat(String nazwa){
        super(nazwa);
        ilosc_pieniedzy=0;
    }
    
    //Podstawowe metody
    public double getIloscPieniedzy(){
        return ilosc_pieniedzy;
    }
    public void setIloscPieniedzy(double ilosc_pieniedzy){
        this.ilosc_pieniedzy=ilosc_pieniedzy;
    }
    public void dodajPieniadze(double ilosc_pieniedzy){
        this.ilosc_pieniedzy=this.ilosc_pieniedzy+ilosc_pieniedzy;
    }
    public void wyjmijPieniadze(double ilosc_pieniedzy,JPanel panel){
        if(this.ilosc_pieniedzy-ilosc_pieniedzy>0){
            this.ilosc_pieniedzy=this.ilosc_pieniedzy-ilosc_pieniedzy;
        }else{
            JOptionPane.showMessageDialog(panel,"Nie można wykonać transakcji! Za mało pieniędzy w wpłatomacie!");
        }
    }
    //Metody abstrakcyjne
    @Override
    public String opis(){
        return "Sprzet "+getNazwa()+" ,ilosc pieniedzy: "+ilosc_pieniedzy+".";
    }
    @Override
    public void sprawdzAwarie(JPanel panel){
        if(ilosc_pieniedzy<1000){
            JOptionPane.showMessageDialog(panel,"UWAGA! W wpłatomacie zostało mniej niż 1000 zł, aby zapobiec niepowodzeniom dołóż pieniądze do wpłatomatu.");
        }
        JOptionPane.showMessageDialog(panel,"Brak awarii w wpłatomacie. :)");
    }
}
