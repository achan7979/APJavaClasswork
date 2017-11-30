package LearnJavaTheHardWay;

public class ForLoops 
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6};
	
		System.out.println(average(arr));
		addOne(arr);
		System.out.println(average(arr));
	}
	
	public static void addOne(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = numbers[i] + 1;
		}
	}
	
	public static double average(int[] numbers)
	{
		double total = 0.0;
		
		for(int x : numbers)
		{
			total += x;
		}
		
		return total/numbers.length;
	}
}


