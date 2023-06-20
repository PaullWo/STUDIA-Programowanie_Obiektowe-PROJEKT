package skleppw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class SklepPW {

    public static void main(String[] args) {
        //Odczyt z pliku
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
