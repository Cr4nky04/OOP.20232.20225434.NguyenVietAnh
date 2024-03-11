
public class Employee {
	private String employeeName = "Vanh";
	private double basicSalary = 1000;
	private double salaryCoeffcient = 1.5;
	private double Salary;
	final double SALARY_MAX = 3000;
	
	public String getName()
	{
		return employeeName;
	}
	public void setName(String new_name)
	{
		employeeName = new_name;
	}
	public double getbasicSalary()
	{
		return basicSalary;
	}
	public void setbasicSalary(double bas)
	{
		basicSalary = bas;
	}
	public void printInfo()
	{
		System.out.println("Name: "+employeeName);
		System.out.println("Basic salary: "+basicSalary);
		System.out.println("Salary Coefficient: "+salaryCoeffcient);
	}
	public boolean increaseSalary(double coef)
	{
		salaryCoeffcient *= coef;
		Salary = basicSalary*salaryCoeffcient;
		if(Salary>SALARY_MAX)
		{
			System.out.println("The new salary surpasses maximum salary");
			return false;
		}
		else
		{
			return true;
		}
	}

}
