package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private static final Log logger = LogFactory.getLog(CustomerController.class);

    @RequestMapping(value="/list-customers")
    public String listCustomers(Model model) {
        logger.info("listCustomers");
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @RequestMapping(value = "/edit-customer/{id}")
    public String editCustomer(Model model, @PathVariable Long id) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "info";
    }

    @RequestMapping(value="/update-customer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:list-customers";
    }

    @RequestMapping(value="/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping(value="/customers/{id}")
    public ModelAndView showInformation(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}


