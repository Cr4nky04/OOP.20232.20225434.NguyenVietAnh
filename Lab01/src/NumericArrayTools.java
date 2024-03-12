import java.util.Arrays;

public class NumericArrayTools { 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numericArray = {1789,2035,1899,1456,2013};
		sort(numericArray);
		calculate(numericArray);
	}
	public static void sort(int[] nums)
	{
		nums.toString();
		Arrays.sort(nums);
		System.out.println("Sorted array: "+ Arrays.toString(nums));
	}
	public static void calculate(int[] nums)
	{
		int sum = 0;
		double avr = 0;
		for(int i = 0; i<nums.length; i++)
		{
			sum += nums[i];
		}
		avr = sum/nums.length;
		System.out.println("Sum is: "+sum+"\nAverage is: "+avr);
	}
}
