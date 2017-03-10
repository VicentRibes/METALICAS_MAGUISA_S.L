/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import VISTA.JIntFrmNuevaOrdInterna;
import VISTA.MAGUISA;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/**
 *
 * @author Informatica
 */
public class CargandoEspere extends Thread {
    private BufferedReader br=null;
    private URLConnection apiURL;
    public CargandoEspere(URLConnection apiURLCon) {
        apiURL=apiURLCon;
    }      
    public void run(){           
                         
            JFrame frame = new JFrame();
            JLabel input = new JLabel("Creando orden");   
            frame.setSize(100,100);
            frame.add( input, BorderLayout.NORTH );                             
            frame.pack();
            frame.setVisible( true );             
             
            /*try {
                br = new BufferedReader(new InputStreamReader(apiURL.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(CargandoEspere.class.getName()).log(Level.SEVERE, null, ex);
            }*/
             
            while(!Thread.currentThread().isInterrupted()){
             
            /*System.out.println("Cargando.....");          */
            }
            
            frame.setVisible(false);
            
    } 
}
