
package network.programming;

import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConnectionTest {
    public static void main(String args []) throws Exception{
        try{
            URL u = new URL("https://dummyjson.com/products");
            URLConnection uc = u.openConnection();
            System.out.println("Content-Type: " + uc.getContentType());            
            System.out.println("Content-Length: " + uc.getContentLength());
            System.out.println("Content-Encoding: " + uc.getContentEncoding());
            System.out.println("Date: " + uc.getDate());
            System.out.println("Last-Modified: " + uc.getLastModified());

        }catch(MalformedURLException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
