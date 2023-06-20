package skleppw;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Drukarka extends Sprzet implements Serializable{
    private int ilosc_papieru;
    
    public Drukarka(String nazwa){
        super(nazwa);
        ilosc_papieru=0;
    }
    
    //Podstawowe metody
    public double getIloscPapieru(){
        return ilosc_papieru;
    }
    public void setIloscPieniedzy(int ilosc_papieru){
        this.ilosc_papieru=ilosc_papieru;
    }
    public void dodajPapier(int ilosc_papieru){
        this.ilosc_papieru=this.ilosc_papieru+ilosc_papieru;
    }
    public void wyjmijPapier(int ilosc_papieru,JPanel panel){
        if(this.ilosc_papieru-ilosc_papieru>0){
            this.ilosc_papieru=this.ilosc_papieru-ilosc_papieru;
        }else{
            JOptionPane.showMessageDialog(panel,"Nie można wykonać operacji! Za mało papieru w drukarce!");
        }
    }
    //Metody abstrakcyjne
    @Override
    public String opis(){
        return "Sprzet "+getNazwa()+" ,ilosc papieru: "+ilosc_papieru+".";
    }
    @Override
    public void sprawdzAwarie(JPanel panel){
        if(ilosc_papieru<20){
            JOptionPane.showMessageDialog(panel,"UWAGA! W drukarce zostało mniej niż 20 kartek papieru, aby zapobiec niepowodzeniom dołóż papier do drukarki.");
        }
        JOptionPane.showMessageDialog(panel,"Brak awarii w drukarce. :)");
    }
}
