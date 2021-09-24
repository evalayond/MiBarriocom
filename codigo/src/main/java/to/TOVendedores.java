
package to;

import java.util.Date;

public class TOVendedores extends TOUsuarios{
   
   private int idVendedores;
   private int idUsuarioVendedor;
   private String usuario;
   private String clave;
   

    public TOVendedores(int idVendedores, int idUsuarioVendedor, String usuario, String clave, Date fechaLogin, int idUsuarios, String nombres, String apellidos, String tipoDocumento, String identificacion, String rolUsuario, String direccion, String telefono, String correo, int edad) {
        super(idUsuarios, nombres, apellidos, tipoDocumento, identificacion, rolUsuario, direccion, telefono, correo, edad);
        this.idVendedores = idVendedores;
        this.idUsuarioVendedor = idUsuarioVendedor;
        this.usuario = usuario;
        this.clave = clave;
        
    }
    
    public TOVendedores() {
    }

    public TOVendedores(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getIdVendedores() {
        return idVendedores;
    }

    public int getIdUsuarioVendedor() {
        return idUsuarioVendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setIdVendedores(int idVendedores) {
        this.idVendedores = idVendedores;
    }

    public void setIdUsuarioVendedor(int idUsuarioVendedor) {
        this.idUsuarioVendedor = idUsuarioVendedor;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
