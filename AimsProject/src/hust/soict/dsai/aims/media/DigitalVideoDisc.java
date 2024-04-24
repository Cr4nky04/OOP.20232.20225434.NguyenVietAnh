package AimsProject.src.hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDisc = 0;

    @Override
    public String toString() {
        String info = "DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+": "+String.valueOf(getCost());
        return info;
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
