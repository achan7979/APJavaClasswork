package Lab3one;

public class Lab3ONE 
{
	public static void main(String[] args) 
	{
		//Initializes Testing Arrays
		int[] testArray = {2,3,4,4,3,1,7,7,7};
		int[] test1 = {6,2,4,7};
		int[] test2 = {10,8,7,56,7};
		int count = 0;
		
		int[] removedDups = removeDuplicates(testArray);
		int[][] productArray = productArray(test1, test2);
		
		//Prints out the a modified version of the test array without duplicates
		System.out.println("Removed Duplicates Array:");
		for(int i = 0; i< removedDups.length; i++)
		{
			System.out.print("[" + removedDups[i] + "]");
		}
		
		//Prints out the a 2D array that is a product of both the test1 and test2 arrays
		System.out.print("\n\nProduct Array:");
		for(int a = 0; a < test1.length; a++)
		{
			for(int b = 0; b < test2.length; b++)
			{
				if(count % test1.length == 0)
				{
					System.out.println();
				}
				System.out.print("[" + productArray[a][b] + "]");
				count++;
			}
		}
	}
	public static int[] removeDuplicates(int[] list)
	{
		int[] removedDups = new int[] {};
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
		int[][] product = new int[arr1.length][arr2.length];
		for(int i = 0; i < arr1.length; i++)
		{
			for(int j = 0; j < arr2.length; j++)
			{
				product[i][j] = arr1[i]*arr2[j];
			}
		}
		return product;
	}
	
	public static int[][] pascalTriangle(int n)
	{
		return null;
	}
	
	public static void printPascalTriangle(int[][] triangle)
	{
		
	}
}
