package udpserver;

public class Server 
{
    public static void main(String[] args)
    {
        int counter = 0;
        
        try (UDPSocket udpSocket = new UDPSocket(1250))
        {
            System.out.println("Server waits for client...");
            
            while (true)
            {
                String request = udpSocket.receive(20);
                
                if (request.equals("increment"))
                {
                    counter++;
                }
                else if (request.equals("reset"))
                {
                    counter = 0;
                    System.out.println("Counter was resetted by" 
                                      + udpSocket.getSenderAddress() 
                                      + ":" 
                                      + udpSocket.getSenderPort());
                }
                
                String answer = String.valueOf(counter);
                udpSocket.reply(answer);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("DatagramSocket was closed...");
    }

}
