import javax.swing.JOptionPane;

public class Test {
    public static void main(String[] args) {
        // Custom options
        Object[] options = {"I do", "I don't"};

        // Display the dialog
        int choice = JOptionPane.showOptionDialog(null, "Do you accept the terms?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Process the user's choice
        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("User selected 'I do'");
        } else {
            System.out.println("User selected 'I don't'");
        }
    }
}
