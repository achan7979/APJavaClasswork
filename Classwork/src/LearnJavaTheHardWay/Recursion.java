package LearnJavaTheHardWay;

public class Recursion 
{
	public static void main(String[] args)
	{
		int[] test1 = {1,2,3,4,5,6,7,8,9,10};
		int[] test2 = {0,4,5,6,12,15,17,23,29};
		
		System.out.println(binarySearch(test1,2,0,test1.length));  //1
		System.out.println(binarySearch(test2,5,0,test1.length)); //2
		System.out.println(binarySearch(test1,1,0,test1.length));  //0
		System.out.println(binarySearch(test2,30,0,test1.length)); //-1
	}
	
	public static int binarySearch(int[] nums, int query, int first, int last)
	{
		if(query > nums[nums.length-1] || query < nums[0])
		{
			return -1;
		}
		if(last > first) //if still have some array left to search
		{
			int index = (first+last-1)/2;
			int guess = nums[index];
			if(guess == query)
			{
				return index;
			}
			if(guess > query)
			{
				return binarySearch(nums,query,first,index);
			}
			return binarySearch(nums,query,index+1,last);
		}
		return -1;
	}
}
