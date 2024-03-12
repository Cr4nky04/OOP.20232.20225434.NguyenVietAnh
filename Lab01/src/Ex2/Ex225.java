package Lab01.src.Ex2;
import javax.swing.JOptionPane;
public class Ex225 {

	public static void solve() {
		double num1 = 0;
		double num2 = 0;
		String str1,str2;
		try
		{
			str1 = JOptionPane.showInputDialog(null, "Please enter first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
			str2 = JOptionPane.showInputDialog(null, "Please enter first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
			num1 = Double.parseDouble(str1);
			num2 = Double.parseDouble(str2);
			if(num2==0)
			{
				throw new ArithmeticException();
			}
		}
		catch (ArithmeticException e)
		{
			System.out.println("Invalid divisor!");
		}
		
		double sum,differ,product,quotient;
		sum = num1 + num2;
		differ = Math.abs(num1-num2);
		product = num1 * num2;
		quotient = num1/num2;
		System.out.println("Sum of the given 2 numbers is "+ sum);
		System.out.println("Difference of the given 2 numbers is "+ differ);
		System.out.println("Product of the given 2 numbers is "+ product);
		System.out.println("Quotient of the given 2 numbers is "+ quotient);

	}

}
