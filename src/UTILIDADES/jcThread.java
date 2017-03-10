/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

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

/**
 *
 * @author Informatica
 */
public class jcThread implements Runnable{

    private JProgressBar jProgressBar;
    private int i = 1;
    private int value = 50;//retardo en milisegundos
    private URLConnection apiURL;
    private BufferedReader br=null;
    /**
 * Constructor de clase
 */
    public jcThread(URLConnection apiURLCon)
    {
        apiURL=apiURLCon;
        
    }



    @Override
    public void run() {
           JFrame frame = new JFrame();
            JLabel input = new JLabel("Creando orden");   
            frame.setSize(100,100);
            frame.add( input, BorderLayout.NORTH );                             
            frame.pack();
            frame.setVisible( true ); 
            
              
            try {
                br = new BufferedReader(new InputStreamReader(apiURL.getInputStream()));
               
            /* i=1;
            //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez
            while( !Job.band )
            {
            //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
            i = (i > 100) ? 1 : i+1;
            jProgressBar.setValue(i);
            jProgressBar.repaint();  
            //retardo en milisegundos
            try{Thread.sleep( this.value );}
            catch (InterruptedException e){ System.err.println( e.getMessage() ); }            
            //si el trabajo en paralelo a terminado
            if( Job.band )
            {
            jProgressBar.setValue(100);
            System.out.println("Trabajo finalizado...");
            break;//rompe ciclo
            }
            }*/
        } catch (IOException ex) {
            Logger.getLogger(jcThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
