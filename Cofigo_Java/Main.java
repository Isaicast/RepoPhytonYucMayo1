import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcionPrincipal;
        do {
            System.out.println("=== BIENVENIDO ===");
            System.out.println("1. Iniciar sesión como Administrador");
            System.out.println("2. Iniciar sesión como Cliente");
            System.out.println("3. Salir");
            opcionPrincipal = InputUtils.leerEnteroPositivo(scanner, "Seleccione una opción: ");


            switch (opcionPrincipal) {
                case 1:
                    MenuAdministrador.mostrarMenuAdmin(scanner);
                    break;
                case 2:
                    MenuCliente.mostrarMenuCliente(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcionPrincipal != 3);

        scanner.close();
    }

    
}