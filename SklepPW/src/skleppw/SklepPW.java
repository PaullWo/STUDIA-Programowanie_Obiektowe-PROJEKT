package skleppw;

import javax.swing.JFrame;

public class SklepPW {

    public static void main(String[] args) {
        Sklep sklepROPUCHA=new Sklep("ROPUCHA","Siedlce ul.Polna 17");
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
        JFrame f=new OknoGlowne(sklepROPUCHA);
    }    
}
