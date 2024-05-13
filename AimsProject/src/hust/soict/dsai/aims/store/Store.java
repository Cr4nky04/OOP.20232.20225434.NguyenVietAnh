package AimsProject.src.hust.soict.dsai.aims.store;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

import static AimsProject.src.hust.soict.dsai.aims.media.Media.COMPARE_BY_COST_TITLE;
import static AimsProject.src.hust.soict.dsai.aims.media.Media.COMPARE_BY_TITLE_COST;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {

    }

    public void addMedia(Media product) {
        this.itemsInStore.add(product);

        System.out.println("The disc has been added");
    }

    public void addMedia(Media[] products) {
        for (Media product : products) {
            this.itemsInStore.add(product);
        }
    }

    public void removeMedia(Media product) {
        this.itemsInStore.remove(product);
    }

    public void removeMedia(Media[] products) {
        for (Media product : products) {
            this.itemsInStore.remove(product);
        }
    }


    public void print() {
        StringBuilder out = new StringBuilder();
        out.append("***********************CART***********************\n");
        out.append("Ordered Items:\n");
        int count = 0;
        for (Media product : this.itemsInStore) {
            count++;
            out.append(count + ". ");
            out.append(product);
            out.append("\n");

        }
        out.append("***************************************************");
        System.out.println(out);
    }

    public Media checkExist(String productTitle) {
        for (Media product : itemsInStore) {
            if (product.getTitle().equals(productTitle)) {
                return product;
            }

        }
        System.out.println("Your title does not match any of our products");
        return null;
    }
    public Media checkExist(int id) {
        for (Media product : itemsInStore) {
            if (product.getId() == id) {
                return product;
            }

        }
        System.out.println("Your title does not match any of our products");
        return null;
    }

    public void filterByID(int lowerbound, int upperbound) {
        ArrayList<Media> filterProducts = new ArrayList<>();
        for (Media product : this.itemsInStore) {
            if (product.getId() < upperbound & product.getId() > lowerbound) {
                filterProducts.add(product);
            }
        }
        this.printFilterList(filterProducts);
    }

    public void filterByTitle(String filterTitle) {
        ArrayList<Media> filterProducts = new ArrayList<>();
        for (Media product : this.itemsInStore) {
            if (product.getTitle().contains(filterTitle)) {
                filterProducts.add(product);
            }
        }
        this.printFilterList(filterProducts);
    }

    private void printFilterList(ArrayList<Media> filterList) {
        System.out.println("FILTER RESULT");
        System.out.println("-------------------------------");
        int count = 0;
        for (Media product : filterList) {
            System.out.println(product.toString());
        }
        System.out.println("-------------------------------");
    }
    public Media searchByID(int id)
    {
        for(Media product : itemsInStore)
        {
            if(product.getId() == id)
            {
                return product;
            }
        }
        return null;
    }
    public void sortByTitle()
    {
        Collections.sort(this.itemsInStore,COMPARE_BY_TITLE_COST);
    }
    public void sortByCost()
    {
        Collections.sort(this.itemsInStore,COMPARE_BY_COST_TITLE);
    }
    public ArrayList<Media> getItemsInStore()
    {
        return itemsInStore;
    }
}
