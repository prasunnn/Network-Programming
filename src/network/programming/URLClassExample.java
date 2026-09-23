//URL Class Demo

package network.programming;
import java.net.*;

public class URLClassExample {
    public static void main(String args[]){
        try{
            //1. public URL(String url)
            //2. public URL(String protocol, String hostName, String file)
            //3. public URL(String protocol, String hostName,int port String file)
            //4. public URL(URL baseAddress, String relativeAddress)
            //URL u = new URL("http://www.pmc.tu.edu.np/doc/admission.pdf";
            //URL u = new URL("http","www.pmc.tu.edu.np","/doc/admission.pdf");
            //URL u = new URL("http","www.pmc.tu.edu.np",8000,"/doc/admission.pdf");
            URL u1 = new URL("http://www.pmc.tu.edu.np");
            URL u = new URL(u1,"/document/index.php");
            System.out.println("URL protocol : "+u.getProtocol());
            System.out.println("URL Host:"+u.getHost());
            System.out.println("URL File:"+u.getFile());
            System.out.println("URL Query: "+u.getQuery());
            System.out.println("URl Ref: "+u.getRef());
            System.out.println("Port No.: "+u.getPort());
        }catch(MalformedURLException mfex){
           
        }
         
    }
   
}