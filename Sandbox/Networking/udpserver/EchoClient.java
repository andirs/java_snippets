package udpserver;

import java.net.*;

public class EchoClient 
{
    private static final int TIMEOUT = 2000;
    
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Usage: java EchoClient <Multicast-IP-Address>" 
                             + " <Message #1> ... <Message #n>");
            return;
        }
        
        try(UDPSocket udpSocket = new UDPSocket())
        {
            udpSocket.setTimeout(TIMEOUT);
            InetAddress serverAddress = InetAddress.getByName(args[0]);
            
            for (int i = 1; i < args.length; i++)
            {
                udpSocket.send(args[i], serverAddress, 1250);
                
                try
                {
                    while (true)
                    {
                        String reply = udpSocket.receive(200);
                        System.out.println("Message received: "
                                          + udpSocket.getSenderAddress()
                                          + ":"
                                          + udpSocket.getSenderPort()
                                          + ":"
                                          + reply);
                    }
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
        
        System.out.println("Closed DatagramSocket...");
    }

}
