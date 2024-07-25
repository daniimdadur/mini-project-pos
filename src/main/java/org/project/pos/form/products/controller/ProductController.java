package org.project.pos.form.products.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.base.Response;
import org.project.pos.form.products.model.ProductRes;
import org.project.pos.form.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ModelAndView getProducts() {
        ModelAndView view = new ModelAndView("pages/master/products/index");
        return view;
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        List<ProductRes> result = this.productService.geAll();

        //cara satu
//        List<ProductRes> result = new ArrayList<>();
//        result.add(new ProductRes(1, "iPhone 14 Pro", 2, 1, 19472, "$999", 665, 3, "product-1.png", "Super Retina XDR display, footnote Pro Motion technology"));
//        result.add(new ProductRes(2, "Echo Dot (4th gen)", 2, 0, 72836, "$25.50", 6857, 2, "product-2.png", "Super Retina XDR display, footnote Pro Motion technology"));

        Response response = new Response(result);
        return ResponseEntity.ok(response);
    }
}
