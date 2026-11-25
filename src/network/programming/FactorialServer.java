package network.programming;
import java.net.*;
import java.io.*;
public class FactorialServer {
    public static void main(String [] args) throws IOException{
        ServerSocket ss = new ServerSocket(45456);
        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());        
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        int num = Integer.parseInt(in.readUTF());
        int fact = 1;
        for(int i = num; i>0; i--){
            fact = fact * i;
        }
        out.writeUTF(String.valueOf(fact));
        out.flush();
    }
}
