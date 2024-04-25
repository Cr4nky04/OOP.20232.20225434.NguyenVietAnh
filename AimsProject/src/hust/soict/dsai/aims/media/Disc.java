package AimsProject.src.hust.soict.dsai.aims.media;

public class Disc extends Media implements Playable {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc() {
    }

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(int id, String title, String category, int length, String director) {
        super(id, title, category);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    @Override
    public void play() {

    }
}
