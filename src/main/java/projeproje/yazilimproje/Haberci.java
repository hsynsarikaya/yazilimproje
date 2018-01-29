package projeproje.yazilimproje;


public class Haberci {
    public static int COUNT = 0;
    private int id;
    private String haber;
    
    public Haberci(String haber) {
        this.id = COUNT;
        this.haber = haber;
       
    }
    public String getHaber() {
        return haber;
    }
  
    
}