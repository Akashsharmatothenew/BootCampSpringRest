package javajunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Created by ttn on 1/3/21.
 */
class OrderTest {
    Double tax = 5.4;
    public Order order = new Order(3, "Laptop", 349.4);
    @Test
    void testGetQuantity(){
        int quantity =3;
        assertTrue(order.getQuantity() == quantity);
    }
    @Test
    void testIteam(){
        String iteam1="Laptop";
        String actual =order.getItemName();
        assertEquals(iteam1,actual);
    }
     @Test
    void testPrice(){
        Double price = 349.4;
        Double actual = order.getPrice();
        assertEquals(price,actual);
     }

     @Test
    void testPriceWithTax(){
        Double tax1 = 5.4;
        Double actual = order.getPriceWithTex();
        assertEquals(tax1,actual);
     }

}