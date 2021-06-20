package ru.gblesson.app;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoEditor implements ProductRepository{
    private List<Product> products;

    @Override
    public void add(Product product){
        products.add(product);
    }

    @Override
    public void remove(int id){
        if (id < 0){
            System.out.println("'Id' can't be less than 0, please enter id again!");
        } else {
            products.remove(id - 1);
        }
    }

    @Override
    public void update(int index, Product product){
        products.set(index, product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1, "potato", 100));
        products.add(new Product(2, "tomato", 50));
        products.add(new Product(3, "tomato", 50));
    }
}
