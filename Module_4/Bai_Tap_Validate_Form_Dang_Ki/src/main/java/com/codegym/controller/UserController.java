package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public ModelAndView showFormRegister() {
        ModelAndView modelAndView = new ModelAndView("register-form");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping(value="/validate-register")
    public ModelAndView validateRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("register-form");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("result");
            userService.save(user);
            return modelAndView;
        }
    }
}
