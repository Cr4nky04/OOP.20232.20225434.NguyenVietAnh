package Lab02;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered==MAX_NUMBERS_ORDERED)
        {
            throw new ArithmeticException("Cannot add more discs. The cart is almost full");
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered+=1;
        System.out.println("The disc has been added");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
    {
        if (qtyOrdered+dvdList.length-1>=MAX_NUMBERS_ORDERED)
        {
            throw new ArithmeticException("Cannot add more discs. The cart is almost full");
        }
        for(DigitalVideoDisc dvd: dvdList)
        {
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered+=1;
        }
        System.out.println(dvdList.length+" discs have been added");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
    {
        if (qtyOrdered+1>=MAX_NUMBERS_ORDERED)
        {
            throw new ArithmeticException("Cannot add more discs. The cart is almost full");
        }
        itemsOrdered[qtyOrdered] = dvd1;
        qtyOrdered+=1;
        itemsOrdered[qtyOrdered] = dvd2;
        qtyOrdered+=1;
        System.out.println("2 discs have been added");

    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        int index = -1;
        for(int i = 0; i<MAX_NUMBERS_ORDERED; i++)
        {
            if(itemsOrdered[i].equals(disc))
            {
                index = i;
                break;
            }
        }
        if (index!=-1)
        {
            DigitalVideoDisc[] newArray = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
            System.arraycopy(itemsOrdered, 0, newArray, 0, index);
            System.arraycopy(itemsOrdered, index + 1, newArray, index, MAX_NUMBERS_ORDERED - index-1);
            itemsOrdered = newArray;
            qtyOrdered -= 1;
        }
    }
    public float totalCost()
    {
        float cost = 0;
        for(int i = 0; i<qtyOrdered; i++)
        {
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
    public int count()
    {
        return qtyOrdered;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (DigitalVideoDisc digitalVideoDisc : itemsOrdered) {
            if(digitalVideoDisc != null)
            {
                out.append(digitalVideoDisc.getTitle());
                out.append("\n");
            }
        }
        return out.toString();
    }
}
