//HTTPURLConnection with Post Request
package network.programming;
import java.net.*;
import java.io.*;
public class HttpPostExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/login");
        HttpURLConnection connection =
        (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty(
        "Content-Type",
        "application/x-www-form-urlencoded"
        );
        String data = "username=admin&password=123456";
        OutputStream output =
        connection.getOutputStream();
        output.write(data.getBytes());
        output.flush();
        output.close();
        System.out.println("Response Code: "
        + connection.getResponseCode());
        connection.disconnect();
    }
}