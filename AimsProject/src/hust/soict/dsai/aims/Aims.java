package AimsProject.src.hust.soict.dsai.aims;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;
import AimsProject.src.hust.soict.dsai.aims.media.*;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
public class Aims {
    static Scanner scanner = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();
    public static void main(String[] args) throws PlayerException {
//        DigitalVideoDisc disk1 = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc disk2 = new DigitalVideoDisc("Jungle1");
//        DigitalVideoDisc disk3 = new DigitalVideoDisc("Jungle2");
//        System.out.println(disk1.getId());
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc(1511, "Tro ve", "Rock", 30f, 4, "Buc Tuong", "Viet Anh");
        DigitalVideoDisc dvd = new DigitalVideoDisc(1400, "Con mua thang 5", "Rock", 12.5f, 4, "Buc Tuong");
        Book book = new Book(100, "The Lion King", "Novel", 5f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
        showMenu();
    }

    public static void showMenu() throws PlayerException {
        System.out.println("AIMS: ");
        System.out.println("-----------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                storeMenu();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                cartMenu();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    private static void updateStore() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            case 0:
                showMenu();
                break;
        }
    }


    private static void removeMediaFromStore()
    {
        System.out.println("Enter id of the product you want to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Media product = store.searchByID(id);
        if(product!=null)
        {
            store.removeMedia(product);
        }
        else
        {
            System.out.println("This product may not be existed in Store");
        }
    }
    private static void addMediaToStore() throws PlayerException {
        System.out.println("Choose the type of media you want to add:");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                Book book = new Book();
                store.addMedia(book);
                break;
            case 2:
                DigitalVideoDisc dvd = new DigitalVideoDisc();
                store.addMedia(dvd);
                break;
            case 3:
                CompactDisc cd = new CompactDisc();
                store.addMedia(cd);
                break;
            case 0:
                updateStore();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void storeMenu() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                seeMedia();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMediaInStore();
                break;
            case 4:
                cartMenu();
                break;
        }
    }

    private static void playMediaInStore() throws PlayerException {
        System.out.println("Name of media you want to play");
        String mediaTitle = scanner.nextLine();
        Media product = store.checkExist(mediaTitle);
        if (product != null) {
            if (product instanceof Disc) {
                ((Disc) product).play();
            }
        }
    }
    private static void playMediaInCart() throws PlayerException {
        System.out.println("Name of media you want to play");
        String mediaTitle = scanner.nextLine();
        Media product = cart.checkExist(mediaTitle);
        if (product != null) {
            if (product instanceof Disc) {
                ((Disc) product).play();
            }
        }
    }

    private static void addMediaToCart() {
        System.out.println("Name of media you want to add");
        String mediaTitle = scanner.nextLine();
        Media product = store.checkExist(mediaTitle);
        if (product != null) {
            store.addMedia(product);
        }
    }

    private static void seeMedia() throws PlayerException {
        System.out.println("Name of media you want to see");
        String mediaTitle = scanner.nextLine();
        Media product = store.checkExist(mediaTitle);
        System.out.println(product.toString());
        mediaDetailsMenu(product);

    }

    public static void mediaDetailsMenu(Media product) throws PlayerException {
        if (product instanceof Disc) {
            System.out.println("Options: ");
            System.out.println("-----------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("-----------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:
                    store.addMedia(product);
                    System.out.println("This product is added to your cart");
                    break;
                case 2:
                    ((Disc) product).play();
                    break;
                case 0:
                    storeMenu();
                    break;
                default:
                    System.out.println("Invalid case");

            }
        }

    }

    public static void cartMenu() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0:
                storeMenu();
                break;
            case 1:
                filterMedia();
                break;
            case 2:
                sortMedia();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMediaInCart();
                break;
            case 5:
                placeOrder();
                break;
            default:
                System.out.println("Invalid case");
        }
    }

    private static void filterMedia() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Filter media in cart by ID");
        System.out.println("2. Filter media in cart by title");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0:
                cartMenu();
                break;
            case 1:
                System.out.println("Enter lower bound of ID: ");
                int lower_bound = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter upper bound of ID: ");
                int upper_bound = scanner.nextInt();
                scanner.nextLine();
                store.filterByID(lower_bound, upper_bound);
                break;
            case 2:
                System.out.println("Enter your title filter: ");
                String titleFilter = scanner.nextLine();
                store.filterByTitle(titleFilter);
                break;
            default:
                System.out.println("Invalid case");
        }
    }

    private static void sortMedia() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("-----------------------------------");
        System.out.println("1. Sort media in cart by title");
        System.out.println("2. Sort media in cart by cost");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0:
                cartMenu();
                break;
            case 1:
                store.sortByTitle();
                break;
            case 2:
                store.sortByCost();
                break;
            default:
                System.out.println("Invalid case");
        }
    }

    private static void removeMediaFromCart() {
        System.out.println("Enter the ID of the product you want remove: ");
        int remove_id = scanner.nextInt();
        scanner.nextLine();
        Media product = store.checkExist(remove_id);
        if (product != null) {
            cart.removeMedia(product);
        }
    }
    private static void placeOrder()
    {
        System.out.println("An order is created");
        cart.emptyCart();
    }

}
