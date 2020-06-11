package com.codegym.controller;

import com.codegym.model.ShoppingCart;
import com.codegym.model.Product;
import com.codegym.service.InterfaceProductService;
import com.codegym.service.InterfaceShoppingCartService;
import com.codegym.service.exception.BookNotExists;
import com.codegym.service.exception.OutOfBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes("shoppingCart")
public class ShoppingCartController {
    private static List<Product> shoppingCart;

    @ModelAttribute("shoppingCart")
    public List<Product> createShoppingCart() {
        return new ArrayList<Product>();
    }

    @Autowired
    private InterfaceShoppingCartService interfaceShoppingCartService;

    @Autowired
    private InterfaceProductService interfaceProductService;

    @GetMapping("/")
    public ModelAndView showProductList() {
        Iterable<Product> listAllProducts = interfaceProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listAllProducts", listAllProducts);
        return modelAndView;
    }

    @GetMapping("/product/{id}")
    public ModelAndView showDetailProduct(@PathVariable Long id) {
        Product product = interfaceProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("product-detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/addtocart")
    public ModelAndView addToCart(@ModelAttribute("shoppingCart") List<Product> shoppingCart, @ModelAttribute("product") Product product) {
        shoppingCart.add(product);
        ModelAndView modelAndView = new ModelAndView("product-detail");
        return modelAndView;
    }

    @GetMapping("/shoppingcart")
    public ModelAndView showShoppingCart(@ModelAttribute("shoppingCart") List<Product> shoppingCart) {
        ModelAndView modelAndView = new ModelAndView("shopping-cart");
        modelAndView.addObject("shoppingCart", shoppingCart);
        return modelAndView;
    }

    @PostMapping("/calculate-sum")
    public ModelAndView payOrder(@ModelAttribute("shoppingCart") List<Product> shoppingCart, HttpServletRequest request) {
        double totalPayment = 0.0;
        for (Product p : shoppingCart) {
            totalPayment += p.getPrice() * p.getQuantity();
        }

        ModelAndView modelAndView = new ModelAndView("pay-order");
        modelAndView.addObject("shoppingCart", shoppingCart);
        HttpSession session = request.getSession();
        session.setAttribute("totalPayment", totalPayment);

        return modelAndView;
    }

   /* @ExceptionHandler(BookNotExists.class)
    public ModelAndView showError404Return() {
        return new ModelAndView("error-404-return");
    }

    @ExceptionHandler(OutOfBookException.class)
    public ModelAndView showError404() {
        return new ModelAndView("error-404");
    }
*/}
