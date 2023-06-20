package skleppw;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;

public class Zakup implements Opisy, Serializable{
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
        laczny_koszt+=towar.getKoszt();
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
    public DefaultListModel<String> getListaTowarowWyswietl(){
        DefaultListModel<String> pomoc=new DefaultListModel<>();
        for(int i=0;i<lista_zakupionych_towarow.size();i++){
            pomoc.add(i, lista_zakupionych_towarow.get(i).opisHTML());
        }
        return pomoc;
    }
    public void usunTowarIndex(int index){
        lista_zakupionych_towarow.remove(index); 
    }
    public void usunTowar(ZakupionyTowar towar){
        for(int i=0;i<lista_zakupionych_towarow.size();i++){
            if(lista_zakupionych_towarow.get(i)==towar){
                laczny_koszt-=lista_zakupionych_towarow.get(i).getKoszt();
                lista_zakupionych_towarow.remove(i);
            }
        }
    }
    @Override
    public String opis(){
        double reszta=getZaplaconaKwota()-getKoszt();
        return "Koszt: "+getKoszt()+"zl\nZapłacona kwota: "+getZaplaconaKwota()+"zl\nReszta: "+reszta+"zl\nData: "+getData()+"\n";
    }
    @Override
    public String opisHTML(){
        double reszta=getZaplaconaKwota()-getKoszt();
        String opis="<html>Lista produktów: </b><br></html>";
        DefaultListModel<String> pomoc=getListaTowarowWyswietl();
        for(int i=0;i<pomoc.getSize();i++){
            opis+=i+"<html>.</html>"+pomoc.elementAt(i)+"<html><br></html>";
        }
        opis+="<html><b>Koszt: </b></html>"+getKoszt()+"<html>zl<br></html>";
        opis+="<html><b>Zapłacona kwota: </b></html>"+getZaplaconaKwota()+"<html>zl<br></html>";
        opis+="<html><b>Wydana reszta: </b></html>"+reszta+"<html>zl<br></html>";
        opis+="<html><b>Data: </b></html>"+getData()+"<html><br></html>";
        return opis;
    }
    public ZakupionyTowar getTowarOpis(String sprawdzany_opis){
        for(int i=0;i<lista_zakupionych_towarow.size();i++){
            if(lista_zakupionych_towarow.get(i).opis().equals(sprawdzany_opis)){
                return lista_zakupionych_towarow.get(i);
            }
        }
            return null;    
    }
}
