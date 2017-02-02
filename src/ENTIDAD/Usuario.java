/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDAD;

import java.util.ArrayList;

/**
 *
 * @author Informatica
 */
public class Usuario {
    private String username;
    private String password;
    private ArrayList <Permiso> permisos;

    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList permisos) {
        this.permisos = permisos;
    }
    
    
}
