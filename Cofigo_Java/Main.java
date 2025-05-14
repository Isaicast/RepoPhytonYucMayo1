import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Venta> listaVentas = new ArrayList<>();
    static Cliente clienteActivo = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir=false;

        while (!salir) {
            System.out.println("\n=== TIENDA DEPARTAMENTAL ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();

                    if (usuario.equals("admin") && contrasena.equals("admin123")) {
                        menuAdministrador(scanner);
                    } else {
                        Cliente clienteEncontrado = null;
                        for (Cliente c : listaClientes) {
                            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contrasena)) {
                                clienteEncontrado = c;
                                break;
                            }
                        }
                    
                        if (clienteEncontrado != null) {
                            clienteActivo = clienteEncontrado;
                            menuCliente(scanner);
                        } else {
                            System.out.println("Credenciales incorrectas o cliente no registrado.");
                        }
                    }

                case "2":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
        
    }
    
}
