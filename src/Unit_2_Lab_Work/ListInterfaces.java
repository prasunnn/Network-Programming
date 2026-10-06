
package Unit_2_Lab_Work;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            System.out.println("===== AVAILABLE NETWORK INTERFACES =====");

            int count = 0;
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                count++;

                System.out.println("\nInterface " + count);
                System.out.println("Name         : " + ni.getName());
                System.out.println("Display Name : " + ni.getDisplayName());
            }

            System.out.println("\nTotal interfaces found: " + count);

        } catch (SocketException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }
}
