package ru.netology.productManager;

public class ProductRepository {
    private Product[] items = new Product[0];

    public Product[] findAll() {

        return items;
    }

    public void save(Product product) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = product;
        items = temp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundIdException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        items = tmp;
    }
    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
