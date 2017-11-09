package Lab3one;

public class Lab3ONE 
{
	public static void main(String[] args) 
	{
		int[] testArray = {2,3,4,4,3,1,7,7,7};
		int[] removedDups = removeDuplicates(testArray);
		for(int i = 0; i< removedDups.length; i++)
		{
			System.out.print("[" + removedDups[i] + "]");
		}
	}
	public static int[] removeDuplicates(int[] list)
	{
		int[] removedDups = new int[] {};
		int dups = 0;
		for(int x = 0; x < list.length; x++)
		{
			int amount = 0;
			for(int y = 0; y < list.length; y++)
			{
				if(list[x] == list[y])
				{
					amount++;
				}
				
			}
			if (amount == 1)
			{
				removedDups = appendArray(removedDups, list[x]);
			}
		}
		//System.out.println(dups);
		return removedDups;
	}
	private static int[] appendArray(int[] test, int add)
	{
		int[] temp = new int[test.length+1];
		for(int i = 0; i< test.length; i++)
		{
			temp[i] = test[i];
		}
		temp[temp.length-1] = add;
		return temp;
	}
	public static int[][] productArray(int[] arr1, int[] arr2)
	{
		
	}
	public static int[][] pascalTriangle(int n)
	{
		return null;
	}
	public static void printPascalTriangle(int[][] triangle)
	{
		
	}
}
