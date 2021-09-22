
package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOIngresos;


public class DAOIngresos {
    
    private ConexionDB con;
    private final String nombreTabla = "Ingresos";
    private final String[] columnas = {"idProducto","cantidadIngresoProducto","fechaIngreso", "costoUnitario","idUsuarios"};

    public DAOIngresos() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOIngresos.constructor: " + ex.getMessage());
        }
    }

    public boolean insentarProducto(TOIngresos TOIngresos) {
        String[] valores = { 
            String.valueOf(TOIngresos.getIdProducto()),
            String.valueOf (TOIngresos.getCantidadIngresoProducto()),
            TOIngresos.getFechaIngreso().toString(),
            String.valueOf (TOIngresos.getCostoUnitario()),
            String.valueOf (TOIngresos.getIdUsuarios()), 
                
        };
        
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.insentarProducto: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarIngreso(TOIngresos TOIngresos) {
        String[] valores ={
            String.valueOf(TOIngresos.getIdProducto()),
            String.valueOf (TOIngresos.getCantidadIngresoProducto()),
            TOIngresos.getFechaIngreso().toString(),
            String.valueOf (TOIngresos.getCostoUnitario()),
            String.valueOf (TOIngresos.getIdUsuarios()), 
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOIngresos.getIdIngresos());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOIngresos.actualizarIngresos: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarIngreso(int idIngresos) {
        try {
            return con.borrar(nombreTabla, idIngresos);
        } catch (Exception ex) {
            System.out.println("Error en DAOIngresos .eliminarIngreso : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOIngresos> listaIngresos(int idIngresos) {
        ArrayList<TOIngresos> ingresos = new ArrayList<>();
        TOIngresos ingreso;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                ingreso = new TOIngresos();
                ingreso.setIdIngresos(rs.getInt("idIngresos"));
                ingreso.setIdProducto(rs.getInt("idProducto"));
                ingreso.setCantidadIngresoProducto(rs.getDouble("cantidadIngresoProducto"));
                ingreso.setFechaIngreso(rs.getDate("fechaIngreso"));
                ingreso.setCostoUnitario(rs.getDouble("costoUnitario"));
                ingreso.setIdUsuarios(rs.getInt("idUsuarios"));
                
                ingresos.add(ingreso);
            }
            return ingresos;
        } catch (SQLException ex) {
            System.out.println("Error en DAOIngresos.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOIngresos.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
