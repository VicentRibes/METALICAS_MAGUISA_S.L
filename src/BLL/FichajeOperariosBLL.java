/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.FichajeOperariosDAO;
import ENTIDAD.FichajeOperarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author miguel
 */
public class FichajeOperariosBLL {
        public ArrayList <FichajeOperarios> obtenerFichajeOperarios(Date fecha) throws SQLException{
            FichajeOperariosDAO fichajeOperariosDAO=new FichajeOperariosDAO();
            return fichajeOperariosDAO.obtenerFichajeOperarios(fecha);  
        }
        public ArrayList <FichajeOperarios> obtenerFichajeOperariosSalida(Date fecha) throws SQLException{
            FichajeOperariosDAO fichajeOperariosDAO=new FichajeOperariosDAO();
            return fichajeOperariosDAO.obtenerFichajeOperariosSalida(fecha);  
        }
        public ArrayList <FichajeOperarios> obtenerFichajeOperariosInforme(String codigo,Date fecha) throws SQLException{
            FichajeOperariosDAO fichajeOperariosDAO=new FichajeOperariosDAO();
            return fichajeOperariosDAO.obtenerFichajeOperariosInforme(codigo,fecha);  
        }
}
