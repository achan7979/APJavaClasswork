package Lab3one;

public class Lab3ONE 
{
	public static void main(String[] args) 
	{
		int[] testArray = {2,3,4,4,3,1,7,7,7};
		removeDuplicates(testArray);
	}
	public static int[] removeDuplicates(int[] list)
	{
		//
		//boolean duplicate = false;
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
			if (amount > 1)
			{
				System.out.println("dup:" + list[x]);
				//dont add it
				dups++;
			}
			else
			{
				System.out.println("ADD ME: " + list[x]);
			}
			
		}
		System.out.println(dups);
		return null;
	}
	private static int[] appendArray(int[] test, int add)
	{
		int[] temp = new int[test.length+1];
		for(int i = 0; i<test.length; i++)
		{
			temp[i] = test[i];
		}
		temp[test.length+1] = add;
		return temp;
	}
	public static int[][] productArray(int[] arr1, int[] arr2)
	{
		return null;
	}
	public static int[][] pascalTriangle(int n)
	{
		return null;
	}
	public static void printPascalTriangle(int[][] triangle)
	{
		
	}
}
