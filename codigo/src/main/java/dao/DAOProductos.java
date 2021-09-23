
package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOProductos;


public class DAOProductos {
    
   private ConexionDB con;
    private final String nombreTabla = "vendedores";
    private final String[] columnas = {"nombreProducto","categoria","unidadMedida", "cantidad","valorUnitarioCompra", "valorUnitarioVenta"};

    public DAOProductos() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.constructor: " + ex.getMessage());
        }
    }

    public boolean insertarProducto(TOProductos TOProducto) {
        String[] valores = { 
            TOProducto.getNombreProducto(),
            TOProducto.getCategoria(),
            TOProducto.getUnidadMedida(),            
            String.valueOf (TOProducto.getCantidad()), 
            String.valueOf (TOProducto.getValorUnitarioCompra()),
            String.valueOf(TOProducto.getValorUnitarioVenta()),    
        };
        
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.insentarProducto: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarProducto(TOProductos TOProducto) {
        String[] valores ={
            TOProducto.getNombreProducto(),
            TOProducto.getCategoria(),
            TOProducto.getUnidadMedida(),            
            String.valueOf (TOProducto.getCantidad()), 
            String.valueOf (TOProducto.getValorUnitarioCompra()),
            String.valueOf(TOProducto.getValorUnitarioVenta()), 
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOProducto.getIdProducto());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.actualizarProducto: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idUsuario) {
        try {
            return con.borrar(nombreTabla, idUsuario);
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.eliminarProducto : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOProductos> listaProductos() {
        ArrayList<TOProductos> productos = new ArrayList<>();
        TOProductos producto;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                producto = new TOProductos();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setValorUnitarioCompra(rs.getDouble("valorUnitarioCompra"));
                producto.setValorUnitarioVenta(rs.getDouble("valorUnitarioVenta"));
                
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.out.println("Error en DAOProductos.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOProductos.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
