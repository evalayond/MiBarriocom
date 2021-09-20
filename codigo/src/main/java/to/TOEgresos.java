
package to;

import java.util.Date;


public class TOEgresos {
    
    private int idEgresos;
    private Date fechaVenta;
    private Double total;
    private int idVendedor;

    public TOEgresos(int idEgresos, Date fechaVenta, Double total, int idVendedor) {
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
