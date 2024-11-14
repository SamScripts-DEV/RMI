import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote{

    //Metodos a los que el cliente puede acceder

    String mensaje() throws RemoteException;


    double suma(double a, double b) throws RemoteException;
    double resta(double a, double b) throws RemoteException;
    double multiplicacion(double a, double b) throws RemoteException;
    double division(double a, double b) throws RemoteException;


}
