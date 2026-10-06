
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DisplayMyIP {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println("Host Name  : " + localHost.getHostName());
            System.out.println("IP Address : " + localHost.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Unable to find local host.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
