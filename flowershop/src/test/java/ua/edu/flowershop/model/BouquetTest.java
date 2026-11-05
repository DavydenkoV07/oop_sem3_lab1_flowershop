
package ua.edu.flowershop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BouquetTest {

    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
    }

    @Test
    void testAddFlower() {
        Flower rose = new Rose(50.0, 60.0, 9, true);
        bouquet.addFlower(rose);

        assertEquals(1, bouquet.getFlowers().size());
        assertEquals(rose, bouquet.getFlowers().get(0));
        assertTrue(((Rose) bouquet.getFlowers().get(0)).isHasThorns()); // Специфічна перевірка для Rose
    }

    @Test
    void testAddAccessory() {
        Accessory ribbon = new Accessory("Ribbon", 10.0);
        bouquet.addAccessory(ribbon);

        assertEquals(1, bouquet.getAccessories().size());
        assertEquals(ribbon, bouquet.getAccessories().get(0));
        assertEquals("Ribbon", bouquet.getAccessories().get(0).getName());
    }

    @Test
    void testFlowerInitialization() {
        Flower tulip = new Tulip(35.0, 45.0, 10);
        
        assertEquals("Tulip", tulip.getName()); 
        assertEquals(35.0, tulip.getPrice());
        assertEquals(45.0, tulip.getStemLength());
        assertEquals(10, tulip.getFreshnessLevel());
    }
}