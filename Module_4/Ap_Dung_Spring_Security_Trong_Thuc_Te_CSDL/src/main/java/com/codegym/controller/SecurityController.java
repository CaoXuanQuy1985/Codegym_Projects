package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class SecurityController {

    @Autowired
    private InterfaceCommentService interfaceCommentService;

    @Autowired
    private InterfaceRatingService interfaceRatingService;

/*    @GetMapping("/")
    public String index() {
        return "index-test";
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal, Pageable pageable) {
        System.out.println(principal.getName());
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("user-page");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin(Pageable pageable) {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("admin-page");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        return modelAndView;
    }*/

    private String getPrincipal() {

        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping(value="/index")
    public ModelAndView index(Pageable pageable) {
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;
    }

    @GetMapping(value={"/", "/home"})
    public String Homepage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }

    @RequestMapping(value="/admin-page", method= RequestMethod.GET)
    public ModelAndView adminPage(Pageable pageable) {
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("admin-page");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;
    }

    @RequestMapping(value="/Access_Denied", method= RequestMethod.GET)
    public String accessDenied(ModelMap modelMap) {
        modelMap.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value="/dba", method= RequestMethod.GET)
    public String dbaPage(ModelMap modelMap) {
        modelMap.addAttribute("user", getPrincipal());
        return "welcome";
    }

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public ModelAndView userPage(Pageable pageable) {
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("user-page");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;
    }
}
