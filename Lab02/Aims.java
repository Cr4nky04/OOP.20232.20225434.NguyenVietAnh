package Lab02;

public class Aims {
    public static void main(String[] args) {
//        DigitalVideoDisc disk1 = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc disk2 = new DigitalVideoDisc("Jungle1");
//        DigitalVideoDisc disk3 = new DigitalVideoDisc("Jungle2");
//        System.out.println(disk1.getId());
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers"
                ,87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas"
                , 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("The remain number of items of cart is: ");
        System.out.println(anOrder);
    }
}
