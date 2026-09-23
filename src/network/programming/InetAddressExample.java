//InetAddress Class Method's Demo

package network.programming;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args) {

        try {
            // Get local host
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println("===== LOCAL HOST INFORMATION =====");
            System.out.println("Host Name       : " + localHost.getHostName());
            System.out.println("Canonical Name  : " + localHost.getCanonicalHostName());
            System.out.println("Host Address    : " + localHost.getHostAddress());
            System.out.println("Host Name/Addr  : " + localHost.getHostName() +
                               " / " + localHost.getHostAddress());


            //Get InetAddress using hostname
            InetAddress google = InetAddress.getByName("www.google.com");

            System.out.println("\n===== GOOGLE HOST INFORMATION =====");
            System.out.println("Host Name       : " + google.getHostName());
            System.out.println("Canonical Name  : " + google.getCanonicalHostName());
            System.out.println("Host Address    : " + google.getHostAddress());


            //Get all IP addresses of a host
            InetAddress[] addresses =
                    InetAddress.getAllByName("www.google.com");

            System.out.println("\n===== ALL IP ADDRESSES =====");

            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }


            //Check whether the host is reachable
            System.out.println("\n===== REACHABILITY =====");
             
            boolean reachable = google.isReachable(10000);

            if (reachable) {
                System.out.println("Google is reachable.");
            } else {
                System.out.println("Google is not reachable.");
            }
            InetAddress localhost = InetAddress.getByName("localhost");
            reachable = localhost.isReachable(1000);

            if (reachable) {
                System.out.println("Localhost is reachable.");
            } else {
                System.out.println("Localhost is not reachable.");
            }
            //Check IP address type
            System.out.println("\n===== ADDRESS INFORMATION =====");

            System.out.println("Is Any Local Address : "
                    + localhost.isAnyLocalAddress());

            System.out.println("Is Loopback Address  : "
                    + localhost.isLoopbackAddress());

            System.out.println("Is Link Local        : "
                    + localhost.isLinkLocalAddress());

            System.out.println("Is Site Local        : "
                    + localhost.isSiteLocalAddress());

            System.out.println("Is Multicast         : "
                    + localhost.isMulticastAddress());

            System.out.println("Is MC Global         : "
                    + localhost.isMCGlobal());

            System.out.println("Is MC Node Local     : "
                    + localhost.isMCNodeLocal());

            System.out.println("Is MC Link Local     : "
                    + localhost.isMCLinkLocal());

            System.out.println("Is MC Site Local     : "
                    + localhost.isMCSiteLocal());

            System.out.println("Is MC Org Local      : "
                    + localhost.isMCOrgLocal());


            //Create InetAddress from raw IP bytes
            byte[] ip = {(byte) 127, 0, 0, 1};

            InetAddress loopback = InetAddress.getByAddress(ip);

            System.out.println("\n===== ADDRESS FROM BYTE ARRAY =====");
            System.out.println("Host Address : "
                    + loopback.getHostAddress());


            // Create InetAddress using hostname and IP bytes
            InetAddress customAddress =
                    InetAddress.getByAddress("localhost", ip);

            System.out.println("\n===== CUSTOM ADDRESS =====");
            System.out.println("Host Name    : "
                    + customAddress.getHostName());
            System.out.println("Host Address : "
                    + customAddress.getHostAddress());


            //Compare two InetAddress objects
            System.out.println("\n===== COMPARISON =====");

            InetAddress address1 =
                    InetAddress.getByName("localhost");

            InetAddress address2 =
                    InetAddress.getByName("127.0.0.1");

            System.out.println("Address 1 : " + address1);
            System.out.println("Address 2 : " + address2);

            System.out.println("Are Equal : "
                    + address1.equals(address2));

            System.out.println("Hash Code of Address 1 : "
                    + address1.hashCode());

            System.out.println("Hash Code of Address 2 : "
                    + address2.hashCode());

            //Convert InetAddress object to String
            System.out.println("\n===== STRING REPRESENTATION =====");
            System.out.println("Using toString(): " + google.toString());
        } catch (UnknownHostException e) {

            System.out.println("Host could not be found.");
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}