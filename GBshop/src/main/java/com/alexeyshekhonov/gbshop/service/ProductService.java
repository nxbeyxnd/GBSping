package com.alexeyshekhonov.gbshop.service;

import com.alexeyshekhonov.gbshop.entity.Product;
import com.alexeyshekhonov.gbshop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    public Product getProductById(Long id){
        return productsRepository.findById(id).get();
    }

    public List<Product> getAll(){
        return productsRepository.findAll();
    }

    public Product saveNewProduct(Product product){
        return productsRepository.save(product);
    }

    public void deleteProductById(Long id){
        productsRepository.deleteById(id);
    }

    public List<Product> getCostMin(int min){
        return productsRepository.findByCostGreaterThan(min);
    }

    public List<Product> getCostMax(int max){
        return productsRepository.findByCostLessThan(max);
    }

    public List<Product> getMinAndMax(int min, int max){
        return productsRepository.findByCostGreaterThanAndCostLessThan(min, max);
    }

    public List<Product> getSimilar(String startsWith){
        return productsRepository.findByTitleIsStartingWith(startsWith);
    }
}
