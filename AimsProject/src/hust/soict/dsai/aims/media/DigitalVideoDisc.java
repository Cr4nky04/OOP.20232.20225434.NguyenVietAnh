package AimsProject.src.hust.soict.dsai.aims.media;

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
    public void play() {
        System.out.println("Playing DVD: "+this.getTitle());
        System.out.println("DVD length: "+this.getLength());
    }
}
