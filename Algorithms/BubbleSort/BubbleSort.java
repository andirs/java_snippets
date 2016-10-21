/** 
* Simple Bubble Sort
* This code sorts an array of integers according to their value until
* all numbers are ordered decreasing by value. Integers can be passed
* through command-line.
* Limited to integers.
* 
* Not practical for huge data sets, since the algorithm 
* takes about Math.pow(n.2)/2 attempts to sort a data set.
*/

public class BubbleSort
{	
	public static String bubble(int[] bubbles, String method)
	{
	
	/** 
	* bubble() compares array positions regarding its values and
	* puts them in descending order
	* @param bubbles: array of integer values
	* @param method: desc = descending order asc = ascending order
	*/

		if(method.equals("asc")) 
		{
			for(int i = bubbles.length-1; i > 0; i--)
			{
				for(int j = 0; j < i; j++)
				{
					// Check if bubble j is bigger than bubble j+1
					if(bubbles[j] > bubbles[j+1])
					{
						// If so, switch positions of bubbles
						int temp = bubbles[j];
						bubbles[j] = bubbles[j+1];
						bubbles[j+1] = temp;
					}
				}
			}
			String mode = "ascending";
			return mode;
		}
		else if(method.equals("desc"))
		{
			for(int i = bubbles.length-1; i > 0; i--)
			{
				for(int j = 0; j < i; j++)
				{
					if(bubbles[j] < bubbles[j+1])
					{
						int temp = bubbles[j];
						bubbles[j] = bubbles[j+1];
						bubbles[j+1] = temp;
					}
				}
			}
			String mode = "descending";
			return mode;
		}
		else
		{
			System.out.println("Error: Sorting mode not specified.");
			return "NaN";
		}

	}

	public static void main( String[] args )
	{

		/* 'java bubbleSort 2 3 1 42 asc' returns:
		1 2 3 42
		*/

		// retrieve mode through command line
		String mode = args[args.length-1];
		System.out.println(mode);

		int[] x = new int[args.length-1];
		
		for (int i = 0; i < args.length-1; i++)
			x[i] = Integer.parseInt(args[i]);

		// Return values without sorting
		System.out.println("\n\n ------ Without Sorting ------");
		for(int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");

		// Sort x by value and set mode to 1 ( = descending)
		bubble(x, mode);
		// Read sorting mode
		String method = bubble(x, mode);

		// Return values in descending order
		System.out.println("\n \n ------ Bubble Sorted ------");
		System.out.println(" ------ Mode: " + method);
		for(int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");

		System.out.println();

	}

}