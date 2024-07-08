package org.project.pos.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public String getProducts() {
        return "pages/master/products/index";
    }

    @GetMapping("/add")
    public String addProduct() {
        return "pages/master/products/add";
    }
}
