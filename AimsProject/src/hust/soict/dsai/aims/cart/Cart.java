package AimsProject.src.hust.soict.dsai.aims.cart;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    private final int MAX_NUMBERS_ORDERED = 15;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public void addMedia(Media product) throws LimitExceededException
    {
        if(itemsOrdered.size()<MAX_NUMBERS_ORDERED)
        {
            this.itemsOrdered.add(product);

            System.out.println("The disc has been added");
        }
        else
        {
            throw new LimitExceededException("ERROR: The number of " + "media has reached its limit");
        }
    }


    public void addMedia(Media[] products) {
        for (Media product : products) {
            this.itemsOrdered.add(product);
        }
    }

    public void removeMedia(Media product) {
        this.itemsOrdered.remove(product);
    }

    public void removeMedia(Media[] products) {
        for (Media product : products) {
            this.itemsOrdered.remove(product);
        }
    }

    public Media checkExist(String productTitle) {
        for (Media product : itemsOrdered) {
            if (product.getTitle().equals(productTitle)) {
                return product;
            }
        }
        System.out.println("Your title does not match any of our products");
        return null;
    }

    public Media checkExist(int id) {
        for (Media product : itemsOrdered) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Your title does not match any of our products");
        return null;
    }


    public float totalCost() {
        float cost = 0;
        for (Media product : this.itemsOrdered) {
            cost += product.getCost();
        }
        return cost;
    }

    public int count() {
        return this.itemsOrdered.size();
    }

    public void searchbyID(int id) {
        for (Media product : this.itemsOrdered) {
            if (product.getId() == id) {
                System.out.println(product);
            }
        }

    }

    public void searchbyTitle(String title) {
        boolean search_result = false;
        for (Media product : itemsOrdered) {
            if (product.getTitle().equals(title)) {
                System.out.println(product);
            }
        }
        if (!search_result) {
            System.out.println("No dvd matches");
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("***********************CART***********************\n");
        out.append("Ordered Items:\n");
        int count = 0;
        for (Media product : itemsOrdered) {
            count++;
            out.append(count);
            out.append(product);
            out.append("\n");

        }
        return out.toString();
    }

    public void print() {
        StringBuilder out = new StringBuilder();
        out.append("***********************CART***********************\n");
        out.append("Ordered Items:\n");
        int count = 0;
        for (Media product : itemsOrdered) {
            if (product != null) {
                count++;
                out.append(count + ". ");
                out.append(product);
                out.append("\n");
            }
        }
        out.append("***************************************************");
        System.out.println(out);
    }
    public void emptyCart()
    {
        for(Media product : itemsOrdered)
        {
            this.removeMedia(product);
        }
    }
}