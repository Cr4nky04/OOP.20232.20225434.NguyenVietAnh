package AimsProject.src.hust.soict.dsai.aims.media;

import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDisc = 0;

    @Override
    public String toString() {
        String info = "DVD - "+this.getId()+" - "+this.getTitle()+" - "+this.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+": "+ String.valueOf(getCost());
        return info;
    }

    public DigitalVideoDisc()
    {
        super();
    }

    public DigitalVideoDisc(String title)
    {
        super();
        this.setTitle(title);
        nbDigitalVideoDisc+=1;
        setId(DigitalVideoDisc.nbDigitalVideoDisc);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc(int id, String title, String category, int length, String director) {
        super(id, title, category, length, director);
    }


    public boolean isMatch(String title)
    {
        return getTitle().equals(title);
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength()>0)
        {
            System.out.println("Playing DVD: "+this.getTitle());
            System.out.println("DVD length: "+this.getLength());
        }
        else
        {
            showExceptionDialog(new PlayerException("ERROR: DVD length is non-positive!"));
        }
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

        JOptionPane.showMessageDialog(null, scrollPane, "Illegal DVD Length", JOptionPane.ERROR_MESSAGE);
    }
}
