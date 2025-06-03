import java.util.Scanner;

public class InputUtils { //Clase para Validaciones, entrada de datos

    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero <= 0) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("El número debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
            }
        }
        return numero;
    }

    public static double leerDecimalPositivo(Scanner scanner, String mensaje) {
        double numero = -1;
        while (numero <= 0) {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("El número debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número decimal.");
            }
        }
        return numero;
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        }
        return texto;
    }

    public static int leerEnteroCeroYPositivo(Scanner scanner, String mensaje) {
    int numero = -1;
    while (numero < 0) {
        System.out.print(mensaje);
        try {
            numero = Integer.parseInt(scanner.nextLine());
            if (numero < 0) {
                System.out.println("El número no puede ser negativo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
        }
    }
    return numero;
}

}