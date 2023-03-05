package ru.netology.productManager;

public class ProductManager {
    protected ProductRepository repository;

    public ProductManager(ProductRepository repository) {

        this.repository = repository;
    }

    public void add(Product items) {
        repository.save(items);

    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[temp.length - 1] = product;
                result = temp;
            }
        }
        return result;
    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return (product.matches(search));

    }
}