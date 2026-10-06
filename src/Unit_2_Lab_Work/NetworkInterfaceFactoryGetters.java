
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceFactoryGetters {
    public static void main(String[] args) {
        try {
            // Loopback always exists, so this works on any system
            InetAddress loopback = InetAddress.getLoopbackAddress();

            //Factory method 1: getByInetAddress()
            System.out.println("===== getByInetAddress() =====");
            NetworkInterface ni = NetworkInterface.getByInetAddress(loopback);
            System.out.println("Interface found: " + ni.getName());

            //Factory method 2: getByName()
            System.out.println("\n===== getByName() =====");
            NetworkInterface byName = NetworkInterface.getByName(ni.getName());
            System.out.println("Interface found: " + byName.getName());

            //Factory method 3: getByIndex()
            System.out.println("\n===== getByIndex() =====");
            NetworkInterface byIndex = NetworkInterface.getByIndex(ni.getIndex());
            System.out.println("Interface found: " + byIndex.getName());

            //Factory method 4: getNetworkInterfaces()
            System.out.println("\n===== getNetworkInterfaces() =====");
            Enumeration<NetworkInterface> all =
                    NetworkInterface.getNetworkInterfaces();
            while (all.hasMoreElements()) {
                System.out.println("  " + all.nextElement().getName());
            }

            //Getter methods
            System.out.println("\n===== GETTER METHODS =====");
            System.out.println("getName()          : " + ni.getName());
            System.out.println("getDisplayName()   : " + ni.getDisplayName());
            System.out.println("getIndex()         : " + ni.getIndex());
            System.out.println("getMTU()           : " + ni.getMTU());
            System.out.println("isUp()             : " + ni.isUp());
            System.out.println("isLoopback()       : " + ni.isLoopback());
            System.out.println("isVirtual()        : " + ni.isVirtual());
            System.out.println("isPointToPoint()   : " + ni.isPointToPoint());
            System.out.println("supportsMulticast(): " + ni.supportsMulticast());
            System.out.println("getParent()        : " + ni.getParent());

            System.out.println("\ngetInetAddresses():");
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                System.out.println("   " + addresses.nextElement().getHostAddress());
            }

            System.out.println("\ngetInterfaceAddresses():");
            for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                System.out.println("   " + ia);
            }

        } catch (SocketException e) {
            System.out.println("Network error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
