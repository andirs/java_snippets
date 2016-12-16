package udpserver;

public class EchoServer 
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage: java EchoServer <Multicast IP-Address>");
            return;
        }
        
        System.setProperty("java.net.preferIPv4Stack", "true");
        
        try(UDPMulticastSocket multiSocket = new UDPMulticastSocket(1250))
        {
            System.out.println("Instantiated MulticastSocket...");
            multiSocket.join(args[0]);
            System.out.println("Entered Multicast-Group: " + args[0]);
            
            while(true)
            {
                String request = multiSocket.receive(200);
                System.out.println("Message received: "
                                  + multiSocket.getSenderAddress()
                                  + ":"
                                  + multiSocket.getSenderPort()
                                  + ":"
                                  + request);
                multiSocket.reply(request);
                
                if (request.equals("exit"))
                {
                    break;
                }
                
            }
            multiSocket.leave(args[0]);
            System.out.println("Left Multicast Group " + args[0]);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("Closed MulticastSocket...");
    }

}
