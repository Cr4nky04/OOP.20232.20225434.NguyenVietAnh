package AimsProject.src.hust.soict.dsai.test.store;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1711,"The Lion King", "Animation",19.95f,87,"Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(1833,"Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        Store store = new Store();
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.removeMedia(dvd1);
        store.print();
    }
}
