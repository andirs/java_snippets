/*
 * Main Class for testing and show-casing purposes.
 */
package pp.filelocking;

public class Main 
{
    public static void main(String[] args)
    {
        File test = new File(250);
        
        FileThread newFile = new FileThread("New File 1", 0, 100, true, test);
        FileThread newFile3 = new FileThread("New File 3", 0, 100, true, test);
        FileThread newFile2 = new FileThread("New File 2", 0, 100, false, test);
        
        newFile.run();
        newFile2.run();
        
        test.print();
        
        newFile3.run();
        
        test.print();
    }
}
