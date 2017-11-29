package Lab3four;

public class Heap 
{
	private int[] heap;
	private int max;

	public Heap(int[] heap)
	{
		this.heap = heap;
		this.max = heap.length;
		makeHeap();
	}
	
	/**
	 * By multiplying the current index by 2 and adding 2, it gets the right child
	 * of the current index
	 * 
	 * @param index
	 * @return the index of the right child
	 */
	private int getRight(int index)
	{
		return index * 2 + 2;
	}
	
	/**
	 * By multiplying the current index by 2 and adding 1, it gets the left child
	 * of the current index
	 * 
	 * @param index
	 * @return the index of the left child
	 */
	private int getLeft(int index)
	{
		return index * 2 + 1;
	}
	
	/**
	 * By subtracting 1 and dividing it by 2, it gets the parent of the current child
	 * 
	 * @param index
	 * @return the index of the parent
	 */
	private int getParent(int index)
	{
		return (index-1)/2;
	}
	
	/**
	 * 
	 */
	public void heapSort()
	{
		while (max > 0)
		{
			//main.printArray(heap);
			heapSomething(0);
			swap(heap, 0, max-1);
			max--;
		}
		
	}
	
	/**
	 * 
	 */
	private void makeHeap()
	{
		int last = max -1;
		int parent = getParent(last);
		
		for (int i = parent; i > 0; i--)
		{
			heapSomething(i);
		}
	}
	
	/**
	 * In order to make a proper heap, this method swaps values that are out of place.
	 * If the any child is greater than the parent, then it swaps the values. If a swap
	 * occurs, then it recursively continues to call itself until there are no swaps made.
	 * 
	 * @param index
	 */
	private void heapSomething(int index) 
	{
		int left = getLeft(index);
		int right = getRight(index);
		//System.out.println(left + " " + right + " " + index);
		int minVal = index;
		if (left < max && heap[left] > heap[minVal]) {
			minVal = left;
		}
		if (right < max && heap[right] > heap[minVal]) {
			minVal = right;
		}
		boolean swap = heap[minVal] != heap[index];
		if (swap)
		{
			swap(this.heap, minVal, index);
			heapSomething(minVal);
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
	private void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}

}