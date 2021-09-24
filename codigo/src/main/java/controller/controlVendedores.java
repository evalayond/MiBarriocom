
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
    
    public boolean eliminarVendedor(int idVendedores){
        return VendedoresDAO.eliminarVendedor(idVendedores);
    }
    
    public ArrayList<TOVendedores> listaVendedores(){
        return VendedoresDAO.listaVendedores();
    }
}
    
