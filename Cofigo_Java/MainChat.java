import java.util.ArrayList;
import java.util.Scanner;

public class MainChat{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

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
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

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

                case 3:
                    System.out.println("Ingrese los datos del nuevo producto:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Categoría: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    Producto nuevoProducto = new Producto(id, precio, categoria, marca, stock, nombre);
                    productos.add(nuevoProducto);
                    nuevoProducto.registrarProducto();
                    break;

                case 4:
                    System.out.print("Ingrese el ID del producto: ");
                    int idPrecio = scanner.nextInt();
                    Producto pPrecio = buscarProductoPorId(productos, idPrecio);
                    if (pPrecio != null) {
                        System.out.println("Precio del producto: $" + pPrecio.obtenerPrecio());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID del producto: ");
                    int idDesactivar = scanner.nextInt();
                    Producto pDesactivar = buscarProductoPorId(productos, idDesactivar);
                    if (pDesactivar != null) {
                        pDesactivar.desactivarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto p : productos) {
                            p.mostrarDetalles();
                        }
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el ID del producto que desea editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    Producto pEditar = buscarProductoPorId(productos, idEditar);
                    if (pEditar != null) {
                        System.out.println("Ingrese los nuevos datos (dejar en blanco para no cambiar):");

                        System.out.print("Nuevo nombre (" + pEditar.getNombre() + "): ");
                        String nuevoNombre = scanner.nextLine();
                        if (!nuevoNombre.isEmpty()) {
                            pEditar.setNombre(nuevoNombre);
                        }

                        System.out.print("Nueva categoría (" + pEditar.getCategoria() + "): ");
                        String nuevaCategoria = scanner.nextLine();
                        if (!nuevaCategoria.isEmpty()) {
                            pEditar.setCategoria(nuevaCategoria);
                        }

                        System.out.print("Nueva marca (" + pEditar.getMarca() + "): ");
                        String nuevaMarca = scanner.nextLine();
                        if (!nuevaMarca.isEmpty()) {
                            pEditar.setMarca(nuevaMarca);
                        }

                        System.out.print("Nuevo precio (" + pEditar.getPrecio() + "): ");
                        String nuevoPrecioStr = scanner.nextLine();
                        if (!nuevoPrecioStr.isEmpty()) {
                            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                            pEditar.setPrecio(nuevoPrecio);
                        }

                        System.out.print("Nuevo stock (" + pEditar.getStock() + "): ");
                        String nuevoStockStr = scanner.nextLine();
                        if (!nuevoStockStr.isEmpty()) {
                            int nuevoStock = Integer.parseInt(nuevoStockStr);
                            pEditar.setStock(nuevoStock);
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

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
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
}
