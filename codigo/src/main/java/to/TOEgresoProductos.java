
package to;


public class TOEgresoProductos {
    
    
    private int idEgresoProductos;
    private int idProductos;
    private int idEgresos;
    private Double cantidadVendida;
    private Double precioCompra;
    private Double precioVenta;

    public TOEgresoProductos(int idEgresoProductos, int idProductos, int idEgresos, Double cantidadVendida, Double precioCompra, Double precioVenta) {
        this.idEgresoProductos = idEgresoProductos;
        this.idProductos = idProductos;
        this.idEgresos = idEgresos;
        this.cantidadVendida = cantidadVendida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public TOEgresoProductos() {
    }

    public int getIdEgresoProductos() {
        return idEgresoProductos;
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

    public void setIdEgresoProductos(int idEgresoProductos) {
        this.idEgresoProductos = idEgresoProductos;
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
