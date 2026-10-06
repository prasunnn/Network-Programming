
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTypes {
    public static void main(String[] args) {
        String[] hosts = {
            "127.0.0.1",
            "0.0.0.0",
            "192.168.1.1",
            "169.254.10.5",
            "224.0.0.1",
            "8.8.8.8"
        };

        try {
            for (String host : hosts) {
                InetAddress address = InetAddress.getByName(host);

                System.out.println("\n===== " + address.getHostAddress() + " =====");

                System.out.println("Is Any Local Address : "
                        + address.isAnyLocalAddress());

                System.out.println("Is Loopback Address  : "
                        + address.isLoopbackAddress());

                System.out.println("Is Link Local        : "
                        + address.isLinkLocalAddress());

                System.out.println("Is Site Local        : "
                        + address.isSiteLocalAddress());

                System.out.println("Is Multicast         : "
                        + address.isMulticastAddress());

                System.out.println("Is MC Global         : "
                        + address.isMCGlobal());

                System.out.println("Is MC Node Local     : "
                        + address.isMCNodeLocal());

                System.out.println("Is MC Link Local     : "
                        + address.isMCLinkLocal());

                System.out.println("Is MC Site Local     : "
                        + address.isMCSiteLocal());

                System.out.println("Is MC Org Local      : "
                        + address.isMCOrgLocal());
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
