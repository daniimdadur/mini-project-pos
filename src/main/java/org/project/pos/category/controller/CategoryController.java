package org.project.pos.category.controller;

import org.project.pos.category.model.CategoryRes;
import org.project.pos.category.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView category() {
        ModelAndView view = new ModelAndView("pages/master/category/index");
        List<CategoryRes> result = this.categoryService.getAll();

        view.addObject("category", result);
        return view;
    }
}
