import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionInterfaz extends UnicastRemoteObject implements Interfaz {

    //COnstructor
    public ImplementacionInterfaz() throws RemoteException {
        super();
    }
    //Implementar los métodos indicados en la interfaz

    public String mensaje() throws RemoteException {
        return "Hola, soy un mensaje del servidor";
    }




    public double suma(double a, double b) throws RemoteException {
        return a + b;
    }


    public double resta(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplicacion(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

  

    
}
