import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    public static void mostrarMenuCliente(Scanner scanner) {
        System.out.println("=== LOGIN CLIENTE ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        Cliente cliente = buscarClientePorCredenciales(usuario, password);

        if (cliente != null) {
            int opcion;
            do {
                System.out.println("\n--- MENÚ CLIENTE ---");
                System.out.println("1. Ver mi cuenta");
                System.out.println("2. Editar perfil");
                System.out.println("3. Eliminar cuenta");
                System.out.println("4. Realizar compra");
                System.out.println("5. Ver mis compras");
                System.out.println("6. Ver productos disponibles");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = InputUtils.leerEnteroCeroYPositivo(scanner, "Seleccione una opción: ");

                switch (opcion) {
                    case 1:
                        cliente.mostrarDetalles();
                        break;

                    case 2:
                        
                        System.out.print("Nuevo teléfono (" + cliente.getTelefono() + ") [Enter para mantener]: ");
                        String tel = scanner.nextLine();
                        if (tel.trim().isEmpty()) tel = cliente.getTelefono();

                        System.out.print("Nueva dirección (" + cliente.getDireccion() + ") [Enter para mantener]: ");
                        String dir = scanner.nextLine();
                        if (dir.trim().isEmpty()) dir = cliente.getDireccion();

                        System.out.print("Nuevo usuario (" + cliente.getUsuario() + ") [Enter para mantener]: ");
                        String user = scanner.nextLine();
                        if (user.trim().isEmpty()) user = cliente.getUsuario();

                        System.out.print("Nueva contraseña (" + cliente.getContrasena() + ") : ");
                        String pass = scanner.nextLine();
                        if (pass.trim().isEmpty()) pass = cliente.getContrasena();

                        cliente.actualizarPerfil(tel, dir, user, pass);
                        System.out.println("Perfil actualizado.");
                        break;
    
                    
                    case 3:
                        Data.clientes.remove(cliente);
                        System.out.println("Cuenta eliminada correctamente.");
                        return; // Salir inmediatamente tras eliminar
                    case 4:
                        realizarCompra(scanner, cliente);
                        break;
                    case 5:
                        mostrarHistorialDeCompras(cliente);
                        break;
                    case 6:                        
                        if (Data.productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                        } else {
                            System.out.println("=== Productos Disponibles ===");
                        for (Producto p : Data.productos) {
                            p.mostrarDetalles();
                            }
                        }                       
                        break;        
                    case 0:
                        System.out.println("Saliendo del menú cliente...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 0);
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private static Cliente buscarClientePorCredenciales(String usuario, String pass) {
        for (Cliente c : Data.clientes) {
            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(pass)) {
                return c;
            }
        }
        return null;
    }

    //METODO REALIZAR COMPRA
    public static void realizarCompra(Scanner scanner, Cliente cliente) {
    System.out.println("--- Realizar una venta ---");

   
    // Pide el ID del vendedor (si es necesario)
    int idVendedor = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del vendedor: ");

    int idVenta = Data.ventas.size() + 1; // Generar ID venta automáticamente
    Venta nuevaVenta = new Venta(idVenta, cliente, idVendedor);

    boolean agregarMasProductos;
    do {
        int idProdVenta = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del producto a agregar: ");
        Producto productoVenta = buscarProductoPorId(Data.productos, idProdVenta);

        if (productoVenta == null) {
            System.out.println("Producto no encontrado.");
            break;
        }

        int cantidadVenta;
        do {
            cantidadVenta = InputUtils.leerEnteroPositivo(scanner, "Ingrese la cantidad: ");
            if (cantidadVenta > productoVenta.getStock()) {
                System.out.println("Cantidad insuficiente en stock (" + productoVenta.getStock() + "). Intente de nuevo.");
            }
        } while (cantidadVenta > productoVenta.getStock());

        nuevaVenta.agregarProducto(productoVenta, cantidadVenta);
        productoVenta.actualizarStock(-cantidadVenta);
        System.out.println("Producto agregado a la venta.");

        System.out.print("¿Desea agregar otro producto? (true/false): ");
        agregarMasProductos = scanner.nextBoolean();
        scanner.nextLine(); // limpiar buffer
    } while (agregarMasProductos);

    Data.ventas.add(nuevaVenta);
    cliente.agregarVenta(nuevaVenta);

    System.out.println("\n--- Detalles de la venta ---");
    nuevaVenta.consultarHistorial();
}
      
//METODO PARA BUSCAR PRODUCTO POR ID
public static Producto buscarProductoPorId(ArrayList<Producto> productos, int id) {
    for (Producto p : productos) {
        if (p.getIdProducto() == id) {
            return p;
        }
    }
    return null;
}

//METODO PARA CONSULTAR HISTORIAL
private static void mostrarHistorialDeCompras(Cliente cliente) {
    System.out.println("\n=== Historial de Compras ===");

    if (cliente.getHistorialVentas().isEmpty()) {
        System.out.println("No tienes compras registradas.");
        return;
    }

    for (Venta venta : cliente.getHistorialVentas()) {
        venta.consultarHistorial();
        System.out.println(); // Espacio entre ventas
    }
}
}