
package controller;

import dao.DAOEgresoProductos;
import java.util.ArrayList;
import to.TOEgresoProductos;

public class controlEgresoProductos {
    DAOEgresoProductos EgresoProductosDAO = new DAOEgresoProductos();
    
    public boolean insertEgresoProducto(TOEgresoProductos TOEgresoProducto){
        return EgresoProductosDAO.insertarEgresoProductos (TOEgresoProducto);
    }
    
    public boolean actualizarEgresoProducto(TOEgresoProductos TOEgresoProducto){
        return EgresoProductosDAO.actualizarEgresoProducto(TOEgresoProducto);
    }
    
    public boolean eliminarEgresoProducto(int idTOEgresoProducto){
        return EgresoProductosDAO.eliminarEgresoProducto(idTOEgresoProducto);
    }
    
    public ArrayList<TOEgresoProductos> listaEgresoProductos(){
        return EgresoProductosDAO.listaEgresoProductos();
    }
}
