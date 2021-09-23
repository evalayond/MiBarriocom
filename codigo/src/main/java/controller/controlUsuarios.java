
package controller;

import dao.DAOUsuarios;
import to.TOUsuarios;
import java.util.ArrayList;

public class controlUsuarios {
    DAOUsuarios UsuariosDAO = new DAOUsuarios();
    
    public boolean insertUsuario(TOUsuarios TOUsuario){
        return UsuariosDAO.insertarUsuario(TOUsuario);
    }
    
    public boolean actualizarUsuario(TOUsuarios TOUsuario){
        return UsuariosDAO.actualizarUsuario(TOUsuario);
    }
    
    public boolean eliminarUsuario(int idUsuario){
        return UsuariosDAO.eliminarUsuario(idUsuario);
    }
    
    public ArrayList<TOUsuarios> listaUsuarios(){
        return UsuariosDAO.listaUsuarios();
    }
}
