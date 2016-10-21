package Sorting;

public class Sort 
{
	
	/**
	 * Sorts a whole integer array in ascending order
	 * using the BubbleSort algorithm
	 * @param list - int[] array
	 */
	public static void bubbleSort(int[] list)
	{
		for (int i = list.length-1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				// Check if item i is larger than item i+1
				if (list[j] > list[j+1])
					// If so, switch them
					swap(list, j, j+1);
			}
		}
	}
	
	/**
	 * Sorts a segment of an integer array in ascending order
	 * using the BubbleSort algorithm
	 * @param list - int[] array
	 * @param leftIdx - value of left border
	 * @param rightIdx - value of right border
	 */
	public static void bubbleSort(int[] list, int leftIdx, int rightIdx)
	{
		if (leftIdx < 0 || rightIdx > list.length-1 || leftIdx > rightIdx)
			throw new IllegalArgumentException();
		
		for (int i = rightIdx; i > leftIdx; i--)
		{
			for (int j = leftIdx; j < i; j++)
			{
				// Check if item i is larger than item i+1
				if (list[j] > list[j+1])
					// If so, switch them
					swap(list, j, j+1);
			}
		}
	}
	
	/**
	 * Lets the biggest element of segment [leftIdx, ... i]
	 * bubble up to the place i
	 * @param list - int[] array
	 * @param leftIdx - left (inclusive) border
	 * @param i - bubble goal
	 */
	public static void bubbleUp(int[] list, int leftIdx, int i)
	{
		if (leftIdx < 0 || i > list.length-1 || leftIdx > i)
			throw new IllegalArgumentException();
		
		for (int j = leftIdx; j <= i-1; j++)
		{
			if (list[j] > list[j+1])
				swap(list, j, j+1);
		}
	}
	
	/**
	 * Lets the biggest element of segment [leftIdx, ... i]
	 * bubble up to the place i without changing in between
	 * Potentially quicker than bubbleUp() - through fewer checks.
	 * @param list - int[] array
	 * @param leftIdx - left (inclusive) border
	 * @param i - bubble goal
	 */
	public static void bubbleUpSpecial(int[] list, int leftIdx, int i)
	{
		if (leftIdx < 0 || i > list.length-1 || leftIdx > i)
			throw new IllegalArgumentException();
		
		int biggie = 0;
		int biggieSpot = 0;
		// Determine biggest element and its location
		for (int j = leftIdx; j <= i; j++)
		{
			if (biggie < list[j])
			{
				biggie = list[j];
				biggieSpot = j;
			}
		}
		
		// Swap elements starting at biggieSpot until
		// reaching i-th position
		for (int j = biggieSpot; j < i; j++)
			swap(list, j, j+1);
	}
	
	/**
	 * quicksort() an entire int[] array in ascending order.
	 * @param list - int[] array
	 */
	public static void quickSort(int[] list)
	{
		quickSort(list, 0, list.length-1);
	}
	
	/**
	 * Use the DAC-algorithm quickSort() to sort an int[] array
	 * in ascending order.
	 * @param list - int[] array
	 * @param leftIdx - starting position
	 * @param rightIdx - stopping position
	 */
	public static void quickSort(int[] list, int leftIdx, int rightIdx)
	{
		if (leftIdx < 0 || rightIdx > list.length-1)
			throw new IllegalArgumentException();
		int index = divide(list, leftIdx, rightIdx);
		if (leftIdx < index - 1)
			quickSort(list, leftIdx, index - 1);
		if (index + 1 < rightIdx)
			quickSort(list, index + 1, rightIdx);
	}
	
	/**
	 * divide() an array into two lists and sort them
	 * based on the last element of that array (pivot element)
	 * @param list - int[] array
	 * @param leftIdx - left index to start sorting
	 * @param rightIdx - right index to stop sorting
	 * @return - is the position of the gap element between these two lists
	 */

	public static int divide(int list[], int leftIdx, int rightIdx) 
	{
		   
		if (leftIdx < 0 || rightIdx > list.length-1)
			throw new IllegalArgumentException();
		      
		int pivot = list[rightIdx];               
		int left = leftIdx;
		int right = rightIdx - 1;
		      
		while(left <= right) 
		{
			if (list[left] >= pivot) 
			{
				//swap list[left] and list[right]
				swap(list, left, right);
				right--;
		    }
			else
				left++;            
		}

		// swap list[left] and list[rightIdx]
		swap(list, left, rightIdx);
		return left;
	}
	
	
	/**
	 * Swap list elements i and j 
	 * @param list - int[] array
	 * @param i - first element to swap
	 * @param j - second element to swap
	 */
	public static void swap(int[] list, int i, int j)
	{
		if (i < 0 || j < 0 || i > list.length-1 || j > list.length-1)
			throw new IllegalArgumentException(); // TODO: better error messaging/handling
		
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	/**
	 * Convert list into String that shows segment and 
	 * additional information such as length and segment ratio.
	 * Works with [0] index 
	 * @param list - int[] variable
	 * @param start - start position
	 * @param end - end position
	 */
	public static String toString(int[] list, int start, int end)
	{
		// Check if start or end is wither out of bounds or start > end 
		if (start > end || start < 0 || end > list.length-1)
			throw new IllegalArgumentException(); // TODO: better error messaging/handling
		
		String output = "List from [" + start + " to " + end + "]: ";
		
		for (int i = start; i <= end; i++)
		{
			output += list[i];
			if (i != end)
				output += " | ";
		}
		output += "\nSegment size: " + (end-start+1) + " / " + list.length;
		return output;
	}
	
	/**
	 * Convert complete list into String. 
	 * @param list - int[] variable
	 * Works with [0] index
	 */
	public static String toString(int[] list)
	{
		String output = "List: ";
		
		for (int i = 0; i < list.length; i++)
		{
			output += list[i];
			if (i != list.length-1)
				output += " | ";
		}
		output += "\nString size: " + list.length;
		return output;
	}
}
