
package Logica;

public class Cliente extends Persona {
    private String direccion;
    private String metodoPago;
    

    public Cliente(String nombre, String apellido, String ID, String celular, String direccion, String metodoPago) {
        super(nombre, apellido, ID, celular);
        this.direccion = direccion;
        this.metodoPago = metodoPago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    
    
    

    @Override
    public String toString() {
        return super.toString() + ", Dirección: " + direccion + ", Método de Pago: " + metodoPago;
    }
}
