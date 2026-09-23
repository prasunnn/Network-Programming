package network.programming;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceDemo {

    public static void main(String[] args) {

        try {

            //getNetworkInterfaces()
            System.out.println("===== ALL NETWORK INTERFACES =====");

            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {

                //nextElement()
                NetworkInterface ni = interfaces.nextElement();

                // getName()
                System.out.println("\nInterface Name: "
                        + ni.getName());

                // getDisplayName()
                System.out.println("Display Name: "
                        + ni.getDisplayName());

//                getInetAddresses()
                System.out.println("IP Addresses:");

                Enumeration<InetAddress> addresses =
                        ni.getInetAddresses();

                while (addresses.hasMoreElements()) {

                    InetAddress address =
                            addresses.nextElement();

                    System.out.println("   "
                            + address.getHostAddress());
                }
            }

            //getByName()
            System.out.println("\n===== getByName() =====");

            // Change "lo0" to an interface name available
            // on your computer if necessary.
            NetworkInterface byName =
                    NetworkInterface.getByName("lo0");

            if (byName != null) {

                System.out.println("Interface found: "
                        + byName.getName());

                System.out.println("Display Name: "
                        + byName.getDisplayName());

            } else {

                System.out.println(
                    "Interface 'lo0' was not found.");
            }

//            getByInetAddress()
            System.out.println("\n===== getByInetAddress() =====");

            InetAddress localAddress =
                    InetAddress.getLocalHost();

            System.out.println("Local IP Address: "
                    + localAddress.getHostAddress());

            NetworkInterface byAddress =
                    NetworkInterface.getByInetAddress(
                            localAddress);

            if (byAddress != null) {

                System.out.println(
                    "Associated Interface: "
                    + byAddress.getName());

                System.out.println(
                    "Display Name: "
                    + byAddress.getDisplayName());

            } else {

                System.out.println(
                    "No network interface found.");
            }


        } catch (SocketException e) {

            System.out.println(
                "Network error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                "Error: " + e.getMessage());
        }
    }
}