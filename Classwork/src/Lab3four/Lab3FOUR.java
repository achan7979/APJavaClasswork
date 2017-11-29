package Lab3four;
import java.util.Arrays;

public class Lab3FOUR 
{
	public static void main(String[] args) 
	{
		//Generates test array for quickSort method
		int[] test1 = {3,6,2,23,3,1,3,0,55,32,1,5,6,3};
		//Generates test array for heapSort method
		int[] test2 = {4,46,12,4,6,2,6,2,12,6,8,2,1,0};
		//Generates run time test array for quickSort method
		int[] runTimeTest = new int[100000];
		for(int x = 0; x < runTimeTest.length; x++)
		{
			runTimeTest[x] = (int) (Math.random()*50) + 1;
		}
		
		long startTime = System.nanoTime(); //record the startTime
		System.out.println("Quick Sort Runtime Test:");
		quickSort(runTimeTest,0,runTimeTest.length);
		long endTime = System.nanoTime(); //record stopTime
		long totalTime = endTime - startTime; //calculate totalTime
		System.out.println("Time Taken in nanoseconds: " + totalTime);
		
		startTime = System.nanoTime(); //record the startTime
		System.out.println("Heap Sort Runtime Test:");
		quickSort(runTimeTest,0,runTimeTest.length);
		endTime = System.nanoTime(); //record stopTime
		totalTime = endTime - startTime; //calculate totalTime
		System.out.println("Time Taken in nanoseconds: " + totalTime);
		
		
		System.out.println("\nQuick Sort Test:");
		quickSort(test1,0,test1.length);
		for(int i = 0; i < test1.length; i++)
		{
			System.out.print("[" + test1[i] + "] ");
		}
		
		System.out.println("\nHeap Sort Test:");
		Heap heap = new Heap(test2);
		heap.heapSort();
		for(int i = 0; i < test2.length; i++)
		{
			System.out.print("[" + test2[i] + "] ");
		}
	}
	
	/**
	 * This method uses recursion to sort the array that is passed in. The base case
	 * tests if the index is greater than or equal to the back index. If it is, then 
	 * the array has been sorted and the method stops recursing. If not, it partitions 
	 * the array passed in from index front and back and quick sorts both sides.
	 * 
	 * @param list1 The array to be sorted
	 * @param front	The front index of the range of numbers to be sorted
	 * @param back The last index of the range of numbers to be sorted
	 */
	public static void quickSort(int[] list1, int front, int back)
	{
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
	}
	
	/**
	 * This method takes Array at index front and sets it as the pivot. The
	 * pivot is used to test every element and see whether or not they are less or greater
	 * than the pivot. All elements that are less than the pivot and are within the index 
	 * range of front and back are swapped and moved to the left of the pivot and all 
	 * elements that are greater than the pivot are swapped and moved to the right of the pivot.
	 * It then returns the index of the pivot
	 * 
	 * @param list The array to be partition
	 * @param front The first number in the range of numbers to be partitioned
	 * @param back The last number index in the range of numbers to be partitioned
	 * @return the index of the pivot
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
	 * This helper method swaps elements of the integer array at i and j by 
	 * setting a[i] to a temporary so that the value isn't lost. It then sets 
	 * a[i] to a[j] and setting a[j] to the temporary variable
	 * 
	 * @param a the integer array that is passed in where elements need to be swapped
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
