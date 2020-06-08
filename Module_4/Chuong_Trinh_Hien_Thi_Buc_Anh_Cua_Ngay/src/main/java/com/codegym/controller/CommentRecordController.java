package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.model.RatingPoint;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        modelAndView.addObject("commentRecord", new CommentRecord());
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value="/calculate-likes/{id}")
    public ModelAndView calLikes(@PathVariable Long id) throws Exception{
        CommentRecord commentRecord = interfaceCommentService.findById(id);
        Long oldLike = commentRecord.getNumberLikes();
        Long newLike = oldLike + 1;
        commentRecord.setNumberLikes(newLike);
        ModelAndView modelAndView = new ModelAndView("index");
        /*modelAndView.addObject("commentRecord", newComment);*/
        interfaceCommentService.save(commentRecord);

        return new ModelAndView("redirect:/");
    }
}
