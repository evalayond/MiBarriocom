
package to;


public class TOEgresoProductos {
    
    
    private int idEgresosProductos;
    private int idProductos;
    private int idEgresos;
    private Double cantidadVendida;
    private Double precioCompra;
    private Double precioVenta;

    public TOEgresoProductos(int idEgresosProductos, int idProductos, int idEgresos, Double cantidadVendida, Double precioCompra, Double precioVenta) {
        this.idEgresosProductos = idEgresosProductos;
        this.idProductos = idProductos;
        this.idEgresos = idEgresos;
        this.cantidadVendida = cantidadVendida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public TOEgresoProductos() {
    }

    public int getIdEgresosProductos() {
        return idEgresosProductos;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public int getIdEgresos() {
        return idEgresos;
    }

    public Double getCantidadVendida() {
        return cantidadVendida;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setIdEgresosProductos(int idEgresosProductos) {
        this.idEgresosProductos = idEgresosProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public void setIdEgresos(int idEgresos) {
        this.idEgresos = idEgresos;
    }

    public void setCantidadVendida(Double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
    
}
