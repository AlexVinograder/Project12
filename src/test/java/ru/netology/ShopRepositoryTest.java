package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeProductIfExistTest() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Молоко", 100);
        Product product2 = new Product(2, "Яйца", 80);
        Product product3 = new Product(3, "Хлеб", 20);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(1);

        Product[] expected = repository.findAll();
        Product[] actual = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductIfNotExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Молоко", 100);
        Product product2 = new Product(2, "Яйца", 80);
        Product product3 = new Product(3, "Хлеб", 20);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.remove(4)
        );
    }
}
