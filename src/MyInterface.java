import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {

    String reverse(String str) throws RemoteException;
    char minChar(String str) throws RemoteException;
    StringBuffer caseChanger(String str) throws RemoteException;
}
