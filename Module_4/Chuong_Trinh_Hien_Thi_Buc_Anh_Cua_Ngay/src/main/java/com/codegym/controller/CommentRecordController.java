package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.model.RatingPoint;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentRecordController {

    @Autowired
    private InterfaceCommentService interfaceCommentService;

    @Autowired
    private InterfaceRatingService interfaceRatingService;

    @ModelAttribute("ratingPoints")
    public Iterable<RatingPoint> ratingPoints() {
        return interfaceRatingService.findAll();
    }

    @GetMapping(value="/")
    public ModelAndView showIndex(Pageable pageable) {
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        return modelAndView;
    }

    @RequestMapping(value="/create-feedback", method= RequestMethod.POST)
    public ModelAndView saveComment(@ModelAttribute("commentRecord") CommentRecord commentRecord) {
        interfaceCommentService.save(commentRecord);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customer", new CommentRecord());
        return modelAndView;
    }
}
