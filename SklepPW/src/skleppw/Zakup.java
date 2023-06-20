package skleppw;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Zakup implements Opisy,Serializable{
    private Sklep sklep;
    private double laczny_koszt;
    private double zaplacona_kwota;
    private List<ZakupionyTowar> lista_zakupionych_towarow = new ArrayList<>();
    private String stempel_czasu;
    
    public Zakup(Sklep sklep,double laczny_koszt,double zaplacona_kwota){
        this.sklep=sklep;
        this.laczny_koszt=laczny_koszt;
        this.zaplacona_kwota=zaplacona_kwota;
        //Data w chwili zlozenia zamowienia
        Date nowDate = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        stempel_czasu=sdf1.format(nowDate);
    }
    //Podstawowe metody
    public Sklep getSklep(){
        return sklep;
    }
    public void setSklep(Sklep sklep){
        this.sklep=sklep;
    }
    public double getKoszt(){
        return (Math.round(laczny_koszt * 100.0) / 100.0);
    }
    public void setKoszt(double laczny_koszt){
        this.laczny_koszt=laczny_koszt;
    }
    public double getZaplaconaKwota(){
        return (Math.round(zaplacona_kwota * 100.0) / 100.0);
    }
    public void setZaplaconaKwota(double zaplacona_kwota){
        this.zaplacona_kwota=zaplacona_kwota;
    }
    public String getData(){
        return stempel_czasu;
    }
    //Obsluga zakupionych towarow
    public void dodajTowar(ZakupionyTowar towar){
        lista_zakupionych_towarow.add(towar);
    }
    public void dodajTowary(List<ZakupionyTowar> lista_zakupionych_towarow){
        this.lista_zakupionych_towarow=lista_zakupionych_towarow;
    }
    public ZakupionyTowar getTowarIndex(int index){
        return lista_zakupionych_towarow.get(index);
    }
    public List<ZakupionyTowar> getListaTowarow(){
        return lista_zakupionych_towarow;
    }
    public List<String> getListaTowarowWyswietl(){
        List<String> pomoc=new ArrayList<>();
        for(int i=0;i<lista_zakupionych_towarow.size();i++){
            pomoc.add(i, lista_zakupionych_towarow.get(i).opisHTML());
        }
        return pomoc;
    }
    public void usunTowarIndex(int index){
        lista_zakupionych_towarow.remove(index); 
    }
}
