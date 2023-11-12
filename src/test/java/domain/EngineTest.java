package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTest {

    private Engine engine;

    @BeforeEach
    public void setUp() {
        engine = new Engine();
    }

    @Test
    public void shouldAddOrder() {
        Order o1 = new Order();
        o1.setId(1);
        o1.setCustomer(1);
        o1.setPrice(1000);
        o1.setQuantity(50);
        int quantity = engine.addOrderAndGetFraudulentQuantity(o1);
        assertEquals(quantity, 50);
    }


    @Test
    public void shouldNotAddSameOrder() {
        Order o1 = new Order();
        o1.setId(1);
        o1.setCustomer(1);
        o1.setPrice(1000);
        o1.setQuantity(50);
        engine.addOrderAndGetFraudulentQuantity(o1);
        int quantity = engine.addOrderAndGetFraudulentQuantity(o1);
        assertEquals(quantity, 0);
    }

    @Test
    public void shouldNotAddZeroQuantityOrder() {
        Order o1 = new Order();
        o1.setId(1);
        o1.setQuantity(0);

        int quantity = engine.addOrderAndGetFraudulentQuantity(o1);
        assertEquals(quantity, 0);
    }

    @Test
    public void shouldReturnQuantityPatternByPrice() {
        Order o1 = new Order();
        o1.setId(4);
        o1.setPrice(100);
        o1.setCustomer(1);
        o1.setQuantity(10);

        Order o2 = new Order();
        o2.setId(5);
        o2.setPrice(100);
        o2.setCustomer(1);
        o2.setQuantity(15);

        Order o3 = new Order();
        o3.setId(6);
        o3.setPrice(100);
        o3.setCustomer(1);
        o3.setQuantity(20);

        Order o4 = new Order();
        o4.setId(4);
        o4.setPrice(200);
        o4.setCustomer(1);
        o4.setQuantity(15);

        Order o5 = new Order();
        o5.setId(5);
        o5.setPrice(200);
        o5.setCustomer(1);
        o5.setQuantity(20);

        engine.addOrderAndGetFraudulentQuantity(o1);
        engine.addOrderAndGetFraudulentQuantity(o2);
        engine.addOrderAndGetFraudulentQuantity(o3);
        engine.addOrderAndGetFraudulentQuantity(o4);
        engine.addOrderAndGetFraudulentQuantity(o5);

        assertEquals(engine.getQuantityPatternByPrice(100), 5);
        assertEquals(engine.getQuantityPatternByPrice(200), 0);
    }
}