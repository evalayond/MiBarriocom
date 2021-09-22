/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOUsuarios;
import to.TOUsuarios;
import java.util.ArrayList;

/**
 *
 * @author María
 */
public class controlUsuarios {
    DAOUsuarios UsuariosDAO = new DAOUsuarios();
    
    public boolean insertUsuario(TOUsuarios TOUsuario){
        return UsuariosDAO.insentarUsuario(TOUsuario);
    }
    
    public boolean actualizarUsuario(TOUsuarios TOUsuario){
        return UsuariosDAO.actualizarUsuario(TOUsuario);
    }
    
    public boolean eliminarUsuario(int idUsuario){
        return UsuariosDAO.eliminarUsuario(idUsuario);
    }
    
    public ArrayList<TOUsuarios> listaUsuarios(){
        return UsuariosDAO.listaUsuarios(0);
    }
}
