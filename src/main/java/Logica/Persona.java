
package Logica;


public class Persona {
    private String nombre;
    private String apellido;
    private String ID;
    private String celular;

    public Persona(String nombre, String apellido, String ID, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ID = ID;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", ID: " + ID + ", Celular: " + celular;
    }
}
