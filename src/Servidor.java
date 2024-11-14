import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args){
        try {
            Interfaz objetoRemoto = new ImplementacionInterfaz();
            
            
            //Crear y obtener el registro de nombre RMI en un puerto especifico
            Registry registro = LocateRegistry.createRegistry(1099);


            //Vincular el objeto remoto con un nombre
            registro.rebind("ClienteRemoto", objetoRemoto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
