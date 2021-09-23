
package controller;

import dao.DAOEgresos;
import java.util.ArrayList;
import to.TOEgresos;

public class controlEgresos {
      DAOEgresos EgresosDAO = new DAOEgresos();
    
    public boolean insertEngreso(TOEgresos TOEgreso){
        return EgresosDAO.insertarEgreso (TOEgreso);
    }
    
    public boolean actualizarEgreso(TOEgresos TOEgreso){
        return EgresosDAO.actualizarEgreso(TOEgreso);
    }
    
    public boolean eliminarEgreso(int idEgresos){
        return EgresosDAO.eliminarEgreso(idEgresos);
    }
    
    public ArrayList<TOEgresos> listaEgresos(){
        return EgresosDAO.listaEgresos();
    }
}
   
