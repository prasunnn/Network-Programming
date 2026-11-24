package network.programming;
import java.net.*;
import java.io.*;
public class SocketDayTimeClient {
    public static void main(String [] args) throws IOException{
        Socket soc = new Socket("localhost",45456);
        DataInputStream in = new DataInputStream(soc.getInputStream());
        String date = in.readUTF();
        System.out.println("Date from Server: "+ date);
    }
}
