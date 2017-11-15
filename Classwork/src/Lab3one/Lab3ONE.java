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
		
		//Prints out Pascal's Triangle to a specific row amount
		System.out.print("\n\nPascal's Triangle:\n");
		int[][] testTriangle = pascalTriangle(5);
		printPascalTriangle(testTriangle);
	}
	/**
	 * Takes in an int[] and using the appendArray method adds the
	 * elements that do not repeat to a new array and returns it 
	 * 
	 * @param list	an int[] that contains the test case 
	 * @return array	that includes all non duplicate elements
	 */
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
		return removedDups;
	}
	
	/**
	 * A helper method that takes in an array and an integer and appends the integer
	 * to the array.
	 * 
	 * @param test	an int[] that is empty at first but can later contain elements and is used to add upon
	 * @param add	an int that is the number to be added to the new array
	 * @return an array with the appended elements
	 */
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
	/**
	 * This method takes in two int[] arrays and multiplies each element and 
	 * places the result in their respective locations in the 2d array
	 * 
	 * @param arr1	an int[] used to multiply with 
	 * @param arr2	an int[] used to multiply with
	 * @return a 2d array with each element of the row and column multiplied out
	 */
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
	
	/**
	 * This method takes in an int and uses it as the number of rows the triangle is supposed to have.
	 * It creates a new 2d array with a defined length, but each array in the main array doesn't have
	 * a defined length. In the for loop, as we reach a higher row count, the length of the sub-arrays 
	 * increase depending on the row count plus one. 
	 * 
	 * @param n	an int that represents the number of rows the triangle is supposed to have
	 * @return a 2d array that represents pascal's triangle
	 */
	public static int[][] pascalTriangle(int n)
	{
		int[][] pascalTriangle = new int[n][];
		for(int row = 0; row < n; row++)
		{
			int[] theRow = new int[row+1];
			pascalTriangle[row] = theRow;
			for(int column = 0; column < row + 1; column++)
			{
				if(column == 0)
				{
					pascalTriangle[row][column] = 1;
				}
				else if(column == row)
				{
					pascalTriangle[row][column] = 1;
				}
				else
				{
					pascalTriangle[row][column] = pascalTriangle[row-1][column-1] + 
							pascalTriangle[row-1][column];
				}
			}
		}
		return pascalTriangle;
	}
	
	/**
	 * Prints out the pascal triangle that was created in the above method. Uses a double for loop
	 * and prints out each row's elements with spacing depending on the row number the loop is currently at.
	 * 
	 * @param triangle	A 2d array that was created in the method above
	 */
	public static void printPascalTriangle(int[][] triangle)
	{
		for(int i = 0; i < triangle.length;i++)
		{
			int x = (triangle.length-1)-i;
			for(int j = 0; j < x; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < triangle[i].length;j++)
			{
				System.out.print(triangle[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
