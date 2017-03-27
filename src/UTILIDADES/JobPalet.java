/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import BLL.OrdenBLL;
import ENTIDAD.Articulo;
import ENTIDAD.Cliente;
import ENTIDAD.Orden;
import ENTIDAD.Proyecto;
import ENTIDAD.Usuario;
import VISTA.JIntFrmNuevaOrdInterna;
import VISTA.interfaz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.currentThread;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Informatica
 */
public class JobPalet implements Runnable{

    public static boolean band=false;    
    private int tiempo = 5;
    private URL apiURL=null;
    private Orden ord;
    private Usuario us;
    private Cliente cli;
    private Proyecto pro;
    private ArrayList<Articulo> articulosPalet;
    
    public static BufferedReader br=null;

    
    public JobPalet(Orden ord,Usuario us, Cliente cli, Proyecto pro,ArrayList<Articulo> articulosPalet){
         //this.apiURL=apiURL;
         this.ord=ord;
         this.us=us;
         this.cli=cli;
         this.pro=pro;
         this.articulosPalet=articulosPalet;
    }
    @Override
    public void run() {
        synchronized(this){
            band=false;
            OrdenBLL ordBLL=new OrdenBLL();
            URLConnection apiURLCon=null; 
            String cadena="";
            String respuestaOrden="";
            String[] respuestaSeparada = null;  
            int unidades;
            for( int i = 0 ; i < articulosPalet.size() ; i++ ){
                ord.setArticulo(articulosPalet.get(i));
                ord.setUnidades(articulosPalet.get(i).getUnidades());
                try {
                    apiURL= ordBLL.nuevaOrden(ord,us,cli,pro);
                    apiURLCon = apiURL.openConnection();
                    br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));   
                   
                    cadena=br.readLine();                       
                    respuestaSeparada=cadena.split("\\|");   
                    ord.setEntrada(Double.parseDouble(respuestaSeparada[1]));                
                    
                } catch (IOException ex) {
                    Logger.getLogger(JobPalet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JobPalet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                    
             jcThreadPalet.cadena=cadena;

            band=true;  
           
        }
    }

}
