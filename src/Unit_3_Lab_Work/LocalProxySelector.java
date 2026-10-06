
package Unit_3_Lab_Work;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LocalProxySelector extends ProxySelector {

    // URIs that could not be reached through the proxy
    private List<URI> failed = new ArrayList<URI>();

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> result = new ArrayList<Proxy>();

        // Use a direct connection if it failed before or is not http
        if (failed.contains(uri) || !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress proxyAddress =
                    new InetSocketAddress("proxy.example.com", 8000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
            result.add(proxy);
        }
        return result;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress address, IOException ex) {
        // Remember the failed URI
        failed.add(uri);
        System.out.println("Connection failed, remembering: " + uri);
    }

    public static void main(String[] args) {
        try {
            LocalProxySelector selector = new LocalProxySelector();
            ProxySelector.setDefault(selector);

            URI uri = new URI("http://www.example.com/index.html");

            System.out.println("===== BEFORE FAILURE =====");
            System.out.println("Proxy chosen: " + selector.select(uri));

            // Simulate a failed connection through the proxy
            System.out.println("\n===== SIMULATING FAILURE =====");
            selector.connectFailed(uri,
                    new InetSocketAddress("proxy.example.com", 8000),
                    new IOException("Proxy not reachable"));

            System.out.println("\n===== AFTER FAILURE =====");
            System.out.println("Proxy chosen: " + selector.select(uri));

            // A different URI still uses the proxy
            URI other = new URI("http://www.google.com");
            System.out.println("\nOther URI proxy: " + selector.select(other));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
