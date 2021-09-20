
package to;

public class TOProductos {
    
  private  int idProducto;
  private String nombreProducto;
  private String categoria;
  private int cantidad;
  private Double valorUnitarioCompra;
  private Double valorUnitarioVenta;

    public TOProductos(int idProducto, String nombreProducto, String categoria, int cantidad, Double valorUnitarioCompra, Double valorUnitarioVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.valorUnitarioCompra = valorUnitarioCompra;
        this.valorUnitarioVenta = valorUnitarioVenta;
    }

    public TOProductos() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getValorUnitarioCompra() {
        return valorUnitarioCompra;
    }

    public Double getValorUnitarioVenta() {
        return valorUnitarioVenta;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setValorUnitarioCompra(Double valorUnitarioCompra) {
        this.valorUnitarioCompra = valorUnitarioCompra;
    }

    public void setValorUnitarioVenta(Double valorUnitarioVenta) {
        this.valorUnitarioVenta = valorUnitarioVenta;
    }
    
    
}
