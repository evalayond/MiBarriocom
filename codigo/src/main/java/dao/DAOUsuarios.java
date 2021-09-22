package dao;

import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.TOUsuarios;

public class DAOUsuarios {

    private ConexionDB con;
    private final String nombreTabla = "usuarios";
    private final String[] columnas = {"nombres", "apellidos", "tipoDocumento", "identificacion", "rolUsuario", "direccion", "telefono", "correo", "edad"};

    public DAOUsuarios() {
        try {
            con = new ConexionDB();
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.constructor: " + ex.getMessage());
        }
    }

    public int insentarUsuario(TOUsuarios TOUsuario) {
        String[] valores = {TOUsuario.getNombres(), TOUsuario.getApellidos(), TOUsuario.getTipoDocumento(), TOUsuario.getIdentificacion(), TOUsuario.getRollUsuario(), TOUsuario.getDireccion(), TOUsuario.getCorreo(), TOUsuario.getEdad().toString()};
        try {
            con.insertar(nombreTabla, columnas, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insentarUsuario: " + ex.getMessage());
            return 0;
        }
    }

    public boolean actualizarUsuario(TOUsuarios TOUsuario) {
        String[] valores = {TOUsuario.getNombres(), TOUsuario.getApellidos(), TOUsuario.getTipoDocumento(), TOUsuario.getIdentificacion(), TOUsuario.getRollUsuario(), TOUsuario.getDireccion(), TOUsuario.getCorreo(), TOUsuario.getEdad().toString()};
        try {
            con.actualizar(nombreTabla, columnas, valores, TOUsuario.getIdUsuarios());
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.actualizarUsuario: " + ex.getMessage());
            return false;
        }
    

    public boolean eliminarUsuario(int idUsuario) {
        try {
            return con.borrar(nombreTabla, idUsuario);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.eliminarUsuario: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<TOUsuarios> listaUsuarios(int idUsuario) {
        ArrayList<TOUsuarios> usuarios = new ArrayList<>();
        TOUsuarios usuario;
        try {
            ResultSet rs = con.consultarTabla(nombreTabla);
            while (rs.next()) {
                usuario = new TOUsuarios();
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTipoDocumento(rs.getString("tipoDocumento"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setRollUsuario(rs.getString("rolUsuario"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEdad(rs.getInt("edad"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuarios.consultarTabla: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.consultarTabla: " + ex.getMessage());
            return null;
        }
    }
}
