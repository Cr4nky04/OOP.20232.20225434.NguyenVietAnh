package Lab01.src.Ex6;
import java.util.Scanner;
public class Ex64 {

	public static void solve() {
		int dayCount = 0;
		String month;
		int year;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter month: ");
		month = scan.nextLine();
		System.out.println("Enter year (must contain full digits): ");
		year = scan.nextInt();
		
		if(month.equals("February") ||month.equals("Feb.")||month.equals("Feb")||month.equals("2"))
		{
			if (year % 4 == 0 && !(year % 100 ==0 && year % 400 != 0))
			{
				dayCount = 29;
			}
			else
			{
				dayCount = 28;
			}
		}
		else if((month.equals( "January")||month.equals( "Jan.")||month.equals( "Jan")||month.equals( "1"))||
				(month.equals("March")||month.equals("Mar.")||month.equals("Mar")||month.equals("3"))||
				(month.equals("May")||month.equals("5"))||
				(month.equals("July")||month.equals("Jul")||month.equals("7"))||
				(month.equals("August")||month.equals("Aug.")||month.equals("Aug")||month.equals("8"))||
				(month.equals("October")|month.equals("Oct.")||month.equals("Oct")||month.equals("10"))||
				(month.equals("December")||month.equals("Dec.")||month.equals("Dec")||month.equals("12")))
		{
			dayCount = 31;
		}
		else if((month.equals("April")||month.equals("Apr.")||month.equals("Apr")||month.equals("4"))||
				(month.equals("June")||month.equals("Jun")||month.equals("6"))||
				(month.equals("September")||month.equals("Sep.")||month.equals("Sep")||month.equals("9"))||
				(month.equals("November")||month.equals("Nov.")||month.equals("Nov")||month.equals("11")))
		{
			dayCount = 30;
		}
		System.out.println("This month has "+dayCount+" days");
		scan.close();
	}

}
