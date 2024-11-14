import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        try {
            //Obtener el registro de nombre RMI en un puerto especifico
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            System.out.println("Conectado al servidor");

            //Crear instancia de la implementacion de la interfaz
            Interfaz objetoRemoto = (Interfaz) registro.lookup("ClienteRemoto");
            System.out.println("Objeto remoto encontrado");

           
            //Llamar a los métodos remotos
            System.out.println(objetoRemoto.mensaje());
            
            Scanner scanner = new Scanner(System.in);

            double valor1, valor2;
            while (true) {
                System.out.println("Seleccione la operación a realizar:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Salir");
                int opcion = scanner.nextInt();

                if (opcion == 5) {
                    System.out.println("Saliendo...");
                    break;
                }

                System.out.print("Ingrese el primer valor: ");
                valor1 = scanner.nextDouble();

                System.out.print("Ingrese el segundo valor: ");
                valor2 = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la suma: " + objetoRemoto.suma(valor1, valor2));
                        break;
                    case 2:
                        System.out.println("Resultado de la resta: " + objetoRemoto.resta(valor1, valor2));
                        break;
                    case 3:
                        System.out.println("Resultado de la multiplicación: " + objetoRemoto.multiplicacion(valor1, valor2));
                        break;
                    case 4:
                        if (valor2 == 0) {
                            System.out.println("Error: División por cero no permitida.");
                        } else {
                            System.out.println("Resultado de la división: " + objetoRemoto.division(valor1, valor2));
                        }
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }

            scanner.close();


  

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
