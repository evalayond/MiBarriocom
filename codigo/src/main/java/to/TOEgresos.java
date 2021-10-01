
package to;

import java.util.Date;


public class TOEgresos extends TOVendedores{
    
    private int idEgresos;
    private Date fechaVenta;
    private Double total;
    private int idVendedor;

    public TOEgresos(int idEgresos, Date fechaVenta, Double total, int idVendedor, int idVendedores, int idUsuarioVendedor, String usuario, String clave, Date fechaLogin, int idUsuarios, String nombres, String apellidos, String tipoDocumento, String identificacion, String rolUsuario, String direccion, String telefono, String correo, int edad) {
        super(idVendedores, idUsuarioVendedor, usuario, clave, fechaLogin, idUsuarios, nombres, apellidos, tipoDocumento, identificacion, rolUsuario, direccion, telefono, correo, edad);
        this.idEgresos = idEgresos;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.idVendedor = idVendedor;
    }

    public TOEgresos() {
    }
    
    public int getIdEgresos() {
        return idEgresos;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdEgresos(int idEgresos) {
        this.idEgresos = idEgresos;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
}
