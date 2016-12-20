package rmics;
import java.rmi.*;

public class Server 
{
    public static void main(String[] args)
    {
        try
        {
            ServiceImpl service = new ServiceImpl();
            Naming.rebind("Service", service);
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
