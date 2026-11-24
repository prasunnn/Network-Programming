package network.programming;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class SocketDayTimeServer {
    public static void main(String [] args) throws IOException{
        ServerSocket ss = new ServerSocket(45456);
        Socket s = ss.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Date dt = new Date();
        out.writeUTF(dt.toString());
        out.flush();
        s.close();
        ss.close();
    }
}
