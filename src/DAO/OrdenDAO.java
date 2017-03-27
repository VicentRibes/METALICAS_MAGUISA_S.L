/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Cliente;
import ENTIDAD.Orden;
import ENTIDAD.Proyecto;
import ENTIDAD.Usuario;
import UTILIDADES.CargandoEspere;
import UTILIDADES.Job;
import UTILIDADES.jcThread;
import VISTA.interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Compiler.command;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Informatica
 */
public class OrdenDAO {
     public static boolean band=false;  
     private URL apiURL=null;
     public static BufferedReader br=null;
  
   
    public URL nuevaOrden(Orden ord,Usuario us,Cliente cli, Proyecto pro)  throws  IOException, InterruptedException{
        
           
        String operacion="AddOrden";
        URL apiURL=null;
        
       // if(ord.getArticulo().getAlias()==null){
             apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades());        
       // }else{
             apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades());        
      //  }
      
      
        if(ord.getArticulo().getAlias()!=null && ord.getArticulo().getVariables()!=null){
            apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades()+"&p6="+ord.getArticulo().getVariables());        
        }else if(ord.getArticulo().getAlias()!=null && ord.getArticulo().getVariables()==null){
            apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades());        
        }else if(ord.getArticulo().getAlias()==null && ord.getArticulo().getVariables()!=null){
            apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades()+"&p6="+ord.getArticulo().getVariables());        
        }else{
            apiURL=new URL("http://192.0.3.245:81/APICARPINGEST/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades());        
        }
        
        BufferedReader br=null;
        
      
        
        
       /* 
        interfaz i=new interfaz();
        
      // i.main();
        i.setVisible(true);
        i.setApiURL(apiURL);
        i.crearOrden();
*/
        /*while(Job.band==false){
            
        }*/
       // System.out.println("hola ja he acabat xavalin");
      //  i.barra();
       
        
       /* Thread hiloA=new Thread(new Job(apiURL), "hiloA");
        hiloA.start();
        while(hiloA.getState()!=Thread.State.TERMINATED){
            System.out.println("hola");
        }*/
       
       // br=Job.br;
      
        //URLConnection apiURLCon=apiURL.openConnection();    
        System.out.println(apiURL);
     
       /* CargandoEspere cargando=new CargandoEspere(apiURLCon);
        Thread carga=new Thread(cargando);
        carga.run();
        //cargando.start();
   
              
        //barra.iniciarHilo();        
       
        BufferedReader br=null;
        //br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));     
       
       // barra.pararHilo(true);
        
        carga.interrupt();
        */
        
        
       
       //String cadena="";
       // cadena=br.readLine();          
        return apiURL;
    }
    
    
    
    
}
