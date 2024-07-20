package org.project.pos.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AuthController {
    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("pages/auth/login");
    }

    @GetMapping("forgot")
    public ModelAndView forget() {
        return new ModelAndView("pages/auth/forgot-password");
    }
}
