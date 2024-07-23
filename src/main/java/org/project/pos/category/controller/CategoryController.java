package org.project.pos.category.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.category.model.CategoryRes;
import org.project.pos.category.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView category() {
        ModelAndView view = new ModelAndView("pages/master/category/index");
        List<CategoryRes> result = this.categoryService.getAll();

        view.addObject("category", result);
        return view;
    }

    @GetMapping("/data")
    public List<CategoryRes> getData(){
        try {
            return this.categoryService.getAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
