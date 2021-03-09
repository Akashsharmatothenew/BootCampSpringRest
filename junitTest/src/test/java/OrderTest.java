import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ttn on 1/3/21.
 */
class OrderTest {
    Order order = new Order(3,"Laptop",350.40);
    @Test
    void getQuantity() {
        int expected=2;
        assertTrue(order.getQuantity() == expected);
    }

}