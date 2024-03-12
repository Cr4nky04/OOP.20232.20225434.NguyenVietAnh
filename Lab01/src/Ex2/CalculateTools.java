package Ex2;
import javax.swing.JOptionPane;
public class CalculateTools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double num2,num1;
		String str1,str2;
		do
		{
			str1 = JOptionPane.showInputDialog(null, "Please enter first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
			str2 = JOptionPane.showInputDialog(null, "Please enter first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
			num1 = Double.parseDouble(str1);
			num2 = Double.parseDouble(str2);
			if(num2==0)
			{
				System.out.println("Your divisor is invalid value");
				System.out.println("Please try again!");
			}
		}
		while(num2==0);
		
		Double sum,differ,product,quotient;
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
