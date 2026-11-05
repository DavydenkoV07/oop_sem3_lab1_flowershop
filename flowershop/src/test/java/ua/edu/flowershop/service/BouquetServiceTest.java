package ua.edu.flowershop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.edu.flowershop.model.Accessory;
import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Flower;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BouquetServiceTest {

    private BouquetService bouquetService;
    private Bouquet bouquet;

    @Mock
    private Flower mockFlower1;
    @Mock
    private Flower mockFlower2;
    @Mock
    private Accessory mockAccessory;

    @BeforeEach
    void setUp() {
        bouquetService = new BouquetService();
        bouquet = new Bouquet();
    }

    @Test
    void testCalculateTotalPrice() {
        // Налаштування поведінки мок-об'єктів (Mockito)
        Mockito.when(mockFlower1.getPrice()).thenReturn(50.0);
        Mockito.when(mockFlower2.getPrice()).thenReturn(30.0);
        Mockito.when(mockAccessory.getPrice()).thenReturn(20.0);

        bouquet.addFlower(mockFlower1);
        bouquet.addFlower(mockFlower2);
        bouquet.addAccessory(mockAccessory);

        double total = bouquetService.calculateTotalPrice(bouquet);

        // Перевірка
        assertEquals(100.0, total, 0.001, "Вартість букета розрахована неправильно");
    }

    @Test
    void testFindFlowersByStemLengthRange() {
        Mockito.when(mockFlower1.getStemLength()).thenReturn(40.0);
        Mockito.when(mockFlower2.getStemLength()).thenReturn(60.0);

        bouquet.addFlower(mockFlower1);
        bouquet.addFlower(mockFlower2);

        List<Flower> result = bouquetService.findFlowersByStemLengthRange(bouquet, 35.0, 50.0);

        assertEquals(1, result.size());
        assertEquals(mockFlower1, result.get(0));
    }
}