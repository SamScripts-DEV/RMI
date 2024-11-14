import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Interfaz interfaz = (Interfaz) registry.lookup("ClienteRemoto");
            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Bienvenido al Servicio de Conversión de Temperatura ===");
            boolean continuar = true;

            while (continuar) {
                try {
                    System.out.println("\nSeleccione el tipo de conversión:");
                    System.out.println("1: Celsius a Fahrenheit");
                    System.out.println("2: Fahrenheit a Celsius");
                    System.out.println("3: Salir");

                    System.out.print("Opción: ");
                    int opcion = scanner.nextInt();

                    if (opcion == 3) {
                        System.out.println("Gracias por usar el servicio de conversión. ¡Adiós!");
                        continuar = false;
                        break;
                    }

                    if (opcion != 1 && opcion != 2) {
                        System.out.println("Opción no válida. Por favor, elija una opción del 1 al 3.");
                        continue;
                    }

                    System.out.print("Ingrese la temperatura que desea convertir (numero): ");
                    double temperatura = scanner.nextDouble();

                    double resultado;
                    if (opcion == 1) {
                        resultado = interfaz.celsiusToFahrenheit(temperatura);
                        System.out.printf("Temperatura en Fahrenheit: %.2f°F\n", resultado);
                    } else {
                        resultado = interfaz.fahrenheitToCelsius(temperatura);
                        System.out.printf("Temperatura en Celsius: %.2f°C\n", resultado);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un número.");
                    scanner.nextLine(); // Limpiar la entrada
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error en el cliente:");
            e.printStackTrace();
        }
    }
}
