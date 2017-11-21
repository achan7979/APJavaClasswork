package Lab3three;

public class Lab3THREE 
{
	public static void main(String[] args)
	{
		double[] test1 = {6.0,3.0,1.0,2.0,4.0,3.5,7.6,9.4,1.2};
		selectionSort(test1);
		for(int i = 0; i < test1.length; i++)
		{
			System.out.print("["+ test1[i] + "] ");
		}
	}
	
	public static void insertionSort(int[] list1)
	{
		
	}
	
	public static void selectionSort(double[] list1)
	{
		for(int i = 0; i < list1.length; i++)
		{
			for(int j = i+1; j < list1.length; j++)
			{
				if(list1[i] > list1[j])
				{
					swap(list1, i, j);
				}
			}
		}
	}
	
	public static void bubbleSort(String[] list1)
	{
		
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
