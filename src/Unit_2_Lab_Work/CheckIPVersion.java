
package Unit_2_Lab_Work;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckIPVersion {
    public static void main(String[] args) {
        String[] hosts = {
            "192.168.1.1",
            "127.0.0.1",
            "::1",
            "2001:db8::1",
            "www.google.com"
        };

        for (String host : hosts) {
            try {
                InetAddress address = InetAddress.getByName(host);

                System.out.println("\nInput        : " + host);
                System.out.println("IP Address   : " + address.getHostAddress());

                if (address instanceof Inet4Address) {
                    System.out.println("Type         : IPv4 address");
                } else if (address instanceof Inet6Address) {
                    System.out.println("Type         : IPv6 address");
                }

                System.out.println("Address Size : "
                        + address.getAddress().length + " bytes");

            } catch (UnknownHostException e) {
                System.out.println("\nInput        : " + host);
                System.out.println("Invalid or unknown host.");
            }
        }
    }
}
