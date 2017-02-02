/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Permiso;
import ENTIDAD.Usuario;
import UTILIDADES.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Informatica
 */
public class UsuarioDAO {
    public Usuario obtenerUsuario() throws SQLException{
        
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;     
        String username=System.getProperty("user.name");
        
        if(username.length()>=10){
            username=username.substring(0,10);
        }
        Conexion con= new Conexion();
        conexion = con.connecta();
        System.out.println(username);
        statement=conexion.prepareStatement("SELECT NOMBRE,CLAVEWEB FROM E_USERS WHERE NOMBRE='"+username+"'");
        Usuario us=new Usuario();
        resultSet=statement.executeQuery();
        if(resultSet.next()) {           
         
            us.setUsername(resultSet.getString("NOMBRE"));
            us.setPassword(resultSet.getString("CLAVEWEB")); //pasaremos la contraseña con un gion bajo para saber que ja esta codificada, codigo interno de API        
            us.setPassword("_"+us.getPassword());
            
        }
        return us;
    }
    public static Usuario obtenerPermisos(Usuario us) throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;    
        String username=System.getProperty("user.name");
        ArrayList <Permiso> permisos = null;
        Conexion con= new Conexion();
        conexion = con.connecta();  
        statement=conexion.prepareStatement("SELECT USPERM.ID_PERMISO "
                                          + "FROM PRGMM_USUARIOS AS US LEFT JOIN PRGMM_USUARIO_PERMISO AS USPERM ON US.ID_USUARIO=USPERM.ID_USUARIO "
                                          + "WHERE US.NOMBRE='"+username+"'");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
                Permiso p=new Permiso();
                p.setId_permiso(resultSet.getInt("ID_PERMISO"));
                permisos.add(p);
        }
   
        us.setPermisos(permisos);
        
        return us;
    }
}
