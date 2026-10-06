//WAPURIClient

package network.programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WapUriClient {
    public static void main(String[] args) {
        try {
            // Define a WAP URL (Replace with an actual WAP site if available)
            String wapUrl = "http://wap.webtender.com";;  // Example WAP site

            // Create URL object
            URL url = new URL(wapUrl);

            // Open HTTP Connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           
            // Set request properties (Simulating a WAP device request)
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Nokia3650/1.0");
            connection.setRequestProperty("Accept", "text/vnd.wap.wml, application/vnd.wap.xhtml+xml");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the WAP content response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Failed to fetch WAP content.");
            }

            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}