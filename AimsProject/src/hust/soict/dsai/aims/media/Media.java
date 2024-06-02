package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Collections;


public abstract class Media  {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(String title)
    {
        this.title = title;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) throws NullPointerException
    {
        if(obj==null)
        {
            throw new NullPointerException();
        }
        else
        {
            if(!(obj instanceof Media))
            {
                return false;
            }
            Media obj1 = (Media) obj;
            return this.getTitle().equals(obj1.getTitle()) && this.getCost()==obj1.getCost();
        }
    }

    @Override
    public String toString() {
        return this.id + " - " + this.getTitle() +" - "+ this.getCategory()+" - "+ String.valueOf(this.getCost());
    }

}
