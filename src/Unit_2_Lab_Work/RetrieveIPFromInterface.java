package Unit_2_Lab_Work;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class RetrieveIPFromInterface {

    // Converts MAC bytes to the format AA-BB-CC-DD-EE-FF
    private static String formatMAC(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s",
                    mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return sb.toString();
    }

    private static void printAddresses(NetworkInterface ni) {
        Enumeration<InetAddress> addresses = ni.getInetAddresses();
        while (addresses.hasMoreElements()) {
            System.out.println("IP Address : "
                    + addresses.nextElement().getHostAddress());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("1. Search by Interface Name");
            System.out.println("2. Search by MAC Address");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter interface name (e.g. eth0, wlan0, en0): ");
                String name = sc.nextLine();

                NetworkInterface ni = NetworkInterface.getByName(name);

                if (ni != null) {
                    System.out.println("\nInterface : " + ni.getName());
                    printAddresses(ni);
                } else {
                    System.out.println("Interface not found.");
                }

            } else if (choice == 2) {
                System.out.print("Enter MAC address (AA-BB-CC-DD-EE-FF): ");
                String inputMAC = sc.nextLine().trim().replace(":", "-");

                boolean found = false;
                Enumeration<NetworkInterface> interfaces =
                        NetworkInterface.getNetworkInterfaces();

                while (interfaces.hasMoreElements()) {
                    NetworkInterface ni = interfaces.nextElement();
                    byte[] mac = ni.getHardwareAddress();

                    if (mac != null && formatMAC(mac).equalsIgnoreCase(inputMAC)) {
                        System.out.println("\nInterface : " + ni.getName());
                        printAddresses(ni);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No interface found with that MAC address.");
                }

            } else {
                System.out.println("Invalid choice.");
            }

        } catch (SocketException e) {
            System.out.println("Network error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
