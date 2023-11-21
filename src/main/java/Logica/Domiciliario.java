
package Logica;

public class Domiciliario extends Persona {
    private String direccion;
    private boolean vehiculoPropio;
    private boolean vehiculoEmpresarial;

    public Domiciliario(String nombre, String apellido, String ID, String celular, String direccion, boolean vehiculoPropio, boolean vehiculoEmpresarial) {
        super(nombre, apellido, ID, celular);
        this.direccion = direccion;
        this.vehiculoPropio = vehiculoPropio;
        this.vehiculoEmpresarial = vehiculoEmpresarial;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dirección: " + direccion + ", Vehículo Propio: " + vehiculoPropio + ", Vehículo Empresarial: " + vehiculoEmpresarial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getVehiculoPropio() {
        return vehiculoPropio;
    }

    public void setVehiculoPropio(Boolean vehiculoPropio) {
        this.vehiculoPropio = vehiculoPropio;
    }

    public Boolean getVehiculoEmpresarial() {
        return vehiculoEmpresarial;
    }

    public void setVehiculoEmpresarial(Boolean vehiculoEmpresarial) {
        this.vehiculoEmpresarial = vehiculoEmpresarial;
    }

}






