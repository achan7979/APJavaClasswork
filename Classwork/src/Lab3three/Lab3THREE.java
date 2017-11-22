package Lab3three;

public class Lab3THREE 
{
	public static void main(String[] args)
	{
		int[] test1 = {6,4,7,10,45,22,53,1,6,0};
		double[] test2 = {6.0,3.0,1.0,2.0,4.0,3.5,7.6,9.4,1.2};
		int[] test3 = {5,6,3,7,1,0,4,9,5};
		
		insertionSort(test1);
		selectionSort(test2);
		bubbleSort(test3);
		
		System.out.println("Insertion Sort:");
		for(int i = 0; i < test1.length; i++)
		{
			System.out.print("["+ test1[i] + "] ");
		}
		
		System.out.println("\n\nSelection Sort:");
		for(int i = 0; i < test2.length; i++)
		{
			System.out.print("["+ test2[i] + "] ");
		}
		
		System.out.println("\n\nBubble Sort:");
		for(int i = 0; i < test3.length; i++)
		{
			System.out.print("["+ test3[i] + "] ");
		}
	}
	
	/**
	 * Insertion sort method takes each element from the array and adds it to the 
	 * front of the array in ascending order. It also keeps track of where the 
	 * insertion occurs
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void insertionSort(int[] list1) 
	{
		int j = 0;
		for (int i = 0; i <= list1.length; i++)
		{
			for (int k = j-1; k >= 0; k--)
			{
				if (list1[k] > list1[j])
				{
					swap(list1,k,j);
					j--;
				}
			}
			j = i;
		}
	}
	
	/**
	 * Selection sort finds the smallest element in the array and moves it
	 * to the front of the array. Then it searches for the next smallest element
	 * in the array and puts it after the first element and repeats
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void selectionSort(double[] list1)
	{
		for(int i = 0; i < list1.length; i++)
		{
			for(int j = i+1; j < list1.length; j++)
			{
				if(list1[i] > list1[j])
				{
					swap(list1,i,j);
				}
			}
		}
	}
	
	/**
	 * Bubble sort compares the first pair of elements and swaps them if the element
	 * that comes first is greater than the second. It continues to compare the next pair 
	 * of elements and swaps if needed. This method keeps track of how many swaps occurred in
	 * each iteration until there are no swaps initiated, which then we know the array is sorted
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void bubbleSort(int[] list1)
	{
		int swaps = 0;
		while(swaps == 0)
		{
			for(int i = 0; i < list1.length-1; i++) 
			{
				if(list1[i] > list1[i+1])
				{
					swap(list1,i,i+1);
					swaps++;
				}
			}
			if(swaps == 0)
			{
				break;
			}
			swaps = 0;
		}
	}
	
	/**
	 * This helper method swaps elements of the double[] at i and j by setting double[i] to a temp
	 * so that the value isn't lost. It then sets double[i] to double[j] and setting double[j] 
	 * to the temp
	 * 
	 * @param a the int[] that is passed in where elements need to be swapped
	 * @param i	the first number that needs to be swapped with the second
	 * @param j the second number that needs to be swapped with the first
	 */
	private static void swap(double[] a, int i, int j)
	{
	    double temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	private static void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
