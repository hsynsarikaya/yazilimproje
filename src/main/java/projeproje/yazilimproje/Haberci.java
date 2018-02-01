/*
 * @author HuseyinSarikaya
 * 
 */
package projeproje.yazilimproje;

/*
 * @param count, id 
 * 
 * 
 */
public class Haberci {
    public static int COUNT = 0;
    private int id; 
    private String haber;
    private String tarih;
    public Haberci(String haber,String tarih) {
        this.id = COUNT;
        this.haber = haber;
        this.tarih = tarih;
    /*
     * @param getHaber() 
     * 
     */
    }
    public String getHaber() {
        return haber;
    }
    public String getTarih() {
        return tarih;
    }
    
}
