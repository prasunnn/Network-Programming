
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressGetters {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");

            System.out.println("===== GETTER METHODS =====");
            System.out.println("getHostName()          : "
                    + address.getHostName());

            System.out.println("getCanonicalHostName() : "
                    + address.getCanonicalHostName());

            System.out.println("getHostAddress()       : "
                    + address.getHostAddress());

            System.out.println("toString()             : "
                    + address.toString());

            System.out.print("getAddress() (bytes)   : ");
            byte[] bytes = address.getAddress();
            for (byte b : bytes) {
                // & 0xff converts the signed byte to 0-255
                System.out.print((b & 0xff) + " ");
            }
            System.out.println();

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("\n===== LOCAL HOST =====");
            System.out.println("Host Name    : " + localHost.getHostName());
            System.out.println("Host Address : " + localHost.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Host could not be found.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
