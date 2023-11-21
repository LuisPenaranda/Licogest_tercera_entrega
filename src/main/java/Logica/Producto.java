
package Logica;


import java.util.ArrayList;

public class Producto {
    private String nom;
    private double precio;
    private int cantidad;
    private String marca;
    private int mililitros;

    public Producto(String nom, double precio, int cantidad, String marca, int mililitros) {
        this.nom = nom;
        this.precio = precio;
        this.cantidad = cantidad;
        this.marca = marca;
        this.mililitros = mililitros;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    // ArrayList de productos disponibles
    private static ArrayList<Producto> productosDisponibles = new ArrayList<>();

    // Método para consultar productos
    public static ArrayList<Producto> consultarProductos() {
        return productosDisponibles;
    }

    // Método para agregar un producto
    public static void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    // Método para eliminar un producto
    public static void eliminarProducto(int indice) {
        if (indice >= 0 && indice < productosDisponibles.size()) {
            productosDisponibles.remove(indice);
        }
    }

    // Método para cambiar los detalles de un producto
    public static void cambiarProducto(int indice, String nuevoNom, double nuevoPrecio, int nuevaCantidad, String nuevaMarca, int nuevosMililitros) {
        if (indice >= 0 && indice < productosDisponibles.size()) {
            Producto producto = productosDisponibles.get(indice);
            producto.setNom(nuevoNom);
            producto.setPrecio(nuevoPrecio);
            producto.setCantidad(nuevaCantidad);
            producto.setMarca(nuevaMarca);
            producto.setMililitros(nuevosMililitros);
        }
    }
}

