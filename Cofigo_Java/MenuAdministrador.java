import java.util.Scanner;

public class MenuAdministrador {
    public static void mostrarMenuAdmin(Scanner scanner) {
        System.out.println("=== LOGIN ADMINISTRADOR ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (usuario.equals("Admin") && password.equals("admin123")) {
            int opcionAdmin;
            do {
                System.out.println("\n--- MENÚ ADMINISTRADOR ---");
                System.out.println("1. Ir al menú general");
                System.out.println("2. Salir");
                opcionAdmin = InputUtils.leerEnteroPositivo(scanner, "Seleccione una opción: ");


                switch (opcionAdmin) {
                    case 1:
                        MenuGeneral.ejecutarMenuGeneral(scanner);
                        break;
                    case 2:
                        System.out.println("Saliendo del sistema administrador...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcionAdmin != 2);
        } else {
            System.out.println("Credenciales incorrectas. Acceso denegado.");
        }
    }
}