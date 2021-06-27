package ru.bg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bg.app.model.Product;
import ru.bg.app.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAllProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm(){
        return "add_products";
    }

    @PostMapping("/add")
    public String saveNewProduct(@RequestParam String title, @RequestParam Integer cost) {
        productService.add(title, cost);
        return "add_products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit_products";
    }

    @PostMapping("/edit")
    public String saveProduct(@RequestParam Integer id, @RequestParam String title, @RequestParam Integer cost) {
        productService.update(id, title, cost);
        return "redirect:/products/";
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Product showJsonStundent(@PathVariable Integer id) {
        return productService.findById(id);
    }
}
