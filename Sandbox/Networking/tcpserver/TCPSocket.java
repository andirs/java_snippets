package tcpserver;
import java.io.*;
import java.net.*;

public class TCPSocket implements AutoCloseable 
{
    private Socket socket;
    private BufferedReader inStream;
    private BufferedWriter outStream;
    
    public TCPSocket(String serverAddress, int serverPort) throws UnknownHostException, IOException
    {
        socket = new Socket(serverAddress, serverPort);
        initializeStreams();
    }
    
    public TCPSocket(Socket socket) throws IOException
    {
        this.socket = socket;
        initializeStreams();
    }
    
    public void sendLine(String s) throws IOException
    {
        outStream.write(s);
        outStream.newLine();
        outStream.flush();
    }
    
    public String receiveLine() throws IOException
    {
        return inStream.readLine();
    }
    
    public void initializeStreams() throws IOException
    {
        outStream = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        inStream = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }

    public void close() throws Exception 
    {
        
    }

}
