
package Unit_3_Lab_Work;
import java.net.*;

public class SplitURL {
    public static void main(String args[]) {
        try {
            URL u = new URL("https://user:pass@www.example.com:8080/course/java.html?id=101&lang=en#section1");

            System.out.println("Full URL     : " + u);
            System.out.println("Protocol     : " + u.getProtocol());
            System.out.println("Authority    : " + u.getAuthority());
            System.out.println("User Info    : " + u.getUserInfo());
            System.out.println("Host         : " + u.getHost());
            System.out.println("Port         : " + u.getPort());
            System.out.println("Default Port : " + u.getDefaultPort());
            System.out.println("Path         : " + u.getPath());
            System.out.println("File         : " + u.getFile());
            System.out.println("Query        : " + u.getQuery());
            System.out.println("Reference    : " + u.getRef());

        } catch (MalformedURLException mfex) {
            System.out.println("Invalid URL: " + mfex.getMessage());
        }
    }
}
