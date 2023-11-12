package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void shouldCreateOrder() {
        Order order = new Order();
        order.setId(1);
        order.setCustomer(2);
        order.setPrice(3);
        order.setQuantity(4);
        assertEquals(order.getId(), 1);
        assertEquals(order.getCustomer(), 2);
        assertEquals(order.getPrice(), 3);
        assertEquals(order.getQuantity(), 4);
    }

    @Test
    public void shouldEquals() {
        Order o1 = new Order();
        Order o2 = new Order();

        o1.setId(1);
        o2.setId(1);

        assertTrue(o1.equals(o2));
    }

    @Test
    public void shouldNotEquals() {
        Order o1 = new Order();
        Order o2 = new Order();
        o1.setId(1);
        o2.setId(2);
        assertFalse(o1.equals(o2));

        Engine e = new Engine();
        assertFalse(o1.equals(e));
    }
}