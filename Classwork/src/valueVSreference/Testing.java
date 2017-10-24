package valueVSreference;

public class Testing 
{
	public static void main(String[] args) 
	{
		int y = 3;
		
		int z = doubled(y);
		
		System.out.println(y);
		System.out.println(z);
		
		String foo = "foo";
		
		String foofoo = doubled(foo);
		
		System.out.println(foo);
		System.out.println(foofoo);
		
		String[] arr1 = {"hi","hello","mi'lady"}; 
		
		String[] arr2 = doubled(arr1);
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		int[] arr3 = {1,2,3,4};
		int[] arr4 = doubled(arr3);
		
		System.out.println(arr3);
		System.out.println(arr4);
		
		printArr(arr1);
		printArr(arr2);
	}
	public static int doubled(int x)
	{
		x = x + x;
		return x;
	}
	public static String doubled(String str1)
	{
		str1 = str1 + str1;
		return str1;
	}
	public static String[] doubled(String[] theArr)
	{
		String[] doubledArr = new String[theArr.length];
		for (int i = 0; i < theArr.length; i++)
		{
			doubledArr[i] = doubled(theArr[i]);
		}
		return doubledArr;
	}
	public static int[] doubled(int[] theArr)
	{
		int[] doubledArr = new int[theArr.length];
		for (int i = 0; i < theArr.length; i++)
		{
			doubledArr[i] = doubled(theArr[i]);
		}
		return doubledArr;
	}
	public static void printArr (Object[] arr)
	{
		for (Object x : arr)
		{
			System.out.println(x);
		}
	}
}
