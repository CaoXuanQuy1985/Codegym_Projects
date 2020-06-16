package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class SecurityController {

    @Autowired
    private InterfaceCommentService interfaceCommentService;

    @Autowired
    private InterfaceRatingService interfaceRatingService;

    @GetMapping("/")
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
    }
}
