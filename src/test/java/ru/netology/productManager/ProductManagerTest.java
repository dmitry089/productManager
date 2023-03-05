package ru.netology.productManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Master And Margarita", 350, "Bulgakov");
    private Book book2 = new Book(2, "Ruslan And Ludmila", 500, "Pushkin");
    private Book book3 = new Book(3, "Idiot", 800, "Dostoevskii");
    private Smartphone smartphone1 = new Smartphone(4, "Xiaomi", 1000, "Performance 1");
    private Smartphone smartphone2 = new Smartphone(5, "Huawei 10 pro", 2000, "Performance 2");
    private Smartphone smartphone3 = new Smartphone(6, "Huawei 11", 3000, "Performance 3");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldAddProductGetItems() {
        Product[] results = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] expected = repository.findAll();
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void searchBySmartphoneTwoName() {
        Product[] results = manager.searchBy("Huawei");

        Product[] expected = new Product[]{smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void searchByTittleOfTheBook() {
        Product[] results = manager.searchBy("Ruslan And Ludmila");
        Product[] expected = new Product[]{book2};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void searchByNameSmartphoneNotListed() {
        Product[] results = manager.searchBy("Samsung");
        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void searchByNameBookNotListed() {
        Product[] results = manager.searchBy("War And Peace");
        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void searchByTwoParametersInBook() {
        Product[] results = manager.searchBy("Idiot");
        Product[] results2 = manager.searchBy("Dostoevskii");
        Product[] expected = new Product[]{book3};
        Assertions.assertArrayEquals(expected, results, Arrays.toString(results2));
    }

    @Test
    public void searchByTwoParametersInSmartphone() {
        Product[] results = manager.searchBy("Huawei 10 pro");
        Product[] results2 = manager.searchBy("Performance2");
        Product[] expected = new Product[]{smartphone2};

        Assertions.assertArrayEquals(expected, results, Arrays.toString(results2));
    }
}




