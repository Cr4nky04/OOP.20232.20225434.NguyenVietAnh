package AimsProject.src.hust.soict.dsai.aims.store;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store()
    {

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
}
