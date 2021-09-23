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
import to.TOEgresos;

/**
 *
 * @author María
 */
public class DAOEgresos {
    private ConexionDB con;
    private final String nombreTabla = "Egresos";
    private final String[] columnas = {"fechaVenta", "total","idVendedor"};

    public DAOEgresos() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresos.constructor: " + ex.getMessage());
        }
    }

    public boolean insertarEgreso(TOEgresos TOEgreso) {
        String[] valores = { 
            TOEgreso.getFechaVenta().toString(),
            String.valueOf(TOEgreso.getTotal()),
            String.valueOf (TOEgreso.getIdVendedor()),
        };
        
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresos.insentarEgreso: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarEgreso(TOEgresos TOEgreso) {
        String[] valores ={
            TOEgreso.getFechaVenta().toString(),
            String.valueOf(TOEgreso.getTotal()),
            String.valueOf (TOEgreso.getIdVendedor()), 
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOEgreso.getIdEgresos());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresos.actualizarEgresos: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarEgreso(int idEgresos) {
        try {
            return con.borrar(nombreTabla,idEgresos);
        } catch (Exception ex) {
            System.out.println("Error en DAOIngresos .eliminarIngreso : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOEgresos> listaEgresos() {
        ArrayList<TOEgresos> egresos = new ArrayList<>();
        TOEgresos egreso;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                egreso = new TOEgresos();
                egreso.setIdEgresos(rs.getInt("idEgresos"));
                egreso.setFechaVenta(rs.getDate("fechaVenta"));
                egreso.setTotal(rs.getDouble("total"));
                egreso.setIdVendedor(rs.getInt("idVendedor"));
                
                egresos.add(egreso);
            }
            return egresos;
        } catch (SQLException ex) {
            System.out.println("Error en DAOEgresos.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresos.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
