package Lab01.src.Ex6;
import javax.swing.JOptionPane;
public class Ex61 {
	public static void solve()
	{
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket");
		JOptionPane.showMessageDialog(null, "You've chosen: "+(option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
