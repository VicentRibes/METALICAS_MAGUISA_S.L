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
public class jcThread implements Runnable{

    private JProgressBar jProgressBar;
    private JTextField numero;
    private int i = 1;
    private int value = 50;//retardo en milisegundos
    public static BufferedReader br=null;

    
    /**
 * Constructor de clase
 */
    public jcThread( JProgressBar jProgressBar , int value, JTextField numero )
    {
        this.jProgressBar = jProgressBar;
        this.value = value;
        this.numero=numero;
        jProgressBar.setValue(50);
   
    }
    
    @Override
    public void run() {
 
            i=1;
            numero.setText("CREANDO ORDEN");
          
            //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez    
            while( !Job.band )
            {                
                //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
                i = (i > 100) ? 1 : i+1;
                jProgressBar.setValue(i);
                jProgressBar.repaint();  
                //retardo en milisegundos
                try{
                    Thread.sleep( this.value );
                }
                catch (InterruptedException e){ 
                    System.err.println( e.getMessage() ); 
                }            
                //si el trabajo en paralelo a terminado
                if( Job.band )
                {
                    jProgressBar.setValue(100);
                    System.out.println("Trabajo finalizado...");
                    br=Job.br;
                    String respuestaOrden="";
                    String[] respuestaSeparada = null;        
                    String cadena="";
                    try {          
                    cadena=br.readLine();
                    } catch (IOException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    respuestaSeparada=cadena.split("\\|");   
                    String numeroOrden=respuestaSeparada[2];
                    JIntFrmNuevaOrdInterna.entradaOrd=Double.parseDouble(respuestaSeparada[1]);
                    numero.setText("Orden creada: "+numeroOrden);
                ;
            
                    break;//rompe ciclo               
          
                } 
       
             }
        
    }

}
