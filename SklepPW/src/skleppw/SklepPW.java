package skleppw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

//Paulina Woźnica gr.4, projekt nr.13
public class SklepPW {

    public static void main(String[] args) {
        //Odkomentować wrazie problemu z plikiem
        /*Sklep sklepROPUCHA=new Sklep("ROPUCHA","Siedlce ul.Polna 17");
        TowarSklep testtowar1=new TowarSklep("BUŁKA",2.99,70);
        TowarSklep testtowar2=new TowarSklep("CHLEB",4.50,20);
        TowarSklep testtowar3=new TowarSklep("MASŁO",7,50);
        TowarSklep testtowar4=new TowarSklep("KEFIR",3.2,20);
        TowarSklep testtowar5=new TowarSklep("MLEKO",4.5,60);
        TowarSklep testtowar6=new TowarSklep("COCA-COLA",7.5,50);
        TowarSklep testtowar7=new TowarSklep("PEPSI",7.6,20);
        TowarSklep testtowar8=new TowarSklep("CHUSTECZKI",4.5,30);
        TowarSklep testtowar9=new TowarSklep("RĘCZNIK PAPIEROWY",9.99,67);
        TowarSklep testtowar10=new TowarSklep("KURCZAK",15.2,20);
        TowarSklep testtowar11=new TowarSklep("MIĘSO MIELONE",9.99,30);
        TowarSklep testtowar12=new TowarSklep("KABANOSY",7.4,50);
        sklepROPUCHA.dodajTowar(testtowar1);
        sklepROPUCHA.dodajTowar(testtowar2);
        sklepROPUCHA.dodajTowar(testtowar3);
        sklepROPUCHA.dodajTowar(testtowar4);
        sklepROPUCHA.dodajTowar(testtowar5);
        sklepROPUCHA.dodajTowar(testtowar6);
        sklepROPUCHA.dodajTowar(testtowar7);
        sklepROPUCHA.dodajTowar(testtowar8);
        sklepROPUCHA.dodajTowar(testtowar9);
        sklepROPUCHA.dodajTowar(testtowar10);
        sklepROPUCHA.dodajTowar(testtowar11);
        sklepROPUCHA.dodajTowar(testtowar12);
        Uzytkownik u1=new Uzytkownik("123","123");
        Uzytkownik u2=new Uzytkownik("user","123");
        //Konto dla admina
        Uzytkownik u3=new Uzytkownik("admin","admin");
        sklepROPUCHA.TESTDODAJ(u2);
        sklepROPUCHA.TESTDODAJ(u1);
        sklepROPUCHA.TESTDODAJ(u3);
        Wplatomat wplatomat=new Wplatomat("wplatomat");
        wplatomat.dodajPieniadze(8291.71);
        Drukarka drukarka=new Drukarka("drukarka");
        drukarka.dodajPapier(100);
        sklepROPUCHA.setWplatomat(wplatomat);
        sklepROPUCHA.setDrukarka(drukarka);
        
        try {
            ObjectOutputStream plik;
            plik = new ObjectOutputStream(new FileOutputStream("bazadanych_sklepROPUCHA.ser"));
            plik.writeObject(sklepROPUCHA);
            plik.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OknoRachunek.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OknoRachunek.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        Sklep sklepROPUCHA=null;
        try{
            ObjectInputStream plik= new ObjectInputStream( new FileInputStream("bazadanych_sklepROPUCHA.ser"));
            sklepROPUCHA=(Sklep)plik.readObject();
            plik.close();
        }catch(IOException e){
            System.out.println("Błąd pliku!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SklepPW.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame f=new OknoGlowne(sklepROPUCHA);
    }    
}
