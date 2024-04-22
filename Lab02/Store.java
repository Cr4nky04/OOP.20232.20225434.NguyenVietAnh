package Lab02;

import java.util.ArrayList;

public class Store {
    final int MAX_QUANTITY = 20;
    int qty_ordered = 0;
    public Store()
    {

    }
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_QUANTITY];
    public void addDVD(DigitalVideoDisc dvd)
    {
        itemsInStore[qty_ordered] = dvd;
        qty_ordered+=1;
    }
    public void removeDVD(DigitalVideoDisc dvd)
    {
        int index = -1;
        for (int i = 0; i < qty_ordered; i++) {
            if (itemsInStore[i].equals(dvd)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            DigitalVideoDisc[] newArray = new DigitalVideoDisc[MAX_QUANTITY];
            System.arraycopy(itemsInStore, 0, newArray, 0, index);
            System.arraycopy(itemsInStore, index + 1, newArray, index, MAX_QUANTITY - index - 1);
            itemsInStore = newArray;
            qty_ordered -= 1;
        }
    }
    public void print() {
        StringBuilder out = new StringBuilder();
        out.append("***********************CART***********************\n");
        out.append("Ordered Items:\n");
        int count = 0;
        for (DigitalVideoDisc digitalVideoDisc : itemsInStore) {
            if (digitalVideoDisc != null) {
                count++;
                out.append(count + ". ");
                out.append(digitalVideoDisc);
                out.append("\n");
            }
        }
        out.append("***************************************************");
        System.out.println(out);
    }
}
