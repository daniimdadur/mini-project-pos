package org.project.pos.customers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomersController {
    @GetMapping
    public String getCustomers() {
        return "pages/master/customers/index";
    }
}
