import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}



    @Override
    public String reverse(String str) throws RemoteException {
        String s = "";
        char c;
        for (int i = 0; i<str.length(); i++) {
            c = str.charAt(i);
            s =c + s;
        }

        return s;
    }

    @Override
    public char minChar(String str) throws RemoteException {
        char min = 'z';
        int n=str.length();
        for (int i=0; i<n-1; i++)
            if (str.charAt(i) < min)
                min = str.charAt(i);
        return  min;

    }

@Override
public StringBuffer caseChanger(String str1) throws RemoteException{


    StringBuffer newStr=new StringBuffer(str1);

    for(int i = 0; i < str1.length(); i++) {

        if(Character.isLowerCase(str1.charAt(i))) {
            newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));
        }
        else if(Character.isUpperCase(str1.charAt(i))) {
            newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));
        }
    }
    return  newStr;
}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
