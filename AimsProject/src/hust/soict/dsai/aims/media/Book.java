package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, List<String> authors) {
        super(id, title, category);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category) {
        super(id, title, category);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
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

    @Override
    public String toString() {
        return "Book - " + super.toString();
    }
}