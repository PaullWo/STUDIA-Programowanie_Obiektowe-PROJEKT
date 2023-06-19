package skleppw;

//Klasa uzytkownik, przydatna do logowania
public class Uzytkownik {
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String miejscowosc;
    private String dzien_urodzenia;
    private String miesiac_urodzenia;
    private String rok_urodzenia;       //jak starczy mi czasu to zmienic na inta,ale trzeba wtedy sprawdzic wpisywany rok czy jest dobrze
    
    public Uzytkownik(String login,String haslo){
        this.login=login;
        this.haslo=haslo;
        imie="";
        nazwisko="";
        miejscowosc="";
        miesiac_urodzenia="";
        rok_urodzenia="";
        dzien_urodzenia="";
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login=login;
    }
    public String getHaslo(){
        return haslo;
    }
    public boolean sprawdzLogin(String login){
        if(this.login.equals(login)){
            return true;
        }
        return false;
    }
    public boolean sprawdzLoginHaslo(String login,String haslo){
        if(this.login.equals(login) && this.haslo.equals(haslo)){
            return true;
        }
        return false;
    }
    public boolean sprawdzDane(){
        if("".equals(imie) || "".equals(nazwisko) || "".equals(miejscowosc) || "".equals(miesiac_urodzenia) || "".equals(rok_urodzenia)){
            return true;
        }
        return false;
    }
    public void ustawDane(String imie,String nazwisko,String miejscowosc,String dzien_urodzenia,String miesiac_urodzenia,String rok_urodzenia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.miejscowosc=miejscowosc;
        this.dzien_urodzenia=dzien_urodzenia;
        this.miesiac_urodzenia=miesiac_urodzenia;
        this.rok_urodzenia=rok_urodzenia;
    }
    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public String getMiejscowosc(){
        return miejscowosc;
    }
    public String getDzien(){
        return dzien_urodzenia;
    }
    public String getMiesiac(){
        return miesiac_urodzenia;
    }
    public String getRok(){
        return rok_urodzenia;
    }
    public String opis(){
        return imie+" "+nazwisko+", "+miejscowosc+", "+dzien_urodzenia+"."+miesiac_urodzenia+"."+rok_urodzenia;
    }
}
