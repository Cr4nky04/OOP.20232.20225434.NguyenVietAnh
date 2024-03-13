package Lab01.src.Ex2;
import java.util.Arrays;
import java.util.Scanner;

public class Ex226 {


	private static int chooseProblem(Scanner sc)
	{
		System.out.println("Choose the problem you want to solve:");
		System.out.println("1. First-degree equation");
		System.out.println("2. First degree system equation");
		System.out.println("3. Second-degree equation");
        return Integer.parseInt(sc.nextLine());
	}
	private static void solveProblem(int problem, Scanner sc)
	{
		switch (problem)
		{
			default:
				System.out.println("Invalid input");
			case 1:
				System.out.print("Enter a = ");
				double a = Double.parseDouble(sc.nextLine());
				System.out.print("Enter b = ");
				double b = Double.parseDouble(sc.nextLine());
				firstDegree(a,b);
				break;
			case 2:
				System.out.println("Enter first equation coefficients: ");
				String[] strFirst = sc.nextLine().split(" ");
				System.out.println("Enter second equation coefficients: ");
				String[] strSecond = sc.nextLine().split(" ");
				double[] douFirst = new double[strFirst.length];
				double[] douSecond = new double[strSecond.length];
				for(int i = 0; i<strFirst.length; i++)
				{
					douFirst[i] = Double.parseDouble(strFirst[i]);
				}
				for(int i = 0; i<strSecond.length; i++)
				{
					douSecond[i] = Double.parseDouble(strSecond[i]);
				}
				systemEq(douFirst[0], douFirst[1], douFirst[2],douSecond[0],douSecond[1],douSecond[2]);
				break;
			case 3:
				System.out.print("Enter x1 = ");
				double x1 = Double.parseDouble(sc.nextLine());
				System.out.print("Enter x2 = ");
				double x2 = Double.parseDouble(sc.nextLine());
				System.out.print("Enter x3 = ");
				double x3 = Double.parseDouble(sc.nextLine());
				secondDegree(x1,x2,x3);
				break;
		}
	}
	private static void firstDegree(double a, double b)
	{
		double x;
		if(a==0)
		{
			System.out.println("This equation is not first-degree equation");
		}
		else
		{
			x = -a / b;
			System.out.println("The solution is x = " + x);
		}
	}
	private static void systemEq(double a11, double a12,double b1, double a21, double a22, double b2)
	{
		double x1,x2;
		double D = a11*a22-a21*a12;
		double D1 = b1*a22-b2*a12;
		double D2 = a11*b2-a21*b1;
		if(D==0)
		{
			System.out.println("This system equation produce infinitely many solutions");
		}
		else
		{
			x1 = D1/D;
			x2 = D2/D;
			System.out.println("Solution: x1 = "+x1+", x2 = "+x2);
		}
	}
	private static void secondDegree(double a, double b, double c)
	{
		double delta = b*b - 4*a*c;
		if(delta<0)
		{
			System.out.println("This equation has no solution");
		}
		else if (delta==0)
		{
			double x = 1/2*-b/a;
			System.out.println("This equation has sole solution: x = "+x);
		}
		else
		{
			double x1,x2;
			x1 = (double) 1 /2*(-b+Math.sqrt(delta))/a;
			x2 = (double) 1 /2*(-b-Math.sqrt(delta))/a;
			System.out.println("This equation has 2 solutions: x1 = "+x1+", x2 = "+x2);
		}
		
	}
	public static void solve()
	{
		Scanner sc = new Scanner(System.in);
		int intProb = chooseProblem(sc);
		solveProblem(intProb,sc);
	}
}
