
package to;

import java.util.Date;

public class TOUsuarios {
    
    private int idUsuarios;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String identificacion;
    private String rolUsuario;
    private String direccion;
    private String telefono;
    private String correo;
    private int edad;
   
    public TOUsuarios(int idUsuarios, String nombres, String apellidos, String tipoDocumento, String identificacion, String rolUsuario, String direccion, String telefono, String correo, int edad) {
        this.idUsuarios = idUsuarios;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.identificacion = identificacion;
        this.rolUsuario = rolUsuario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;  
    }

    public TOUsuarios() {
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }  
}
