//SetAndGetCookieExample

package network.programming;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class SetAndGetCookieManager {
    public static void main(String[] args)
    {
        // CookieManager and CookieStore
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore
            = cookieManager.getCookieStore();
        // creating cookies and URI
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");
        URI uri
            = URI.create("https://www.example.org/");
        // Method 1 - add(URI uri, HttpCookie cookie)
        cookieStore.add(uri, cookieA);
        cookieStore.add(null, cookieB);
        System.out.println(
            "Cookies successfully added\n");
        // Method 2 - get(URI uri)
        List cookiesWithURI = cookieStore.get(uri);
        System.out.println(
            "Cookies associated with URI in CookieStore : "
            + cookiesWithURI + "\n");
        // Method 3 - getCookies()
        List cookieList = cookieStore.getCookies();
        System.out.println("Cookies in CookieStore : "
                           + cookieList + "\n");
        // Method 4 - getURIs()
        List uriList = cookieStore.getURIs();
        System.out.println("URIs in CookieStore" + uriList
                           + "\n");
        // Method 5 - remove(URI uri, HttpCookie cookie)
        System.out.println(
            "Removal of Cookie : "
            + cookieStore.remove(uri, cookieA));
        List remainingCookieList = cookieStore.getCookies();
        System.out.println(
            "Remaining Cookies : " + cookieList + "\n");
        // Method 6 - removeAll()
        System.out.println("Removal of all Cookies : "
                           + cookieStore.removeAll());
        List EmptyCookieList = cookieStore.getCookies();
        System.out.println(
            "Empty CookieStore : " + cookieList);
    }
}