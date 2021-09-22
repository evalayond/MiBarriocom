package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private String DB_driver = "";
    private String url = "";
    private String db = "";
    private String host = "";
    private String username = "";
    private String password = "";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public ConexionDB() {

        DB_driver = "com.mysql.jdbc.driver";
        host = "localhost:3306";
        db = "s28";
        url = "jdbc:mysql://" + host + "/" + db;
        username = "root";
        password = "root";

        try {//asignacion del driver
            Class.forName(DB_driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {//realizar conexion
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(8);
            System.out.println("conectado");
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        try {
            con.setAutoCommit(true);
            return con;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void closeConnetion() {

        if (con != null) {
            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

    public boolean setAutoCommitDB(boolean param) {
        try {
            con.setAutoCommit(param);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean commitDB() {
        try {
            con.commit();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rollbackDB() {
        try {
            con.rollback();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet consultarTabla(String nombreTabla) {

        String query = "SELECT * FROM" + nombreTabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int insertar(String nombreTabla, String[] columnas, String[] valores) {

        StringBuilder query = new StringBuilder("INSERT INTO");
        query.append(nombreTabla);
        query.append(" (");
        for (int i = 0; i < columnas.length; i++) {
            query.append(columnas[i]);

            if (i < columnas.length) {
                query.append(",");
            }
        }
        query.append(") VALUES (");
        for (int i = 0; i < valores.length; i++) {
            query.append("'");
            query.append(valores[i]);
            query.append("'");
            if (i < valores.length) {
                query.append(",");
            }
        }
        query.append(")");
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query.toString());
            return rs.getInt("id" + nombreTabla);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public boolean actualizar(String nombreTabla, String[] columnas, String[] valores, int id) {

        StringBuilder query = new StringBuilder("UPDATE");
        query.append(nombreTabla);
        query.append("SET");
        for (int i = 0; i < columnas.length; i++) {
            query.append(columnas[i]);
            query.append(" = '");
            query.append(valores[i]);
            query.append("'");
            if (i < columnas.length) {
                query.append(",");
            }
        }
        query.append(" WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query.toString());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean borrar(String nombreTabla, int id) {

        StringBuilder query = new StringBuilder("DELETE FROM");
        query.append(nombreTabla);
        query.append("WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query.toString());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
