package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String showListProduct(Model model) {
        List<Product> products = productService.listAllProduct();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value="/product/{id}/", method = RequestMethod.GET)
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @RequestMapping(value="/product/edit", method = RequestMethod.POST)
        public String editProduct(Product product, RedirectAttributes redirect) {
        productService.updateProduct(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified Product Successful");
        return "redirect:/";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int)Math.random() * 10000);
        productService.addProduct(product);
        redirect.addFlashAttribute("success", "Create new Product Successful");
        return "redirect:/";
    }
}
