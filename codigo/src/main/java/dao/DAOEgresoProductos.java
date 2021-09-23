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
import to.TOEgresoProductos;

/**
 *
 * @author María
 */
public class DAOEgresoProductos {
    private ConexionDB con;
    private final String nombreTabla = "EgresoProductos";
    private final String[] columnas = {"idProducto","idEgresos", "cantidadVendida", "precioCompra", "precioVenta"};

    public DAOEgresoProductos() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresoProductos.constructor: " + ex.getMessage());
        }
    }

    public boolean insertarEgresoProductos(TOEgresoProductos TOEgresoProducto) {
        String[] valores = { 
            String.valueOf(TOEgresoProducto.getIdProductos()),
            String.valueOf(TOEgresoProducto.getIdEgresos()),
            String.valueOf (TOEgresoProducto.getCantidadVendida()),
            String.valueOf(TOEgresoProducto.getPrecioCompra()),
            String.valueOf (TOEgresoProducto.getPrecioVenta()),
        };
        
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresoProductos.insentarEgreso: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarEgresoProducto(TOEgresoProductos TOEgresoProducto) {
        String[] valores ={
            String.valueOf(TOEgresoProducto.getIdProductos()),
            String.valueOf(TOEgresoProducto.getIdEgresos()),
            String.valueOf (TOEgresoProducto.getCantidadVendida()),
            String.valueOf(TOEgresoProducto.getPrecioCompra()),
            String.valueOf (TOEgresoProducto.getPrecioVenta()),
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOEgresoProducto.getIdEgresoProductos());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresoProductos.actualizarEgresosProducto: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarEgresoProducto(int IdEgresoProductos) {
        try {
            return con.borrar(nombreTabla,IdEgresoProductos);
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresoProductos.eliminarEgresoProducto : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOEgresoProductos> listaEgresoProductos() {
        ArrayList<TOEgresoProductos> egresosProductos = new ArrayList<>();
        TOEgresoProductos EgresosProducto;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                EgresosProducto= new TOEgresoProductos();
                EgresosProducto.setIdEgresoProductos(rs.getInt("idEgresoProductos"));
                EgresosProducto.setIdProductos(rs.getInt("idProductos"));
                EgresosProducto.setIdEgresos(rs.getInt("idEgresos"));
                EgresosProducto.setCantidadVendida(rs.getDouble("cantidadVendida"));
                EgresosProducto.setPrecioCompra(rs.getDouble("precioCompra"));
                EgresosProducto.setPrecioVenta(rs.getDouble("precioVenta"));
                
                egresosProductos.add(EgresosProducto);
            }
            return egresosProductos;
        } catch (SQLException ex) {
            System.out.println("Error en DAOEgresoProductos.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOEgresoProductos.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
