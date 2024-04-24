package AimsProject.src.hust.soict.dsai.aims.media;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDisc = 0;
    private int id = 0;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String info = "DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+": "+String.valueOf(getCost());
        return info;
    }

    public DigitalVideoDisc(String title)
    {
        this.setTitle(title);
        nbDigitalVideoDisc+=1;
        setId(DigitalVideoDisc.nbDigitalVideoDisc);
    }
    public DigitalVideoDisc(String title, String category, float cost)
    {
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDisc+=1;
        setId(DigitalVideoDisc.nbDigitalVideoDisc);

    }
    public DigitalVideoDisc(String title, String category, String director, float cost)
    {
        this.setDirector(director);
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDisc+=1;
        setId(DigitalVideoDisc.nbDigitalVideoDisc);

    }
    public DigitalVideoDisc(String title, String category, String director,int length, float cost)
    {
        this.setDirector(director);
        this.setCategory(category);
        this.setTitle(title);
        this.setLength(length);
        this.setCost(cost);
        nbDigitalVideoDisc+=1;
        setId(DigitalVideoDisc.nbDigitalVideoDisc);

    }
    public boolean isMatch(String title)
    {
        return getTitle().equals(title);
    }
    
}
