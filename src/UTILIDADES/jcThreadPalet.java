/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import VISTA.JIntFrmNuevaOrdInterna;
import VISTA.interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Informatica
 */
public class jcThreadPalet implements Runnable{

    private JProgressBar jProgressBar;
    private JTextField numero;
    private int i = 1;
    private int value = 50;//retardo en milisegundos
    public static BufferedReader br=null;
    public static String cadena;
    
    /**
 * Constructor de clase
 */
    public jcThreadPalet( JProgressBar jProgressBar , int value, JTextField numero )
    {
        this.jProgressBar = jProgressBar;
        this.value = value;
        this.numero=numero;
  
   
    }
    
    @Override
    public void run() {
 
            i=1;
            numero.setText("CREANDO ORDEN...");
          
            //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez    
            while( !JobPalet.band )
            {                
                //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
                i = (i > 100) ? 1 : i+1;
                jProgressBar.setValue(i);
                jProgressBar.repaint();  
                //retardo en milisegundos
                try{
                    Thread.sleep(this.value);
                }
                catch (InterruptedException e){ 
                    System.err.println( e.getMessage() ); 
                }            
                //si el trabajo en paralelo a terminado
                if( JobPalet.band )
                {
                    jProgressBar.setValue(100);
                    System.out.println("Trabajo finalizado...");               
                    String respuestaOrden="";
                    String[] respuestaSeparada = null;        
                 
                    String numeroOrden="";                    
                         
                       
                        respuestaSeparada=cadena.split("\\|");   
                        numeroOrden=respuestaSeparada[2];   
                 
                          
                    numero.setText("Orden creada: "+numeroOrden);                
            
                    break;//rompe ciclo               
          
                } 
       
             }
        
    }

}
