package skleppw;

//Klasa uzytkownik, przydatna do logowania
public class Uzytkownik {
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String miejscowosc;
    private int dzien_urodzenia;
    private String miesiac_urodzenia;
    private String rok_urodzenia;       //jak starczy mi czasu to zmienic na inta,ale trzeba wtedy sprawdzic wpisywany rok czy jest dobrze
    
    public Uzytkownik(String login,String haslo){
        this.login=login;
        this.haslo=haslo;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login=login;
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
    public void ustawDane(String imie,String nazwisko,String miejscowosc,String dzien_urodzenia,String miesiac_urodzenia,String rok_urodzenia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.miejscowosc=miejscowosc;
        this.dzien_urodzenia=Integer.parseInt(dzien_urodzenia);
        this.rok_urodzenia=rok_urodzenia;
    }
    public String opis(){
        return imie+" "+nazwisko+", "+miejscowosc+", "+dzien_urodzenia+"."+miesiac_urodzenia+"."+rok_urodzenia;
    }
}
