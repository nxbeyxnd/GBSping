package ru.bg.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bg.spring.boot.exceptions.ResourceNotFoundException;
import ru.bg.spring.boot.model.Product;
import ru.bg.spring.boot.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product add(String title, Integer cost) {
        return productRepo.add(title, cost);
    }

    public Product findById(Integer id) {
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " is null"));
    }

    public Product update(Integer id, String title, Integer cost) {
        return productRepo.update(id, title, cost);
    }

}
