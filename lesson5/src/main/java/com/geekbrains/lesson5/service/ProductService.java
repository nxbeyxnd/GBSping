package com.geekbrains.lesson5.service;

import com.geekbrains.lesson5.model.Product;
import com.geekbrains.lesson5.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    RepositoryProduct repositoryProduct;

    public List<Product> getAllProducts(){
        return repositoryProduct.showAllProducts();
    }

    public Product addProduct(Product product){
        return repositoryProduct.addProducts(product);
    }

    public Product updateProduct(Product product){
        return repositoryProduct.updateProducts(product);
    }

    public void deleteClient(Long id){
        repositoryProduct.deleteProducts(id);
    }

    public Product findById(Long id){
        return repositoryProduct.showById(id);
    }
}
