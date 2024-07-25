package org.project.pos.form.category.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.form.category.model.CategoryRes;
import org.project.pos.form.category.service.CategoryService;
import org.project.pos.base.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView category() {
        ModelAndView view = new ModelAndView("pages/master/category/index");
//        List<CategoryRes> result = this.categoryService.getAll();

//        view.addObject("category", result);
        return view;
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        List<CategoryRes> result = this.categoryService.getAll();
//        List<CategoryRes> result = new ArrayList<>();
//        result.add(new CategoryRes(1, "product-1.png", "Smart Phone", "Choose from wide range of smartphones from popular brands", "$99129", 1947));
//        result.add(new CategoryRes(2, "product-2.png", "Electronics", "Choose from wide range of electronics from popular brands", "$2512.50", 7283));
//        result.add(new CategoryRes(3, "product-3.png", "Clocks", "Choose from wide range of clocks from popular brands", "$1612.34", 2954));
//        result.add(new CategoryRes(4, "product-4.png", "Shoes", "Explore the latest shoes from Top brands", "$3612.98", 4940));
//        result.add(new CategoryRes(5, "product-5.png", "Accessories", "Explore best selling accessories from Top brands", "$79129", 4665));

        Response response = new Response(result);
        return ResponseEntity.ok(response);
    }
}
