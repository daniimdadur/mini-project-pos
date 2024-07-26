package org.project.pos.form.customers.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.base.Response;
import org.project.pos.form.customers.model.CustomersRes;
import org.project.pos.form.customers.service.CustomersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomersController {
    private final CustomersService customersService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView view = new ModelAndView("pages/master/customers/index");
//        List<CustomersRes> result = this.customersService.getAll();
//
//        view.addObject("customers", result);
        return view;
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        //cara satu menggunakan list tanpa DB
//        List<CustomersRes> customersRes = new ArrayList<>();
//        customersRes.add(new CustomersRes(1, "Stanfield Baser", 879861, "sbaser0@boston.com", "Sri Lanka", "lk", 157, "$2074.22", "3.png"));
//        customersRes.add(new CustomersRes(2, "Laurie Dax", 178408, "ldax1@lycos.com", "Russia", "ru", 663, "$2404.19", "2.png"));

        List<CustomersRes> customersRes = this.customersService.getAll();

        Response response = new Response(customersRes);
        return ResponseEntity.ok(response);
    }
}
