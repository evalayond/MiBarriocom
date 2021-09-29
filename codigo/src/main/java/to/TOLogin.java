
package to;

import java.util.Date;

public class TOLogin extends TOVendedores{
    
    private int idLogin;
    private int idVendedoresLogin;
    private Date fecha;

    public TOLogin(int idLogin, int idVendedoresLogin, Date fecha, int idVendedores, int idUsuarioVendedor, String usuario, String clave, Date fechaLogin, int idUsuarios, String nombres, String apellidos, String tipoDocumento, String identificacion, String rolUsuario, String direccion, String telefono, String correo, int edad) {
        super(idVendedores, idUsuarioVendedor, usuario, clave, fechaLogin, idUsuarios, nombres, apellidos, tipoDocumento, identificacion, rolUsuario, direccion, telefono, correo, edad);
        this.idLogin = idLogin;
        this.idVendedoresLogin = idVendedoresLogin;
        this.fecha = fecha;
    }

    public TOLogin() {
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdVendedoresLogin() {
        return idVendedoresLogin;
    }

    public void setIdVendedoresLogin(int idVendedoresLogin) {
        this.idVendedoresLogin = idVendedoresLogin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
} 

