package Lab01.src.Ex6;
import java.util.Scanner;
public class Ex62 {

	public static void solve() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What's your name?");
		String strName = keyboard.nextLine();
		System.out.println("How oldd are you?");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyboard.nextDouble();
		System.out.println("Mrs/Ms. "+ strName + ", "+iAge+" years old. "
		+"Your height is "+ dHeight+".");
	}

}
