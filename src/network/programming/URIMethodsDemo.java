
package network.programming;

import java.net.URI;
import java.net.URISyntaxException;

public class URIMethodsDemo {

    public static void main(String[] args) {

        try {
            // Create URI
            URI uri = new URI("https://user:pass@www.example.com:8080/course/java.html?id=101#section1");

            System.out.println("========== URI METHODS DEMO ==========\n");

            // Display original URI
            System.out.println("Original URI:");
            System.out.println(uri);

            // URI component methods
            System.out.println("\n----- URI Components -----");

            System.out.println("Scheme              : "
                    + uri.getScheme());

            System.out.println("Scheme Specific Part: "
                    + uri.getSchemeSpecificPart());

            System.out.println("Authority            : "
                    + uri.getAuthority());

            System.out.println("User Info            : "
                    + uri.getUserInfo());

            System.out.println("Host                 : "
                    + uri.getHost());

            System.out.println("Port                 : "
                    + uri.getPort());

            System.out.println("Path                 : "
                    + uri.getPath());

            System.out.println("Query                : "
                    + uri.getQuery());

            System.out.println("Fragment             : "
                    + uri.getFragment());

            // URI type methods
            System.out.println("\n----- URI Type Methods -----");

            System.out.println("Is Absolute          : "
                    + uri.isAbsolute());

            System.out.println("Is Opaque            : "
                    + uri.isOpaque());

            // String representation
            System.out.println("\n----- String Methods -----");

            System.out.println("toString()           : "
                    + uri.toString());

            System.out.println("toASCIIString()      : "
                    + uri.toASCIIString());

            // Normalize
            URI uri2 = new URI(
                    "https://www.example.com/course/"
                    + "java/../python/./index.html"
            );

            System.out.println("\n----- normalize() -----");

            System.out.println("Before Normalize     : "
                    + uri2);

            System.out.println("After Normalize      : "
                    + uri2.normalize());

            // Resolve
            URI baseURI = new URI(
                    "https://www.example.com/course/"
            );

            URI relativeURI = new URI("java.html");

            URI resolvedURI = baseURI.resolve(relativeURI);

            System.out.println("\n----- resolve() -----");

            System.out.println("Base URI             : "
                    + baseURI);

            System.out.println("Relative URI         : "
                    + relativeURI);

            System.out.println("Resolved URI         : "
                    + resolvedURI);

            // Relativize
            URI targetURI = new URI(
                    "https://www.example.com/course/java.html"
            );

            URI relativeResult = baseURI.relativize(targetURI);

            System.out.println("\n----- relativize() -----");

            System.out.println("Base URI             : "
                    + baseURI);

            System.out.println("Target URI           : "
                    + targetURI);

            System.out.println("Relative Result      : "
                    + relativeResult);

            // Equality
            URI uri3 = new URI(
                    "https://www.example.com/index.html"
            );

            URI uri4 = new URI(
                    "https://www.example.com/index.html"
            );

            System.out.println("\n----- equals() -----");

            System.out.println("URI 1                : "
                    + uri3);

            System.out.println("URI 2                : "
                    + uri4);

            System.out.println("Are Equal?           : "
                    + uri3.equals(uri4));

            // Comparison
            System.out.println("\n----- compareTo() -----");

            URI uri5 = new URI(
                    "https://www.example.com/a"
            );

            URI uri6 = new URI(
                    "https://www.example.com/b"
            );

            System.out.println("URI 1                : "
                    + uri5);

            System.out.println("URI 2                : "
                    + uri6);

            System.out.println("compareTo() Result   : "
                    + uri5.compareTo(uri6));

            // Hash code
            System.out.println("\n----- hashCode() -----");

            System.out.println("Hash Code            : "
                    + uri.hashCode());

            // URI.create()
            System.out.println("\n----- URI.create() -----");

            URI createdURI = URI.create(
                    "https://www.example.com/about"
            );

            System.out.println("Created URI          : "
                    + createdURI);

        } catch (URISyntaxException e) {

            System.out.println(
                    "Invalid URI: " + e.getMessage()
            );
        }
    }
}