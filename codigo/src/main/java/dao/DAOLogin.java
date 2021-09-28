
package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import to.TOLogin;


public class DAOLogin {
    
    private ConexionDB con;
    private final String nombreTabla = "login";
    private final String[] columnas = {"idLogin","idVendedoresLogin","fecha"};
    private  final String vistaTabla = "vistalogin";
    
    public DAOLogin() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOLogin.constructor: " + ex.getMessage());
        }
    }

    public boolean insertarLogin(TOLogin TOLog) {
        String[] valores = {
            String.valueOf(TOLog.getIdVendedoresLogin()), 
            TOLog.getFecha().toString(),
        };
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOLogin.insentarLogin: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarLogin(TOLogin TOLog) {
        String[] valores ={
            String.valueOf(TOLog.getIdVendedoresLogin()), 
            TOLog.getFecha().toString(), 
            
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOLog.getIdVendedoresLogin());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DALogin.actualizarLogin: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarLogin(int idLogin) {
        try {
            return con.borrar(nombreTabla, idLogin);
        } catch (Exception ex) {
            System.out.println("Error en DALogin .eliminarLogin : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOLogin> listaLogin() {
        ArrayList<TOLogin> log = new ArrayList<>();
        TOLogin login;
        try {
            
            ResultSet rs = con.consultarTabla(vistaTabla);
            while (rs.next()) {
                login = new TOLogin();
                login.setIdLogin(rs.getInt("idLogin"));
                login.setIdVendedoresLogin(rs.getInt("idVendedoresLogin"));
                login.setFecha(rs.getDate("fecha"));
                login.setIdUsuarioVendedor(rs.getInt("idUsurioVendedor"));
                login.setUsuario(rs.getString("usuario"));
                login.setClave(rs.getString("clave"));
               
                log.add(login);
            }
            return log;
        } catch (SQLException ex) {
            System.out.println("Error en DAOLogin.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOLogin.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
