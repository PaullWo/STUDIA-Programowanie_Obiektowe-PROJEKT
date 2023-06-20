package skleppw;

import javax.swing.JFrame;

public class SklepPW {

    public static void main(String[] args) {
        Sklep sklepROPUCHA=new Sklep("ROPUCHA","Siedlce ul.Polna 17");
        JFrame f=new OknoGlowne(sklepROPUCHA);
    }
    
}
