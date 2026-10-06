package network.programming;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class CookieHandlerExample {
    public static void main(String args[]) throws Exception
    {

        String uri = "https://www.facebook.com";
        // Instantiate CookieManager;
        CookieManager cm = new CookieManager();
        // First set the default cookie manager.
        CookieHandler.setDefault(cm);
        URL url = new URL(uri);
        // All the following subsequent URLConnections
        // will use the same cookie manager.
        URLConnection connection = url.openConnection();
        connection.getContent();
        // Get cookies from underlying CookieStore
        CookieStore cookieStore = cm.getCookieStore();
        List<HttpCookie> cookieList
            = cookieStore.getCookies();
        for (HttpCookie cookie : cookieList) {
            // Get domain set for the cookie
            System.out.println("The domain is: "
                               + cookie.getDomain());
            System.out.println("The cookie is: "
                               + cookie);
        }
    }
}