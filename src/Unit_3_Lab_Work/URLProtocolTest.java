
package Unit_3_Lab_Work;

import java.net.*;

public class URLProtocolTest {
    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }

    public static void main(String args[]) {
        // hypertext transfer protocol
        testProtocol("http://www.adc.org");
        // secure http
        testProtocol("https://www.amazon.com/exec/obidos/order2/");
        // file transfer protocol
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
        // local file
        testProtocol("file:///C:/temp/test.txt");
        // Java archive
        testProtocol("jar:file:/C:/lib/test.jar!/");
        // Simple Mail Transfer Protocol
        testProtocol("mailto:elharo@ibiblio.org");
        testProtocol("telnet://dibner.poly.edu/");
        // gopher
        testProtocol("gopher://gopher.anc.org.za/");
    }
}
