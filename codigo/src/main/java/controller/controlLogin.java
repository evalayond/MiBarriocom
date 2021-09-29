
package controller;

import dao.DAOLogin;
import java.util.ArrayList;
import to.TOLogin;
import to.TOVendedores;

public class controlLogin {
    DAOLogin loginDAO = new DAOLogin();
    
    public boolean insertLogin(TOLogin TOLog){
        return loginDAO.insertarLogin(TOLog);
    }
    
    public boolean actualizarLogin(TOLogin TOLog){
        return loginDAO.actualizarLogin(TOLog);
    }
    
    public boolean eliminarLogin(int idLogin){
        return loginDAO.eliminarLogin(idLogin);
    }
    
    public ArrayList<TOLogin> listaLogin(){
        return loginDAO.listaLogin();
    }
}

