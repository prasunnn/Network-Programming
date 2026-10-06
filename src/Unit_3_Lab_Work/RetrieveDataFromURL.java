
package Unit_3_Lab_Work;

import java.net.*;
import java.io.*;

public class RetrieveDataFromURL {
    public static void main(String[] args) {
        String url1 = "https://example.com";
        InputStream in = null;
        try {
            URL u = new URL(url1);
            // Open the URL for reading
            in = u.openStream();
            // buffer the input to increase performance
            in = new BufferedInputStream(in);
            // chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println(url1 + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}
