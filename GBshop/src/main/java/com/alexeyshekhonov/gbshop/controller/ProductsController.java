package com.alexeyshekhonov.gbshop.controller;

import com.alexeyshekhonov.gbshop.entity.Product;
import com.alexeyshekhonov.gbshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public List<Product> showAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.saveNewProduct(product);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/findMinMax")
    public List<Product> findMinAndMax(@RequestParam int min, @RequestParam int max){
        return productService.getMinAndMax(min, max);
    }

    @GetMapping("/findMin")
    public List<Product> findCostMin(@RequestParam int min){
        return productService.getCostMin(min);
    }

    @GetMapping("/findMax")
    public List<Product> findCostMax(@RequestParam int max){
        return productService.getCostMax(max);
    }


    @GetMapping("/title")
    public List<Product> getByTitle(@RequestParam String startsWith){
        return productService.getSimilar(startsWith);
    }
}
