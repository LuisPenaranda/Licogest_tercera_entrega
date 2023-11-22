package Logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Local {
    
    //Atributes
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Producto> listaproductos = new ArrayList<>();
    private ArrayList<Domiciliario> listaDomiciliarios = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    //Constructor
    public Local() {
        fillListaClientes();
        fillListaProductos();
        fillListaDomiciliarios();
    }

    //GETTERs
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> getListaproductos() {
        return listaproductos;
    }

    public ArrayList<Domiciliario> getListaDomiciliarios() {
        return listaDomiciliarios;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    //SETTERS
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setListaproductos(ArrayList<Producto> listaproductos) {
        this.listaproductos = listaproductos;
    }

    public void setListaDomiciliarios(ArrayList<Domiciliario> listaDomiciliarios) {
        this.listaDomiciliarios = listaDomiciliarios;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    //Fill ArrayLists
    //Lee los archivos que contienen los datos de los arrays
    public void fillListaClientes() {
        try {
            File file_clientes = new File("clientes.txt");
            Scanner reader_clientes = new Scanner(file_clientes);
            String data_clientes = "";

            while (reader_clientes.hasNextLine()) {
                data_clientes = reader_clientes.nextLine();

                String[] arrOfStr = data_clientes.split("-", 6);
                ArrayList<String> aux_data = new ArrayList<>();
                String aux_nombre = "";
                String aux_apellido = "";
                String aux_id = "";
                String aux_celular = "";
                String aux_direccion = "";
                String aux_metodoPago = "";
                int iterator = 0;
        
                for (String a : arrOfStr) {
                    //System.out.println(a);
                    if(iterator == 0){
                        aux_nombre = a;
                    }
                    if(iterator == 1){
                        aux_apellido = a;
                    }
                    if(iterator == 2){
                        aux_id = a;
                    }
                    if(iterator == 3){
                        aux_celular = a;
                    }
                    if(iterator == 4){
                        aux_direccion = a;
                    }
                    if(iterator == 5){
                        aux_metodoPago = a;
                    }
                    iterator++;
                }

                Cliente aux = new Cliente(aux_nombre, aux_apellido, aux_id, aux_celular, aux_direccion, aux_metodoPago);
                this.listaClientes.add(aux);
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public void fillListaProductos() {
        try {
            File file_productos = new File("productos.txt");
            Scanner reader_productos = new Scanner(file_productos);
            String data_productos = "";
            while (reader_productos.hasNextLine()) {
                data_productos = reader_productos.nextLine();

                String[] arrOfStr = data_productos.split("-", 6);
                String getNom = "";
                String getPrecio = "";
                String getCantidad = "";
                String getMarca = "";
                String getMililitros = "";
                int iterator = 0;
        
                for (String a : arrOfStr) {
                    
                    if(iterator == 0){
                        getNom = a;
                    }
                    if(iterator == 1){
                        getPrecio = a;
                    }
                    if(iterator == 2){
                        getCantidad = a;
                    }
                    if(iterator == 3){
                        getMarca = a;
                    }
                    if(iterator == 4){
                        getMililitros = a;
                    }
                    iterator++;
                }

                Producto aux = new Producto(getNom, Double.parseDouble(getPrecio),Integer.parseInt(getCantidad), getMarca , Integer.parseInt(getMililitros));
                listaproductos.add(aux);
            }
            

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public void fillListaDomiciliarios() {
        try {
            File file_domiciliarios = new File("domiciliarios.txt");
            Scanner reader_domiciliarios = new Scanner(file_domiciliarios);
            String data_domiciliarios = "";

            while (reader_domiciliarios.hasNextLine()) {
                data_domiciliarios = reader_domiciliarios.nextLine();

                String[] arrOfStr = data_domiciliarios.split("-", 6);
                ArrayList<String> aux_data = new ArrayList<>();
                String aux_nombre = "";
                String aux_apellido = "";
                String aux_id = "";
                String aux_celular = "";
                String aux_direccion = "";
                Boolean aux_vpropio = true;
                Boolean aux_vempresarial = false;
                int iterator = 0;
        
                for (String a : arrOfStr) {
                    //System.out.println(a);
                    if(iterator == 0){
                        aux_nombre = a;
                    }
                    if(iterator == 1){
                        aux_apellido = a;
                    }
                    if(iterator == 2){
                        aux_id = a;
                    }
                    if(iterator == 3){
                        aux_celular = a;
                    }
                    if(iterator == 4){
                        aux_direccion = a;
                    }
                    if(iterator == 5){
                        aux_vpropio = true;
                    }
                    if(iterator == 6){
                        aux_vempresarial = false;
                    }
                    iterator++;
                }

                Domiciliario aux = new Domiciliario(aux_nombre, aux_apellido, aux_id, aux_celular, aux_direccion, aux_vpropio, aux_vempresarial);
                this.listaDomiciliarios.add(aux);
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }


    //Saves
    public void saveClientes () {
        try{
            File fout = new File("clientes.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Cliente cliente : this.listaClientes){
                String linea = cliente.getNombre() + "-" +
                                cliente.getApellido() + "-" +
                                cliente.getID() + "-" +
                                cliente.getCelular() + "-" +
                                cliente.getDireccion() + "-" +
                                cliente.getMetodoPago();
                
                bw.write(linea);
                bw.newLine();

            }

            bw.close();
    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveProductos(){
        try{
            File fout = new File("productos.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Producto producto : this.listaproductos){
                String linea = producto.getNom() + "-" +
                                producto.getPrecio() + "-" +
                                producto.getCantidad() + "-" +
                                producto.getMarca() + "-" +
                                producto.getMililitros();
                
                bw.write(linea);
                bw.newLine();

            }

            bw.close();
    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveDomiciliarios (){
        try{
            File fout = new File("domiciliarios.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Domiciliario domiciliario : this.listaDomiciliarios){
                String linea = domiciliario.getNombre() + "-" +
                                domiciliario.getApellido() + "-" +
                                domiciliario.getID() + "-" +
                                domiciliario.getCelular() + "-" +
                                domiciliario.getDireccion() + "-" +
                                domiciliario.getVehiculoPropio() + "-" +
                                domiciliario.getVehiculoEmpresarial();
                
                bw.write(linea);
                bw.newLine();

            }

            bw.close();
    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void savePedidos (){
        try{
            File fout = new File("pedidos.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Pedido pedido : this.pedidos){
                String linea = pedido.getNumeroPedido() + "-" +
                                pedido.getId_cliente() + "-" +
                                pedido.getIds_productos() + "-" +
                                pedido.getId_domiciliario() + "-" +
                                pedido.getCostoDomicilio();
                
                bw.write(linea);
                bw.newLine();

            }

            bw.close();
    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
