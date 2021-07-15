package com.alexeyshekhonov.gbshop.repository;

import com.alexeyshekhonov.gbshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleIsStartingWith(String startsWith);
    List<Product> findByCostGreaterThan(int min);
    List<Product> findByCostLessThan(int min);
    List<Product> findAllByCostBetween(int min, int max);
}
