
package Logica;

public class Pedido {
    private int numeroPedido;
    private int id_cliente;
    private String ids_productos;
    private int id_domiciliario;
    private double costoDomicilio;

    public Pedido(int numeroPedido, int cliente, String productos, int domiciliario, double costoDomicilio) {
        this.numeroPedido = numeroPedido;
        this.id_cliente = cliente;
        this.ids_productos = productos;
        this.id_domiciliario = domiciliario;
        this.costoDomicilio = costoDomicilio;
    }

    

    @Override
    public String toString() {
        return "Número de Pedido: " + numeroPedido + "\nCliente: " + id_cliente + "\nDomiciliario: " + id_domiciliario + "\nCosto del Domicilio: $" + costoDomicilio;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setIds_productos(String ids_productos) {
        this.ids_productos = ids_productos;
    }

    public String getIds_productos() {
        return ids_productos;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_domiciliario() {
        return id_domiciliario;
    }

    public void setId_domiciliario(int id_domiciliario) {
        this.id_domiciliario = id_domiciliario;
    }

    public double getCostoDomicilio() {
        return costoDomicilio;
    }

    public void setId_domiciliario(double costoDomicilio) {
        this.costoDomicilio = costoDomicilio;
    }

}
