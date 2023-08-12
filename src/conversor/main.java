package conversor;
import logic.Convert;
public class main {
    public static void main(String[] args){
        
        Convert cvs = new Convert();
        
        window app = new window(cvs);
        app.setVisible(true);
        


        double test = cvs.conversor(3000,"DOP","ARS");
        
        

     
    }

}
