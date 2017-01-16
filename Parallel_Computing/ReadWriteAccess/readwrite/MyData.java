package readwrite;

/**
 * Data implementation for simple input/output application.
 */
public class MyData extends Access 
{
    private int data = 0;
    
    public MyData(Object data)
    {
        this.data = (Integer) data;
    }
    
    public MyData()
    {
    }
    
    protected Object readReal()
    {
        return new Integer(data);
    }
    
    protected void writeReal(Object data)
    {
        this.data = (Integer) data;
    }
}
