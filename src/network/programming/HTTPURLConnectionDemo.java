
package network.programming;

import java.net.*;
import java.io.*;

public class HTTPURLConnectionDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://pmctest.edu.np");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Message: " + connection.getResponseMessage());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        connection.disconnect();
    }
}