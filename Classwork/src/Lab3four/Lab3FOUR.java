package Lab3four;
import java.util.Arrays;

public class Lab3FOUR 
{
	public static void main(String[] args) 
	{
		int[] testPartition = {5,7,2,6,3,8,2,6,2,4,5};
		partition(testPartition,0,testPartition.length/2);
		for(int i = 0; i < testPartition.length; i++)
		{
			System.out.print("[" + testPartition[i] + "] ");
		}
		
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		
	}
	
	/**
	 * This method takes Array at index front and sets it as the pivot. The
	 * pivot is used to test every element and see whether or not they are less or greater
	 * than the pivot. All elements that are less than the pivot and are within the index 
	 * range of front and back are swapped and moved to the left of the pivot and all 
	 * elements that are greater than the pivot are swapped and moved to the right of the pivot.
	 * 
	 * @param list The array to be partition
	 * @param front The first number in the range of numbers to be partitioned
	 * @param back The last number index in the range of numbers to be partitioned
	 * @return
	 */
	public static int partition(int[] list, int front, int back)
	{
		int pivot = list[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (list[j] <= pivot)
			{
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i, front);
		return i;
	}
	
	/**
	 * This helper method swaps elements of the int[] at i and j by setting int[i] to a temp
	 * so that the value isn't lost. It then sets int[i] to int[j] and setting int[j] 
	 * to the temp
	 * 
	 * @param a the int[] that is passed in where elements need to be swapped
	 * @param i	the first number that needs to be swapped with the second
	 * @param j the second number that needs to be swapped with the first
	 */
	private static void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
