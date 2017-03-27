/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import VISTA.JIntFrmNuevaOrdInterna;
import VISTA.interfaz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.currentThread;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Informatica
 */
public class Job implements Runnable{

    public static boolean band=false;    
    private int tiempo = 5;
    private URL apiURL=null;
    public static BufferedReader br=null;

    
    public Job( URL apiURL){
         this.apiURL=apiURL;
  
    }
    @Override
    public void run() {
        synchronized(this){
            band=false;
     
            URLConnection apiURLCon=null; 

            try {
                apiURLCon = apiURL.openConnection();
            } catch (IOException ex) {
                Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            }        
            try { 
                br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            }

            band=true;  
            notifyAll();
        }
    }

}
