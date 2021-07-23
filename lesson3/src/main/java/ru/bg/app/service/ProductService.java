package ru.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bg.app.model.Product;
import ru.bg.app.repo.ProductRepo;

import java.util.List;

@Component
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public void setStudentsRepository(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product add(String title, Integer cost){
        return productRepo.add(title, cost);
    }

    public Product findById(Integer id) {
        return productRepo.findById(id);
    }

    public Product update(Integer id, String title, Integer cost){
        return productRepo.update(id, title, cost);
    }

}
