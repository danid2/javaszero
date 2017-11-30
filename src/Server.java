import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.FileHandler;

/**
 * Created by Brumi on 2017.11.30..
 */
public class Server {

    public static void main(String[] args) {
        try{

            ServerSocket serverSocket = new ServerSocket(11111);
            InetAddress addr = null;
            String hostname = "Unknown";

            PrintWriter out = null;

            int siker = 0;
            while (true) {

                try {
                    Socket clientSocket = serverSocket.accept();
                    SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
                     out = new PrintWriter(clientSocket.getOutputStream(), true);


                    addr = InetAddress.getLocalHost();
                    hostname = addr.getHostName();

                    out.write(addr.toString()+ "\n");
                    out.write(hostname.toString()+ "\n");
                    out.write(clientAddress.toString() + "\n");
                    out.write(siker + "\n");

                    out.flush();
                    out.close();

                /*
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                 */
                    siker++;

                }
                catch (UnknownHostException ex)
                {
                    System.out.println("Hostname can not be resolved");
                }finally{
                    out.close();
                }

            }



        }catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }





    }



}
