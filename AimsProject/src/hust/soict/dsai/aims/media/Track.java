package AimsProject.src.hust.soict.dsai.aims.media;

import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() throws PlayerException {
        if(this.getLength()>0)
        {
            System.out.println("Playing track: "+this.getTitle());
            System.out.println("Track length: "+this.getLength());
        }
        else
        {
            showExceptionDialog(new PlayerException("ERROR: Track length is non-positive!"));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Track))
        {
            return false;
        }
        Track track2 = (Track) obj;
        return this.getTitle().equals(track2.getTitle()) && (this.getLength()==track2.getLength());
    }
    private void showExceptionDialog(PlayerException e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        String message = "Exception Message: " + e.getMessage() + "\n\n" +
                "Exception toString(): " + e.toString() + "\n\n" +
                "Exception StackTrace:\n" + exceptionText;

        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Illegal Track Length", JOptionPane.ERROR_MESSAGE);
    }
}
