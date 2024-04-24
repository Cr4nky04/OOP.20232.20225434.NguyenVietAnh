package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }
    public void addAuthor(String authorName)
    {
        if(!this.authors.contains(authorName))
        {
            this.authors.add(authorName);
        }
        else
        {
            System.out.println("This author is already in the list of author");
        }
    }
    public void removeAuthor(String authorName)
    {
        if(this.authors.contains(authorName))
        {
            this.authors.remove(authorName);
        }
        else
        {
            System.out.println("This author has not been added to the list of author");
        }
    }

}