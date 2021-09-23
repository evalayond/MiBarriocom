
package controller;

import dao.DAOIngresos;
import java.util.ArrayList;
import to.TOIngresos;

public class controlIngresos {
       DAOIngresos IngresosDAO = new DAOIngresos();
    
    public boolean insertIngreso(TOIngresos TOIngreso){
        return IngresosDAO.insertarIngreso (TOIngreso);
    }
    
    public boolean actualizarIngreso(TOIngresos TOIngreso){
        return IngresosDAO.actualizarIngreso(TOIngreso);
    }
    
    public boolean eliminarIngreso(int idIngresos){
        return IngresosDAO.eliminarIngreso(idIngresos);
    }
    
    public ArrayList<TOIngresos> listaIngresos(){
        return IngresosDAO.listaIngresos();
    }
}
