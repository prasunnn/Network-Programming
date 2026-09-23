//Check Spam Domain

package network.programming;
import java.net.*;
public class SpamCheck {

    // List of known spam sources
    private static final String[] SPAM_LIST = {
        "127.0.0.2",
        "192.168.1.100",
        "10.0.0.50",
        "172.66.147.243",
        "192.178.177.101"
    };

    public static boolean isSpam(InetAddress address) {

        String ipAddress = address.getHostAddress();

        for (String spamIP : SPAM_LIST) {
            if (ipAddress.equals(spamIP)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        try {
            String host = "google.com";

            InetAddress address =
                InetAddress.getByName(host);

            System.out.println("Host Name: "
                    + address.getHostName());

            System.out.println("IP Address: "
                    + address.getHostAddress());

            if (isSpam(address)) {
                System.out.println("Result: Spam source");
            } else {
                System.out.println("Result: Not a spam source");
            }

        } catch (UnknownHostException e) {
            System.out.println(
                "Unable to find host: " + e.getMessage()
            );
        }
    }
}