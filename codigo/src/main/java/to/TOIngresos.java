
package to;

import java.util.Date;

public class TOIngresos extends TOUsuarios{
    
    private int idIngresos;
    private int idProducto;
    private Double cantidadIngresoProducto;
    private Date fechaIngreso;
    private Double costoUnitario;
    private int idUsuarios;

    public TOIngresos(int idIngresos, int idProducto, Double cantidadIngresoProducto, Date fechaIngreso, Double costoUnitario, int idUsuarios, String nombres, String apellidos, String tipoDocumento, String identificacion, String rolUsuario, String direccion, String telefono, String correo, int edad) {
        super(idUsuarios, nombres, apellidos, tipoDocumento, identificacion, rolUsuario, direccion, telefono, correo, edad);
        this.idIngresos = idIngresos;
        this.idProducto = idProducto;
        this.cantidadIngresoProducto = cantidadIngresoProducto;
        this.fechaIngreso = fechaIngreso;
        this.costoUnitario = costoUnitario;
        this.idUsuarios = idUsuarios;
    }

    public TOIngresos() {
    }

    public int getIdIngresos() {
        return idIngresos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public Double getCantidadIngresoProducto() {
        return cantidadIngresoProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidadIngresoProducto(Double cantidadIngresoProducto) {
        this.cantidadIngresoProducto = cantidadIngresoProducto;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    
    
    
}
