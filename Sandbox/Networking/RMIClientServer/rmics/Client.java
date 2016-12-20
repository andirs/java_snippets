package rmics;

import java.rmi.Naming;

public class Client 
{
    
    public static void main(String[] args)
    {
        try
        {
            Service service = (Service) Naming.lookup("rmi://localhost/Service");
            System.out.println("Connected to server...");
            System.out.println(service.isOpen());
            Data test = service.get();
            test.append("one");
            test.append("two");
            System.out.println(service.get().getValues());
            System.out.println(service.isOpen());
            
            // Close Data
            service.close();
            
            // Get data
            Data test2 = service.get();
            test2.append("three");
            test2.append("four");
            
            // Print out data
            System.out.println(service.get().getValues());
            System.out.println(test2.getValues());
            service.close();
            service.close();
            System.out.println(service.isOpen());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
