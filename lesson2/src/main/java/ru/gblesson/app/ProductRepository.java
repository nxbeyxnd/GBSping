package ru.gblesson.app;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    void add(Product product);
    void remove(int id);
    void update(int index, Product product);
}
