package com.geekbrains.lesson5.repository;

import com.geekbrains.lesson5.model.Product;

import java.util.List;

public interface ProductsCRUD {
    public Product addProducts(Product product);
    public Product updateProducts(Product product);
    public void deleteProducts(Long id);
    public List<Product> showAllProducts();
    public Product showById(Long id);

}
