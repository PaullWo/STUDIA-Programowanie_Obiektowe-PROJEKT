package skleppw;


import javax.swing.DefaultListModel;

public class TowarySklep {
    DefaultListModel<TowarSklep> lista_towarow;  
    
    public TowarySklep(){
        lista_towarow = new DefaultListModel<>();
    }
    public void dodajTowar(TowarSklep towar){
        lista_towarow.addElement(towar);
    }
    public void dodajTowary(DefaultListModel<TowarSklep> lista_towarow){
        this.lista_towarow=lista_towarow;
    }
    public TowarSklep getTowarIndex(int index){
        return lista_towarow.elementAt(index);
    }
    public DefaultListModel<TowarSklep> getListaTowarow(){
        return lista_towarow;
    }
    public DefaultListModel<String> getListaTowarowWyswietl(){
        DefaultListModel<String> pomoc=new DefaultListModel<>();
        for(int i=0;i<lista_towarow.getSize();i++){
            pomoc.add(i, lista_towarow.elementAt(i).opis());
        }
        return pomoc;
    }
    public void usunTowarIndex(int index){
        lista_towarow.remove(index);
        
    }
}
