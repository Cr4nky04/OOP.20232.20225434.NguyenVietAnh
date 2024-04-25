package AimsProject.src.hust.soict.dsai.aims;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
//        DigitalVideoDisc disk1 = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc disk2 = new DigitalVideoDisc("Jungle1");
//        DigitalVideoDisc disk3 = new DigitalVideoDisc("Jungle2");
//        System.out.println(disk1.getId());
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc(1511,"Tro ve","Rock",30f,4,"Buc Tuong","Viet Anh");
        DigitalVideoDisc dvd = new DigitalVideoDisc(1400,"Con mua thang 5","Rock", 12.5f,4,"Buc Tuong");
        Book book = new Book(100,"The Lion King","Novel", 5f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        for (Media m: mediae) {
            System.out.println(m.toString());
        }
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-----------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu()
    {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu()
    {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu()
    {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart"); System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
