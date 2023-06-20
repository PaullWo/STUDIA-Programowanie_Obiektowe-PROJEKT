package skleppw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZakupRachunek extends Zakup implements Opisy,Serializable{
    private String nazwa;
    public ZakupRachunek(Sklep sklep,double laczny_koszt,double zaplacona_kwota){
        super(sklep,laczny_koszt,zaplacona_kwota);
        nazwa="Rachunek";
    }
    @Override
    public String opis(){
        double reszta=getZaplaconaKwota()-getKoszt();
        return nazwa+"\n Koszt: "+getKoszt()+"zl\nZapłacona kwota: "+getZaplaconaKwota()+"zl\nReszta: "+reszta+"zl\nData: "+getData()+"\n";
    }
    @Override
    public String opisHTML(){
        double reszta=getZaplaconaKwota()-getKoszt();
        String opis="<html><b>RACHUNEK<br>Lista produktów: </b><br></html>";
        List<String> pomoc=getListaTowarowWyswietl();
        for(int i=0;i<pomoc.size();i++){
            opis+=i+"<html>.</html>"+pomoc.get(i)+"<html><br></html>";
        }
        opis+="<html><b>Koszt: </b></html>"+getKoszt()+"<html>zl<br></html>";
        opis+="<html><b>Zapłacona kwota: </b></html>"+getZaplaconaKwota()+"<html>zl<br></html>";
        opis+="<html><b>Wydana reszta: </b></html>"+reszta+"<html>zl<br></html>";
        opis+="<html><b>Data: </b></html>"+getData()+"<html><br></html>";
        return opis;
    }
}
