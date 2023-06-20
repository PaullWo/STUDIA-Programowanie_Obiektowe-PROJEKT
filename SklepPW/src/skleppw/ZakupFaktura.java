package skleppw;

import java.io.Serializable;
import java.util.List;

public class ZakupFaktura extends Zakup implements Opisy,Serializable{
    private String nazwa;
    private String imie;
    private String nazwisko;
    private String miejscowosc;
    private String dzien_urodzenia;
    private String miesiac_urodzenia;
    private String rok_urodzenia;
    
    public ZakupFaktura(Sklep sklep,double laczny_koszt,double zaplacona_kwota,String imie,String nazwisko,String miejscowosc,String dzien_urodzenia,String miesiac_urodzenia,String rok_urodzenia){
        super(sklep,laczny_koszt,zaplacona_kwota);
        nazwa="Faktura";
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.miejscowosc=miejscowosc;
        this.dzien_urodzenia=dzien_urodzenia;
        this.miesiac_urodzenia=miesiac_urodzenia;
        this.rok_urodzenia=rok_urodzenia;
    }
    @Override
    public String opis(){
        double reszta=getZaplaconaKwota()-getKoszt();
        String opis="Dane klienta: "+imie+" "+nazwisko+", "+miejscowosc+", "+dzien_urodzenia+"."+miesiac_urodzenia+"."+rok_urodzenia;
        opis+=nazwa+"\n Koszt: "+getKoszt()+"zl\nZapłacona kwota: "+getZaplaconaKwota()+"zl\nReszta: "+reszta+"zl\nData: "+getData()+"\n";
        return opis;
    }
    @Override
    public String opisHTML(){
        String opis="<html><b>FAKTURA</b><br></html>";
        opis+="<html><b>Dane klienta:<br>Imię: </b></html>"+imie+"<html><br></html>"+"<html><b>Nazwisko: </b></html>"+nazwisko+"<html><br></html>"+
                "<html><b>Miejsce zamieszkania: </b></html>"+miejscowosc+"<html><br></html>"+"<html><b>Data urodzenia: </b></html>"+
                dzien_urodzenia+"."+miesiac_urodzenia+"."+rok_urodzenia+"<html><br></html>";
        double reszta=getZaplaconaKwota()-getKoszt();
        opis+="<html><b>Lista produktów: </b><br></html>";
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
