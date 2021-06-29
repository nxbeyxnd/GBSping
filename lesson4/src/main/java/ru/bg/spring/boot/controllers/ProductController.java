package ru.bg.spring.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bg.spring.boot.model.Product;
import ru.bg.spring.boot.service.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/prod")
    @ResponseBody
    public Product getById(@RequestParam Integer id){
        return productService.findById(id);
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_products";
    }

    @PostMapping("/add")
    public String saveNewProduct(@RequestParam String title, @RequestParam Integer cost) {
        productService.add(title, cost);
        return "add_products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit_products";
    }

    @PostMapping("/edit")
    public String saveProduct(@RequestParam Integer id, @RequestParam String title, @RequestParam Integer cost) {
        productService.update(id, title, cost);
        return "redirect:/products/";
    }
}
