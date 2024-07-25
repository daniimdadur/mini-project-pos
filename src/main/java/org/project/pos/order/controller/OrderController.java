package org.project.pos.order.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.base.Response;
import org.project.pos.order.model.OrderRes;
import org.project.pos.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ModelAndView order() {
        ModelAndView view = new ModelAndView("pages/master/order/index");
        return view;
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        List<OrderRes> result = new ArrayList<>();
        result.add(new OrderRes(1, 5434, "Gabrielle Feyer", "gfeyer@nyu.edu", "8.png", 1, 1, "$73.98", "paypal_logo", "5/16/2022", "2:11 AM", 6522));
        result.add(new OrderRes(2, 54342, "Jackson Deignan", "jdeignan1@dell.com", "2.png", 3, 1, "$72.98", "paypal_logo", "5/3/2022", "7:26 PM", 7538));

        Response response = new Response();
        return ResponseEntity.ok(response);
    }
}
