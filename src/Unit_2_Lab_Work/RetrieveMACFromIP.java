
package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RetrieveMACFromIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter an IP address of this system: ");
            String ip = sc.nextLine().trim();

            InetAddress address = InetAddress.getByName(ip);

            NetworkInterface ni = NetworkInterface.getByInetAddress(address);

            if (ni == null) {
                System.out.println("This IP address does not belong to any "
                        + "interface of this system.");
                return;
            }

            System.out.println("\nInterface Name : " + ni.getName());

            byte[] mac = ni.getHardwareAddress();

            if (mac == null) {
                System.out.println("MAC Address    : Not available");
            } else {
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    macAddress.append(String.format("%02X%s",
                            mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                System.out.println("MAC Address    : " + macAddress);
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }
}
