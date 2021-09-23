
package controller;

import dao.DAOProductos;
import java.util.ArrayList;
import to.TOProductos;

public class controlProductos {
    DAOProductos ProductosDAO = new DAOProductos();
    
    public boolean insertProducto(TOProductos TOProducto){
        return ProductosDAO.insertarProducto(TOProducto);
    }
    
    public boolean actualizarProducto(TOProductos TOProducto){
        return ProductosDAO.actualizarProducto(TOProducto);
    }
    
    public boolean eliminarProducto(int idProducto){
        return ProductosDAO.eliminarProducto(idProducto);
    }
    
    public ArrayList<TOProductos> listaProductos(){
        return ProductosDAO.listaProductos();
    }
}
