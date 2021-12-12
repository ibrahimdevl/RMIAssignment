import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");

            System.out.println("Enter a string");
            String str = new Scanner(System.in).nextLine();

           System.out.println(service.reverse(str));
            System.out.println(service.minChar(str));
            System.out.println(service.caseChanger(str));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
