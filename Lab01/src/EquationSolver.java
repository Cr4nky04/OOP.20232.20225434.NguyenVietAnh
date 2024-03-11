
public class EquationSolver {

	public void firstdegreeEquation(double a, double b)
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
	public void firstdegreesystemEquation(double a11, double a12,double b1, double a21, double a22, double b2)
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
	public void seconddegreeEquation(double a, double b, double c)
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
			x1 = 1/2*(-b+Math.sqrt(delta))/a;
			x2 = 1/2*(-b-Math.sqrt(delta))/a;
			System.out.println("This equation has 2 solutions: x1 = "+x1+", x2 = "+x2);
		}
		
	}
}
