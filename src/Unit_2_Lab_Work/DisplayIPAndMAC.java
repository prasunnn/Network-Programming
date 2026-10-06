
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DisplayIPAndMAC {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();

                byte[] mac = ni.getHardwareAddress();

                // Skip interfaces without a MAC address
                if (mac == null) {
                    continue;
                }

                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    macAddress.append(String.format("%02X%s",
                            mac[i], (i < mac.length - 1) ? "-" : ""));
                }

                System.out.println("\nInterface Name : " + ni.getName());
                System.out.println("MAC Address    : " + macAddress);

                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    System.out.println("IP Address     : "
                            + address.getHostAddress());
                }
            }

        } catch (SocketException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }
}
