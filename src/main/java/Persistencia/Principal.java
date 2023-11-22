package Persistencia;

import Logica.Cliente;
import Logica.Domiciliario;
import Logica.Local;
import Logica.Pedido;
import Logica.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    public static void guardar_cliente(ArrayList<Cliente> clientes){
        try{
            File fout = new File("clientes.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Cliente cliente : clientes){
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

    public static void guardar_producto(ArrayList<Producto> productos){
        try{
            File fout = new File("productos.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Producto producto : productos){
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

    public static void guardar_domiciliarios(ArrayList<Domiciliario> domiciliarios){
        try{
            File fout = new File("domiciliarios.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Domiciliario domiciliario : domiciliarios){
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

    public static void guardar_pedidos(ArrayList<Pedido> pedidos){
        try{
            File fout = new File("pedido.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Pedido pedido : pedidos){
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDePedido = 1;
        Local local = new Local();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Producto> listaproductos = new ArrayList<>();
        ArrayList<Domiciliario> listaDomiciliarios = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        while (true) { 
            System.out.println("Menú:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Crear Domiciliario");
            System.out.println("3. Consulta produtos");
            System.out.println("4. Realizar pedido");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Crear Cliente:");

                    // Solicitar información del cliente al usuario
                    System.out.println("Nombre del cliente: ");
                    String nombre = scanner.next();
                    System.out.println("Apellido del cliente: ");
                    String apellido = scanner.next();
                    System.out.println("ID del cliente: ");
                    String id = scanner.next();
                    System.out.println("Número de celular del cliente: ");
                    String celular = scanner.next();
                    System.out.println("Dirección del cliente: ");
                    String direccion = scanner.next();
                    System.out.println("Método de pago del cliente: ");
                    String metodoPago = scanner.next();

                    // Crear un objeto Cliente con la información proporcionada
                    Cliente nuevoCliente = new Cliente(nombre, apellido, id, celular, direccion, metodoPago);

                    // Agregar el cliente al ArrayList de clientes
                    local.getListaClientes().add(nuevoCliente);
                    //listaClientes.add(nuevoCliente);

                    // Guardar Cliente en el documento
                    //guardar_cliente(listaClientes);
                    local.saveClientes();

                    System.out.println("Cliente creado con éxito.");
                    break;

                case 2:
                    System.out.println("Crear Domiciliario:");

                    // Solicitar información del domiciliario al usuario
                    System.out.println("Nombre del domiciliario: ");
                    String nombreDomiciliario = scanner.next();
                    System.out.println("Apellido del domiciliario: ");
                    String apellidoDomiciliario = scanner.next();
                    System.out.println("ID del domiciliario: ");
                    String idDomiciliario = scanner.next();
                    System.out.println("Número de celular del domiciliario: ");
                    String celularDomiciliario = scanner.next();
                    System.out.println("Dirección del domiciliario: ");
                    String direccionDomiciliario = scanner.next();
                    System.out.println("¿Tiene vehículo propio? (true/false): ");
                    boolean vehiculoPropioDomiciliario = scanner.nextBoolean();
                    System.out.println("¿Tiene vehículo empresarial? (true/false): ");
                    boolean vehiculoEmpresarialDomiciliario = scanner.nextBoolean();

                    // Crear el objeto Domiciliario con la información proporcionada
                    Domiciliario nuevoDomiciliario = new Domiciliario(nombreDomiciliario, apellidoDomiciliario, idDomiciliario, celularDomiciliario, direccionDomiciliario, vehiculoPropioDomiciliario, vehiculoEmpresarialDomiciliario);
                    
                    // Agregar el domiciliario al ArrayList de domiciliarios
                    listaDomiciliarios.add(nuevoDomiciliario);
                    local.getListaDomiciliarios().add(nuevoDomiciliario);

                    local.saveDomiciliarios();

                    System.out.println("Domiciliario creado con éxito.");
                    break;

                case 3:
                    System.out.println("Gestionar Productos:");
                    System.out.println("1. Mostrar productos");
                    System.out.println("2. Agregar producto");
                    System.out.println("3. Eliminar producto");
                    System.out.println("4. Cambiar producto");
                    System.out.print("Seleccione una opción ");

                    int opcionGestionProductos = scanner.nextInt();

                    switch (opcionGestionProductos) {
                        case 1:
                            System.out.println("Mostrar inventario:");
                            // Mostrar inventario de productos

  
                            if (local.getListaproductos().isEmpty()) {
                                System.out.println("El inventario de productos está vacío.");
                            } else {
                                System.out.println("Inventario de Productos:");
                                for (int i = 0; i < local.getListaproductos().size(); i++) {
                                    Producto producto = local.getListaproductos().get(i);
                                    System.out.println((i + 1) + ". nombre: " + producto.getNom());
                                    System.out.println("   precio: " + producto.getPrecio());
                                    System.out.println("   cantidad: " + producto.getCantidad());
                                    System.out.println("   marca: " + producto.getMarca());
                                    System.out.println("   mililitros: " + producto.getMililitros());
                                    System.out.println("------------------------------");
                                }
                            }
                            break;

                        case 2:
                            // Solicitar información sobre el nuevo producto al usuario
                            System.out.println("Nombre del nuevo producto: ");
                            String nom = scanner.next();
                            System.out.println("Precio del nuevo producto: ");
                            double precio = scanner.nextDouble();
                            System.out.println("Cantidad del nuevo producto: ");
                            int cantidad = scanner.nextInt();
                            System.out.println("Marca del nuevo producto: ");
                            String marca = scanner.next();
                            System.out.println("Mililitros del nuevo producto: ");
                            int mililitros = scanner.nextInt();

                            Producto nuevoProducto = new Producto(nom, precio, cantidad, marca, mililitros);

                            listaproductos.add(nuevoProducto);
                            local.getListaproductos().add(nuevoProducto);

                            local.saveProductos();

                            System.out.println("El nuevo producto se ha agregado al inventario.");
                            break;

                        case 3:
                            if (local.getListaproductos().isEmpty()) {
                                System.out.println("El inventario de productos está vacío. No hay productos para eliminar.");
                            } else {
                                // Mostrar los productos disponibles para que el usuario seleccione cuál eliminar
                                System.out.println("Productos Disponibles:");
                                for (int i = 0; i < local.getListaproductos().size(); i++) {
                                    System.out.println((i + 1) + ". " + local.getListaproductos().get(i).getNom());
                                }

                                // Solicitar al usuario que seleccione el número del producto a eliminar
                                System.out.print("Seleccione el número del producto a eliminar: ");
                                int numeroProductoAEliminar = scanner.nextInt();

                                // Verificar si el número seleccionado es válido
                                if (numeroProductoAEliminar >= 1 && numeroProductoAEliminar <= local.getListaproductos().size()) {
                                    // Eliminar el producto seleccionado del inventario
                                    local.getListaproductos().remove(numeroProductoAEliminar - 1);
                                    local.saveProductos();
                                    System.out.println("El producto ha sido eliminado del inventario.");
                                } else {
                                    System.out.println("Número de producto no válido. No se ha eliminado ningún producto.");
                                }
                            }
                            break;

                        case 4://ReHacer elimina el objeto luego lo crea de nuevo con los nuevos atributos
                            System.out.println("Cambiar producto en el inventario:");
                            if (local.getListaproductos().isEmpty()) {
                                System.out.println("El inventario de productos está vacío. No hay productos para cambiar.");
                            } else {
                                // Mostrar los productos disponibles para que el usuario seleccione cuál cambiar
                                System.out.println("Productos Disponibles:");
                                for (int i = 0; i < local.getListaproductos().size(); i++) {
                                    System.out.println((i + 1) + ". " + local.getListaproductos().get(i).getNom());
                                }

                                // Solicitar al usuario que seleccione el número del producto a cambiar
                                System.out.print("Seleccione el número del producto a cambiar: ");
                                int numeroProductoACambiar = scanner.nextInt();

                                // Verificar si el número seleccionado es válido
                                if (numeroProductoACambiar >= 1 && numeroProductoACambiar <= local.getListaproductos().size()) {
                                    // Obtener el producto actual
                                    Producto productoActual = local.getListaproductos().get(numeroProductoACambiar - 1);

                                    // Solicitar al usuario que ingrese los nuevos detalles del producto
                                    System.out.println("Nuevo nombre del producto: ");
                                    String nuevoNombre = scanner.next();
                                    System.out.println("Nuevo precio del producto: ");
                                    double nuevoPrecio = scanner.nextDouble();
                                    System.out.println("Nueva cantidad del producto: ");
                                    int nuevaCantidad = scanner.nextInt();
                                    System.out.println("Nueva marca del producto: ");
                                    String nuevaMarca = scanner.next();
                                    System.out.println("Nuevos mililitros del producto: ");
                                    int nuevosMililitros = scanner.nextInt();

                                    // Actualizar los detalles del producto
                                    productoActual.setNom(nuevoNombre);
                                    productoActual.setPrecio(nuevoPrecio);
                                    productoActual.setCantidad(nuevaCantidad);
                                    productoActual.setMarca(nuevaMarca);
                                    productoActual.setMililitros(nuevosMililitros);

                                    local.saveProductos();

                                    System.out.println("El producto ha sido cambiado en el inventario.");
                                } else {
                                    System.out.println("Número de producto no válido. No se ha cambiado ningún producto.");
                                }
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 4:
                    System.out.println("Realizar Pedido:");

                    ArrayList <Integer> productos_carrito = new ArrayList<>();
                    int respuesta = 0;
                    String id_productos_carrito = "";

                    while(respuesta == 0){
                        // Mostrar una lista de productos disponibles
                    System.out.println("Productos disponibles:");
                        for (int i = 0; i < local.getListaproductos().size(); i++) {
                            System.out.println(i + ". " + local.getListaproductos().get(i).getNom());
                        }

                        // Permitir al usuario seleccionar un producto
                        System.out.println("Seleccione un producto (ingrese el número): ");
                        int indiceProducto = scanner.nextInt();
                        if (indiceProducto < 0 || indiceProducto >= local.getListaproductos().size()) {
                            System.out.println("Número de producto no válido.");
                            break;
                        }

                        if(indiceProducto < 0){
                            respuesta = 1;
                        }else{
                            productos_carrito.add(indiceProducto);
                        }
                        

                    }
                    int iterator_id = 0;
                    for(int id_producto : productos_carrito){
                        if(iterator_id == 0){
                            id_productos_carrito = id_productos_carrito + id_producto;
                            iterator_id++;
                        }else{
                            id_productos_carrito = id_productos_carrito + "_" + id_producto;
                        }
                    }

                    // Mostrar una lista de clientes disponibles
                    System.out.println("Clientes disponibles:");
                    for (int i = 0; i < local.getListaClientes().size(); i++) {
                        System.out.println(i + ". " + local.getListaClientes().get(i).getNombre());
                    }

                    // Permitir al usuario seleccionar un cliente
                    System.out.println("Seleccione un cliente (ingrese el número): ");
                    int indiceCliente = scanner.nextInt();
                    if (indiceCliente < 0 || indiceCliente >= local.getListaClientes().size()) {
                        System.out.println("Número de cliente no válido.");
                        break;
                    }

                    // Mostrar una lista de domiciliarios disponibles
                    System.out.println("Domiciliarios disponibles:");
                    for (int i = 0; i < local.getListaDomiciliarios().size(); i++) {
                        System.out.println(i + ". " + local.getListaDomiciliarios().get(i).getNombre());
                    }

                    // Permitir al usuario seleccionar un domiciliario
                    System.out.println("Seleccione un Domiciliarios (ingrese el número): ");
                    int indiceDomiciliario = scanner.nextInt();
                    if (indiceDomiciliario < 0 || indiceDomiciliario >= local.getListaDomiciliarios().size()) {
                        System.out.println("Número de domiciliario no válido.");
                        break;
                    }

                    // Solicitar el valor del domicilio
                    System.out.print("Ingrese el valor del domicilio: ");
                    double costoDomicilio = scanner.nextDouble();

                    // Obtener el producto y cliente seleccionados
                    Pedido nuevo_pedido = new Pedido(local.getPedidos().size() + 1, indiceCliente, id_productos_carrito, indiceDomiciliario, costoDomicilio);
                    local.getPedidos().add(nuevo_pedido);
                    local.savePedidos();
                    break;
                
                case 5:
                    try {
                        File myObj = new File("base_datos.txt");
                        if (myObj.createNewFile()) {
                            System.out.println("File created: " + myObj.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                break;

                case 6:
                    try {
                        File myObj = new File("base_datos.txt");
                        Scanner myReader = new Scanner(myObj);
                        String data = "";
                        while (myReader.hasNextLine()) {
                            data = myReader.nextLine();

                            String[] arrOfStr = data.split("-", 5);
                    
                            for (String a : arrOfStr) {
                                System.out.println(a);
                            }
                            //String dataFragment = data;
                            //System.out.println(dataFragment);
                            //System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                break;

                case 7:
                    try {
                        File fout = new File("base_datos.txt");
                        FileOutputStream fos = new FileOutputStream(fout);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                        bw.write("Files in Java might be tricky, but it is fun enough!");
                        bw.newLine();
                        bw.write("Files in Java might be tricky, but it is fun enough!");
                        
                        bw.close();

                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                break;

                case 8:
                    try {
                        FileWriter myWriter = new FileWriter("base_datos.txt");
                        myWriter.write("Files in Java might be tricky, but it is fun enough! 12345");
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                break;

                case 9:
                    File myObj = new File("base_datos.txt");
                        if (myObj.exists()) {
                            System.out.println("File name: " + myObj.getName());
                            System.out.println("Absolute path: " + myObj.getAbsolutePath());
                            System.out.println("Writeable: " + myObj.canWrite());
                            System.out.println("Readable " + myObj.canRead());
                            System.out.println("File size in bytes " + myObj.length());
                        } else {
                            System.out.println("The file does not exist.");
                    }
                break;

                case 10:
                    File myObj1 = new File("base_datos.txt"); 
                    if (myObj1.delete()) { 
                        System.out.println("Deleted the file: " + myObj1.getName());
                    } else {
                        System.out.println("Failed to delete the file.");
                    } 
                break;

                case 0:
                    scanner.close();
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                break;
            }
        }
    }
}
