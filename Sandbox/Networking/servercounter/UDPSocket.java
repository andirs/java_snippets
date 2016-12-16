package servercounter;
import java.io.*;
import java.net.*;

/**
 * UDP Socket implementation that simplifies 
 * the sending and receiving of Strings via UDP/IP Protocol.
 */

public class UDPSocket implements AutoCloseable 
{
    protected DatagramSocket socket;
    private InetAddress address;
    private int port;
    
    public UDPSocket() throws SocketException
    {
        this(new DatagramSocket());
    }
    
    public UDPSocket(int port) throws SocketException
    {
        this(new DatagramSocket(port));
    }
    
    protected UDPSocket(DatagramSocket socket) throws SocketException
    {
        this.socket = socket;
    }
    
    public void send(String sendString, 
                     InetAddress receiverAddress, 
                     int receiverPort) throws IOException
    {
        byte[] outBuffer = sendString.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outBuffer, 
                                                      outBuffer.length, 
                                                      receiverAddress, 
                                                      receiverPort);
        socket.send(outPacket);
    }
    
    public String receive(int maxBytes) throws IOException
    {
        // Create string to fit message
        byte[] inBuffer = new byte[maxBytes];
        
        // Create Packet with address and port of agent
        DatagramPacket inPacket  = new DatagramPacket(inBuffer, inBuffer.length);
        socket.receive(inPacket);
        address = inPacket.getAddress();
        port = inPacket.getPort();
        
        return new String(inBuffer, 0, inPacket.getLength());
    }
    
    public void reply(String replyString) throws IOException
    {
        // Check if there is a reply address stored
        if (address == null)
        {
            throw new IOException("No reply address found.");
        }
        
        send(replyString, address, port);
    }
    
    public InetAddress getSenderAddress()
    {
        return address;
    }
    
    public int getSenderPort()
    {
        return port;
    }
    
    public void setTimeout(int timeout) throws SocketException
    {
        socket.setSoTimeout(timeout);
    }
    
    public void close()
    {
        socket.close();
    }
}
