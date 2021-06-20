package ru.gblesson.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("ru.gblesson.app")
public class AppConfig {
    @Autowired
    private ProductService productService;

    @Bean(value = "/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Bean(value = "/getCount")
    public int countOfProducts() {
        return productService.countOfProducts();
    }

    @Bean(value = "/getAvg")
    public int avgOfCostProducts() {
        return productService.avgOfCostProducts();
    }

}
