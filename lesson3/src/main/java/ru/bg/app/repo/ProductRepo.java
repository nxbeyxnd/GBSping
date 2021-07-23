package ru.bg.app.repo;

import org.springframework.stereotype.Component;
import ru.bg.app.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepo {
    private List<Product> products;
    private int currentId = 0;

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product add(String title, Integer cost){
        Product product = new Product(currentId++, title, cost);
        products.add(product);
        return product;
    }

    public Product findById(Integer id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public Product update(Integer id, String title, Integer cost){
        Product product = new Product(id, title, cost);
        products.set(id-1, product);
        return product;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1, "potato", new Random().nextInt(1000)));
        products.add(new Product(2, "tomato", new Random().nextInt(1000)));
        products.add(new Product(3, "cucumber", new Random().nextInt(1000)));
        currentId = 4;
    }
}
