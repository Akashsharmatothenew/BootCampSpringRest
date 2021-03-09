package java1;

/**
 * Created by ttn on 28/2/21.
 */
enum property{
    house1(10),
    house2(20),
    house3(15),
    house4(39),
    house5(25);
    int price;

    property(int i) {
        price=i;
    }
    int getPrice(){
        return price;
    }
}
public class Q9 {
    public static void main(String[] args) {
        System.out.println("All House Details");
        for(property h:property.values())
            System.out.println( h +" Price "+ h.getPrice() + "  Lakh Rupeees");
    }
}
