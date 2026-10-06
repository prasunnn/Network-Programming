
package network.programming;
import java.net.*;
import java.io.*;
import java.util.*;

public class MIMEHeadersViewer {
    public static void main(String [] args){
        try{
            URL u = new URL("https://www.w3schools.com/java/default.asp");
            URLConnection uc = u.openConnection();
            System.out.println("Content-Type: " + uc.getContentType());
            System.out.println("Content-Encoding: " + uc.getContentEncoding());
            System.out.println("Date: " + new Date(uc.getDate()));
            System.out.println("Last-Modified: " + new Date (uc.getLastModified()));            
            System.out.println("Expiration-Date: " + new Date (uc.getExpiration()));
            System.out.println("Content-Length: " + uc.getContentLength());
            
            System.out.println();            System.out.println();
            
            String contentType = uc.getHeaderField("Content-Type");
            System.out.println("Content-Type: " + contentType);
            String contentEncoding = uc.getHeaderField("Content-Encoding");
            System.out.println("Content-Encoding: " + contentEncoding);
            String date = uc.getHeaderField("Date");
            System.out.println("Date: " + date);
            String expires = uc.getHeaderField("Expires");
            System.out.println("Expiration: " + expires);
            String contentLength = uc.getHeaderField("Content-Length");
            System.out.println("Content-Length: " + contentLength);    
        }catch(MalformedURLException e){
            System.err.println("Not a URL I understand");
        }
        catch(IOException e){
            System.err.println(e);
            System.out.println();
        }
    } 
}
