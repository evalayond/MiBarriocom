package controller;

import dao.DAOLogin;
import dao.DAOVendedores;
import java.util.ArrayList;
import to.TOLogin;
import to.TOVendedores;

public class controlLogin {

    DAOVendedores vendedoresDAO = new DAOVendedores();

    public TOVendedores login(String usuario, String clave) {
        return vendedoresDAO.login(usuario, clave);
    }

}