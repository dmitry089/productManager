package ru.netology.productManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Властелин колец", 650, "Джон Рональд");
    private Book book2 = new Book(2, "Мертвые души", 900, "Гоголь");
    private Book book3 = new Book(3, "12 стульев", 1000, "Петров");
    private Smartphone smartphone1 = new Smartphone(4, "Xiaomi", 1000, "Performance 1");
    private Smartphone smartphone2 = new Smartphone(5, "Huawei 10 pro", 2000, "Performance 2");
    private Smartphone smartphone3 = new Smartphone(6, "Huawei 11", 3000, "Performance 3");


    @Test
    public void shouldAddProductsAndFindAll() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        Product[] results = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Product[] expected = repository.findAll();
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(book3.getId());

        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilmNull() {
        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowException() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        Assertions.assertThrows(NotFoundIdException.class, () -> {
            repository.removeById(666);
        });
    }
    @Test
    public void shouldNotThrowException () {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.removeById(2);
        Product[] expected = new Product[]{book1,book3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
}

