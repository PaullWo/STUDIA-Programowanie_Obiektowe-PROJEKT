package skleppw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class ZakupRachunek extends Zakup implements Opisy,Serializable{
    private String nazwa;
    public ZakupRachunek(Sklep sklep,double laczny_koszt,double zaplacona_kwota){
        super(sklep,laczny_koszt,zaplacona_kwota);
        nazwa="Rachunek";
    }
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }
    public void setLista(){
        
    }
    @Override
    public String opis(){
        double reszta=getZaplaconaKwota()-getKoszt();
        return nazwa+"\n Koszt: "+getKoszt()+"zl\nZapłacona kwota: "+getZaplaconaKwota()+"zl\nReszta: "+reszta+"zl\nData: "+getData()+"\n";
    }
    @Override
    public String opisHTML(){
        double reszta=getZaplaconaKwota()-getKoszt();
        String opis="<html><b>RACHUNEK<br>Lista produktów: </b><br>";
        DefaultListModel<String> pomoc=getListaTowarowWyswietl();
        for(int i=0;i<pomoc.getSize();i++){
            opis+=i+"."+pomoc.elementAt(i)+"<br>";
        }
        opis+="<b>Koszt: </b>"+getKoszt()+"zl<br>";
        opis+="<b>Zapłacona kwota: </b>"+getZaplaconaKwota()+"zl<br>";
        opis+="<b>Wydana reszta: </b>"+reszta+"zl<br>";
        opis+="<b>Data: </b>"+getData()+"<br></html>";
        return opis;
    }
}
