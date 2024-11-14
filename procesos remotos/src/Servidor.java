import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws Exception {
        try {
            Interfaz interfaz = new ImplementacionInterfaz();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ClienteRemoto", interfaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
