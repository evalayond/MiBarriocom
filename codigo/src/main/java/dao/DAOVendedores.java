
package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOVendedores;


public class DAOVendedores {
 
    private ConexionDB con;
    private final String nombreTabla = "vendedores";
    private final String[] columnas = {"idUsurioVendedor","usuario","clave"};
    private  final String vistaTabla = "vistavendedores";

    public DAOVendedores() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores.constructor: " + ex.getMessage());
        }
    }

    public boolean insertarVendedor(TOVendedores TOVendedor) {
        String[] valores = {
            String.valueOf(TOVendedor.getIdUsuarioVendedor()), 
            TOVendedor.getUsuario(),
            TOVendedor.getClave(), 
            
        };
        try {
            con.insertar(nombreTabla, columnas, valores);
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores.insentarUsuario: " + ex.getMessage());
            return false;
        }
        
    }

    public boolean actualizarVendedor(TOVendedores TOVendedor) {
        String[] valores ={
            String.valueOf(TOVendedor.getIdUsuarioVendedor()), 
            TOVendedor.getUsuario(),
            TOVendedor.getClave(), 
            
        };
        
        try {
            con.actualizar(nombreTabla, columnas, valores, TOVendedor.getIdVendedores());
            return true;
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores.actualizarVendedor: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarVendedor(int idVendedores) {
        try {
            return con.borrar(nombreTabla, idVendedores);
        } catch (Exception ex) {
            System.out.println("Error en DAOVendedores .eliminarVendedor : " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOVendedores> listaVendedores() {
        ArrayList<TOVendedores> vendedores = new ArrayList<>();
        TOVendedores vendedor;
        try {
            
            ResultSet rs = con.consultarTabla(vistaTabla);
            while (rs.next()) {
                vendedor = new TOVendedores();
                vendedor.setIdUsuarioVendedor(rs.getInt("idUsurioVendedor"));
                vendedor.setUsuario(rs.getString("usuario"));
                vendedor.setClave(rs.getString("clave"));
                vendedor.setIdUsuarios(rs.getInt("idUsuarios"));
                vendedor.setNombres(rs.getString("nombres"));
                vendedor.setApellidos(rs.getString("apellidos"));
                vendedor.setTipoDocumento(rs.getString("tipoDocumento"));
                vendedor.setIdentificacion(rs.getString("identificacion"));
                vendedor.setRolUsuario(rs.getString("rolUsuario"));
                vendedor.setDireccion(rs.getString("direccion"));
                vendedor.setTelefono(rs.getString("telefono"));
                vendedor.setCorreo(rs.getString("correo"));
                vendedor.setEdad(rs.getInt("edad"));
                
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

   
