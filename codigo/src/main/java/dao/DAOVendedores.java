/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOVendedores;

/**
 *
 * @author María
 */
public class DAOVendedores {
 
   private ConexionDB con;
    private final String nombreTabla = "Vendedores";
    private final String[] columnas = {"idUsurioVendedor","usuario","clave","fechaLogin"};

    public DAOVendedores() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores.constructor: " + ex.getMessage());
        }
    }

    public boolean insentarVendedor(TOVendedores TOVendedor) {
        String[] valores = {
            String.valueOf(TOVendedor.getIdUsuarioVendedor()), 
            TOVendedor.getUsuario(),
            TOVendedor.getClave(), 
            TOVendedor.getFechaLogin().toString(), 
            
        };
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insentarUsuario: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarUsuario(TOVendedores TOVendedor) {
        String[] valores ={
            String.valueOf(TOVendedor.getIdUsuarioVendedor()), 
            TOVendedor.getUsuario(),
            TOVendedor.getClave(), 
            TOVendedor.getFechaLogin().toString(),
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOVendedor.getIdVendedores());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.actualizarUsuario: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarVendedor(int idUsuario) {
        try {
            return con.borrar(nombreTabla, idUsuario);
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores .eliminarVendedor : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOVendedores> listaVendedores(int idUsuario) {
        ArrayList<TOVendedores> vendedores = new ArrayList<>();
        TOVendedores vendedor;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                vendedor = new TOVendedores();
                vendedor.setIdUsuarioVendedor(rs.getInt("idUsurioVendedor"));
                vendedor.setUsuario(rs.getString("usuario"));
                vendedor.setClave(rs.getString("clave"));
                vendedor.setFechaLogin(rs.getDate("fechaLogin"));
                
                vendedores.add(vendedor);
            }
            return vendedores;
        } catch (SQLException ex) {
            System.out.println("Error en DAOVendedores.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}

   
