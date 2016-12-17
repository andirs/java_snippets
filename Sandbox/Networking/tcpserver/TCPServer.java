package tcpserver;

import java.net.*;

/**
 * Simple TCP Server implementation that accepts the two commands:
 * "increase" and "reset" for an integer counter
 */

public class TCPServer 
{
    private static boolean isRunning = false;
    public static void shutDown()
    {
        isRunning = false;
    }
    
    public static void main(String[] args)
    {
        isRunning = true;
        // initialize server counter
        int counter = 0;
        
        try(ServerSocket serverSocket = new ServerSocket(1250))
        {
            while(isRunning)
            {
                System.out.println("Waiting for connection...");
                try (TCPSocket tcpSocket = new TCPSocket(serverSocket.accept()))
                {
                    while(isRunning)
                    {
                        String request = tcpSocket.receiveLine();
                        if (request != null)
                        {
                            if (request.equals("increase"))
                            {
                                counter++;
                                System.out.println("Counter has been set to: " + counter);
                            }
                            else if (request.equals("reset"))
                            {
                                counter = 0;
                                System.out.println("Counter has been resetted.");
                            }
                            else if (request.equals("shutdown"))
                            {
                                shutDown();
                                tcpSocket.sendLine("Server shutting down due to user command.");
                                tcpSocket.sendLine("Final count: " + counter);
                                System.out.println("Server has been shut down.");
                                break;
                            }
                            String result = String.valueOf(counter);
                            tcpSocket.sendLine("Counter #: " + result);
                        }
                        else
                        {
                            System.out.println("Connection closed...");
                            break;
                        }
                        
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Connection closed. Error: " + e);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}
