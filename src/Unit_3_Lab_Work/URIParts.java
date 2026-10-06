
package Unit_3_Lab_Work;

import java.net.URI;
import java.net.URISyntaxException;

public class URIParts {

    public static void main(String[] args) {

        try {
            URI uri = new URI("https://user:pass@www.example.com:8080/course/java.html?id=101#section1");

            System.out.println("========== PARTS OF URI ==========\n");

            System.out.println("Original URI         : " + uri);
            System.out.println("Scheme               : " + uri.getScheme());
            System.out.println("Scheme Specific Part : "
                    + uri.getSchemeSpecificPart());
            System.out.println("Authority            : " + uri.getAuthority());
            System.out.println("User Info            : " + uri.getUserInfo());
            System.out.println("Host                 : " + uri.getHost());
            System.out.println("Port                 : " + uri.getPort());
            System.out.println("Path                 : " + uri.getPath());
            System.out.println("Query                : " + uri.getQuery());
            System.out.println("Fragment             : " + uri.getFragment());
            System.out.println("Is Absolute          : " + uri.isAbsolute());
            System.out.println("Is Opaque            : " + uri.isOpaque());

        } catch (URISyntaxException e) {

            System.out.println("Invalid URI: " + e.getMessage());
        }
    }
}
