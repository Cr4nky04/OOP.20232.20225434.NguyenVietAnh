package Lab01.src.Ex6;
import java.util.Arrays;

public class Ex65 {
	public static void solve() {
		// TODO Auto-generated method stub
		int[] numericArray = {1789,2035,1899,1456,2013};
		sort(numericArray);
		calculate(numericArray);
	}
	public static void sort(int[] nums)
	{
		Arrays.sort(nums);
		System.out.println("Sorted array: "+ Arrays.toString(nums));
	}
	public static void calculate(int[] nums)
	{
		int sum = 0;
		double avr ;
        for (int num : nums) {
            sum += num;
        }
		avr = (double) sum /nums.length;
		System.out.println("Sum is: "+sum+"\nAverage is: "+avr);
	}
}
