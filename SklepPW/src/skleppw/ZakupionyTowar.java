package skleppw;

import java.io.Serializable;

public class ZakupionyTowar implements Opisy,Serializable{
    private TowarSklep zakupiony_towar;
    private int ilosc;
    
    public ZakupionyTowar(TowarSklep zakupiony_towar,int ilosc){
        this.zakupiony_towar=zakupiony_towar;
        this.ilosc=ilosc;
    }
    
    //Podstawowe metody
    public void setTowar(TowarSklep zakupiony_towar){
        this.zakupiony_towar=zakupiony_towar;
    }
    public void setIlosc(int ilosc){
        this.ilosc=ilosc;
    }
    public TowarSklep getTowar(){
        return zakupiony_towar;
    }
    public int getIlosc(){
        return ilosc;
    }
    public double getKoszt(){
        double kwota=Math.round((zakupiony_towar.getCena()*ilosc) * 100.0) / 100.0;
        return kwota;
    }
    @Override
    public String opis(){
        double kwota=Math.round((zakupiony_towar.getCena()*ilosc) * 100.0) / 100.0;
        return zakupiony_towar.opis()+", ilosc: "+ilosc+", koszt: "+kwota+"zl";
    }
    @Override
    public String opisHTML(){
        double kwota=Math.round((zakupiony_towar.getCena()*ilosc)*100.0)/100.0;
        return "<html><b>Nazwa: </b></html>"+zakupiony_towar.getNazwa()+"<html>, <b>ilosc: </b></hmtl>"+ilosc+
                "<html>, <b>koszt: </b></html>"+kwota+"zl";
    }
    
}
