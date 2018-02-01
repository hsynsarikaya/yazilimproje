package projeproje.yazilimproje;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTServisi {
 
    private static final List<Haberci> HABERCILER = new ArrayList<Haberci>();
    
    private Object kilit = new Object();
    
    @RequestMapping("/haberci/olustur")
    public synchronized Haberci haberciOlustur(String haber, String tarih){
        synchronized (kilit) {
            Haberci haberci = new Haberci(haber, tarih);
            HABERCILER.add(haberci);
            return haberci;
        }
    }
    
    @RequestMapping("/haberci/listele")
    public synchronized List<Haberci> haberciListele(){
        synchronized (kilit) {
            if (HABERCILER.size()>10) {
                return HABERCILER.subList(0, 10);
            } else {
                return HABERCILER;
            }
            
        }
    }
    
    @RequestMapping("/haberci/temizle")
    public String haberciTemizle(){
        synchronized (kilit) {
            HABERCILER.clear();
            return "OK";
        }
    }
    
    
    
    
    
    
}
