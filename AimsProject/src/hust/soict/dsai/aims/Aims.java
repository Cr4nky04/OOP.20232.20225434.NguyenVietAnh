package AimsProject.src.hust.soict.dsai.aims;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
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
        for (Media m: mediae) {
            System.out.println(m.toString());
        }
    }
}
