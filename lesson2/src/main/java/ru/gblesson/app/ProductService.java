package ru.gblesson.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public int countOfProducts(){
        return getProducts().size();
    }

    public int avgOfCostProducts(){
        int avgPrice = 0;
        for (int i = 0; i < getProducts().size(); i++) {
            avgPrice += getProducts().get(i).getCost();
        }
        return avgPrice/getProducts().size();
    }

    public void add(Product product){
        productRepository.add(product);
    }

    public void remove(int id){
        if (id < 0){
            System.out.println("'Id' can't be less than 0, please enter id again!");
        } else {
            productRepository.remove(id - 1);
        }
    }

    public void update(int index, int id, String title, int cost){
        productRepository.update(index, new Product(id,title,cost));
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
