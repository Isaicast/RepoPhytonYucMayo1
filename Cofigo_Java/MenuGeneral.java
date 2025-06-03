import java.util.ArrayList;
import java.util.Scanner;

public class MenuGeneral {

    public static void ejecutarMenuGeneral(Scanner scanner) {
        ArrayList<Producto> productos = Data.productos;
        ArrayList<Cliente> clientes = Data.clientes;
        ArrayList<Venta> ventas = Data.ventas;

        int opcion;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Mostrar detalles de un producto");
            System.out.println("2. Actualizar stock de un producto");
            System.out.println("3. Registrar nuevo producto");
            System.out.println("4. Obtener precio de un producto");
            System.out.println("5. Desactivar un producto");
            System.out.println("6. Mostrar todos los productos registrados");
            System.out.println("7. Editar datos de un producto");
            System.out.println("8. Activar un producto");
            System.out.println("\n--- MENÚ DE GESTIÓN DE CLIENTES ---");
            System.out.println("9. Registrar un nuevo cliente");
            System.out.println("10. Mostrar detalles de cliente");
            System.out.println("11. Editar perfil de cliente");
            System.out.println("12. Dar de baja cuenta de cliente");
            System.out.println("\n--- MENÚ DE VENTAS ---");
            System.out.println("13. Realizar una venta");
            System.out.println("14. Ver historial de todas las ventas");
            System.out.println("0. Salir");
            opcion = InputUtils.leerEnteroCeroYPositivo(scanner, "Seleccione una opción: ");


            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto: ");
                    int idMostrar = scanner.nextInt();
                    Producto pMostrar = buscarProductoPorId(productos, idMostrar);
                    if (pMostrar != null) {
                        pMostrar.mostrarDetalles();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el ID del producto: ");
                    int idStock = scanner.nextInt();
                    Producto pStock = buscarProductoPorId(productos, idStock);
                    if (pStock != null) {
                        System.out.print("Ingrese cantidad para actualizar stock: ");
                        int cantidad = scanner.nextInt();
                        pStock.actualizarStock(cantidad);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3: //Registrar un Nuevo Producto                   
                    System.out.println("Ingrese los datos del nuevo producto:");    
                    int id = InputUtils.leerEnteroPositivo(scanner, "ID: ");
                    double precio = InputUtils.leerDecimalPositivo(scanner, "Precio: ");
                    String categoria = InputUtils.leerTextoNoVacio(scanner, "Categoría: ");
                    String marca = InputUtils.leerTextoNoVacio(scanner, "Marca: ");
                    int stock = InputUtils.leerEnteroPositivo(scanner, "Stock: ");
                    String nombre = InputUtils.leerTextoNoVacio(scanner, "Nombre: ");

                    Producto nuevoProducto = new Producto(id, precio, categoria, marca, stock, nombre);
                    productos.add(nuevoProducto);
                    nuevoProducto.registrarProducto();
                    break;



                case 4://Obtener precio de producto
                    System.out.print("Ingrese el ID del producto: ");
                    int idPrecio = scanner.nextInt();
                    Producto pPrecio = buscarProductoPorId(productos, idPrecio);
                    if (pPrecio != null) {
                        System.out.println("Precio del producto: $" + pPrecio.obtenerPrecio());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5: //Desactivar Producto
                    System.out.print("Ingrese el ID del producto: ");
                    int idDesactivar = scanner.nextInt();
                    Producto pDesactivar = buscarProductoPorId(productos, idDesactivar);
                    if (pDesactivar != null) {
                        pDesactivar.desactivarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6: //Mostrar todos los Productos registrados
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto p : productos) {
                            p.mostrarDetalles();
                        }
                    }
                    break;

                case 7: //Editar datos de un Producto                    
                    System.out.print("Ingrese el ID del producto que desea editar: ");
                    int idEditar = InputUtils.leerEnteroPositivo(scanner, "");
                    Producto pEditar = buscarProductoPorId(productos, idEditar);
    
                    if (pEditar != null) {
                        System.out.println("Ingrese los nuevos datos (presione ENTER para omitir el cambio):");

                        System.out.print("Nuevo nombre (" + pEditar.getNombre() + "): ");
                        String nuevoNombre = scanner.nextLine();
                        if (!nuevoNombre.trim().isEmpty()) {
                            pEditar.setNombre(nuevoNombre.trim());
                        }

                        System.out.print("Nueva categoría (" + pEditar.getCategoria() + "): ");
                        String nuevaCategoria = scanner.nextLine();
                        if (!nuevaCategoria.trim().isEmpty()) {
                            pEditar.setCategoria(nuevaCategoria.trim());
                        }

                        System.out.print("Nueva marca (" + pEditar.getMarca() + "): ");
                        String nuevaMarca = scanner.nextLine();
                        if (!nuevaMarca.trim().isEmpty()) {
                        pEditar.setMarca(nuevaMarca.trim());
                        }

                        System.out.print("Nuevo precio (" + pEditar.getPrecio() + "): ");
                        String nuevoPrecioStr = scanner.nextLine();
                        if (!nuevoPrecioStr.trim().isEmpty()) {
                            try {
                                double nuevoPrecio = Double.parseDouble(nuevoPrecioStr.trim());
                                if (nuevoPrecio > 0) {
                                    pEditar.setPrecio(nuevoPrecio);
                                } else {
                                    System.out.println("El precio debe ser mayor a 0. No se modificó.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida para precio. No se modificó.");
                            }
                        }

                        System.out.print("Nuevo stock (" + pEditar.getStock() + "): ");
                        String nuevoStockStr = scanner.nextLine();
                        if (!nuevoStockStr.trim().isEmpty()) {
                            try {
                                int nuevoStock = Integer.parseInt(nuevoStockStr.trim());
                                if (nuevoStock >= 0) {
                                    pEditar.setStock(nuevoStock);
                                } else {
                                    System.out.println("El stock no puede ser negativo. No se modificó.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida para stock. No se modificó.");
                            }
                        }

                        System.out.println("Producto actualizado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("Ingrese el ID del producto: ");
                    int idActivar = scanner.nextInt();
                    Producto pActivar = buscarProductoPorId(productos, idActivar);
                    if (pActivar != null) {
                        pActivar.activarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 9: // Registrar nuevo cliente
                    System.out.println("Ingrese los datos del nuevo cliente:");

                    int idCliente = InputUtils.leerEnteroPositivo(scanner, "ID: ");
                    String nombreC = InputUtils.leerTextoNoVacio(scanner, "Nombre: ");
                    String apellidoP = InputUtils.leerTextoNoVacio(scanner, "Apellido Paterno: ");
                    String apellidoM = InputUtils.leerTextoNoVacio(scanner, "Apellido Materno: ");
                    String email = InputUtils.leerTextoNoVacio(scanner, "Email: ");
                    String telefono = InputUtils.leerTextoNoVacio(scanner, "Teléfono: ");
                    String direccion = InputUtils.leerTextoNoVacio(scanner, "Dirección: ");
                    String usuario = InputUtils.leerTextoNoVacio(scanner, "Usuario: ");
                    String contrasena = InputUtils.leerTextoNoVacio(scanner, "Contraseña: ");

                    Cliente nuevoCliente = new Cliente(apellidoM, apellidoP, contrasena, direccion, email, idCliente, nombreC, telefono, usuario);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente registrado correctamente.");
                    break;

                case 10: // Mostrar detalles de cliente
                    System.out.print("Ingrese el ID del cliente: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cBuscar = buscarClientePorId(clientes, idBuscar);
                    if (cBuscar != null) {
                        cBuscar.mostrarDetalles();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 11: // Editar perfil de cliente
                    int idEditarCliente = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del cliente: ");
                    Cliente cEditar = buscarClientePorId(clientes, idEditarCliente);

                    if (cEditar != null) {
                        System.out.print("Nuevo teléfono (" + cEditar.getTelefono() + ") [Enter para mantener]: ");
                        String nuevoTel = scanner.nextLine();
                        if (nuevoTel.trim().isEmpty()) nuevoTel = cEditar.getTelefono();

                        System.out.print("Nueva dirección (" + cEditar.getDireccion() + ") [Enter para mantener]: ");
                        String nuevaDir = scanner.nextLine();
                        if (nuevaDir.trim().isEmpty()) nuevaDir = cEditar.getDireccion();

                        System.out.print("Nuevo usuario (" + cEditar.getUsuario() + ") [Enter para mantener]: ");
                        String nuevoUser = scanner.nextLine();
                        if (nuevoUser.trim().isEmpty()) nuevoUser = cEditar.getUsuario();

                        System.out.print("Nueva contraseña (" + cEditar.getContrasena() + ") [Enter para mantener]: ");
                        String nuevaPass = scanner.nextLine();
                        if (nuevaPass.trim().isEmpty()) nuevaPass = cEditar.getContrasena();

                        cEditar.actualizarPerfil(nuevoTel.trim(), nuevaDir.trim(), nuevoUser.trim(), nuevaPass.trim());
                        System.out.println("Perfil actualizado.");
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                break;
                
                case 12: // Dar de baja cliente
                    System.out.print("Ingrese el ID del cliente: ");
                    int idBaja = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cBaja = buscarClientePorId(clientes, idBaja);
                    if (cBaja != null) {
                        clientes.remove(cBaja);
                        System.out.println("Cuenta de cliente eliminada.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 13: // Realizar una venta
                    int idClienteVenta = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del cliente que realiza la compra: ");
                    Cliente clienteVenta = buscarClientePorId(clientes, idClienteVenta);

                    if (clienteVenta == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    int idVendedor = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del vendedor: ");

                    int idVenta = ventas.size() + 1; // Generar ID venta automáticamente
                    Venta nuevaVenta = new Venta(idVenta, clienteVenta, idVendedor);

                    boolean agregarMasProductos;
                    do {
                    int idProdVenta = InputUtils.leerEnteroPositivo(scanner, "Ingrese el ID del producto a agregar: ");
                    Producto productoVenta = buscarProductoPorId(productos, idProdVenta);

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
                    productoVenta.actualizarStock(-cantidadVenta); // Disminuir stock
                    System.out.println("Producto agregado a la venta.");

                    System.out.print("¿Desea agregar otro producto? (true/false): ");
                    agregarMasProductos = scanner.nextBoolean();
                    scanner.nextLine(); // limpiar buffer

                } while (agregarMasProductos);

                ventas.add(nuevaVenta);
                clienteVenta.agregarVenta(nuevaVenta); // Relaciona la venta con el cliente (agrega la venta al historial del cliente)

                System.out.println("\n--- Detalles de la venta ---");
                nuevaVenta.consultarHistorial();
                break;
                
                case 14: // Mostrar historial de ventas
                    if (ventas.isEmpty()) {
                        System.out.println("No hay ventas registradas.");
                    } else {
                        System.out.println("\n--- HISTORIAL DE VENTAS ---");
                        for (Venta venta : ventas) {
                            venta.consultarHistorial();
                            System.out.println(); // Espacio entre ventas
                        }
                    }
                    break;
    
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

        // Método para buscar un producto por su ID
    public static Producto buscarProductoPorId(ArrayList<Producto> lista, int id) {
        for (Producto p : lista) {
            if (p.getIdProducto() == id) {
                return p;
            }
        }
        return null;
    }

    public static Cliente buscarClientePorId(ArrayList<Cliente> lista, int id) {
        for (Cliente c : lista) {
            if (c.getIdCliente() == id) {
            return c;
            }
        }
        return null;
    }
    
}