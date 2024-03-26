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
            System.arraycopy(itemsOrdered, index + 1, newArray, index, MAX_NUMBERS_ORDERED - index);
            itemsOrdered = newArray;
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

}
