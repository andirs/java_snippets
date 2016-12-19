package tcpserver;
import java.net.*;

public class ParallelDynamicServer 
{
    public static void main(String[] args)
    {   
        //boolean isRunning = true;
        
        try(ServerSocket serverSocket = new ServerSocket(1250))
        {
            while(true)
            {
                System.out.println("Waiting for connection...");
                try
                {
                    TCPSocket connection = new TCPSocket(serverSocket.accept());
                    new TCPSlave(connection);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
