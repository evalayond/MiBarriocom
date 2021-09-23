
package controller;


import dao.DAOVendedores;
import java.util.ArrayList;
import to.TOVendedores;

public class controlVendedores {
    DAOVendedores VendedoresDAO = new DAOVendedores();
    
    public boolean insertVendedor(TOVendedores TOVendedor){
        return VendedoresDAO.insertarVendedor(TOVendedor);
    }
    
    public boolean actualizarVendedor(TOVendedores TOVendedor){
        return VendedoresDAO.actualizarVendedor(TOVendedor);
    }
    
    public boolean eliminarUsuario(int idUsuario){
        return VendedoresDAO.eliminarVendedor(idUsuario);
    }
    
    public ArrayList<TOVendedores> listaVendedores(){
        return VendedoresDAO.listaVendedores();
    }
}
    
