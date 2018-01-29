package projeproje.yazilimproje;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTServisi {

    private static final List<Haberci> HABERCİLER = new ArrayList<Haberci>();
    
    private Object kilit = new Object();
    
    @RequestMapping("/haberci/olustur")
    public synchronized Haberci haberciOlustur(String haber){
        synchronized (kilit) {
            Haberci haberci = new Haberci(haber);
            HABERCİLER.add(haberci);
            return haberci;
        }
    }
    
    @RequestMapping("/haberci/listele")
    public synchronized List<Haberci> haberciListele(){
        synchronized (kilit) {
            if (HABERCİLER.size()>10) {
                return HABERCİLER.subList(0, 10);
            } else {
                return HABERCİLER;
            }
            
        }
    }
    
    @RequestMapping("/haberci/temizle")
    public String haberciTemizle(){
        synchronized (kilit) {
            HABERCİLER.clear();
            return "OK";
        }
    }
    
    
    
    
    
    
}