package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.model.RatingPoint;
import com.codegym.model.Wrapper;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import com.codegym.service.exception.FilterBadWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CommentRecordController {

    @Autowired
    private InterfaceCommentService interfaceCommentService;

    @Autowired
    private InterfaceRatingService interfaceRatingService;

    @ModelAttribute("ratingPoints")
    public Iterable<RatingPoint> ratingPoints() {
        Iterable<RatingPoint> test = interfaceRatingService.findAll();
        return interfaceRatingService.findAll();
    }

/*    @GetMapping(value="/")
    public ModelAndView showIndex(Pageable pageable) {
        Page<CommentRecord> commentRecordList = interfaceCommentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("commentRecord", new CommentRecord());
        modelAndView.addObject("commentRecordList", commentRecordList);
        return modelAndView;
    }*/

    @RequestMapping(value="/create-feedback", method= RequestMethod.POST)
    public ModelAndView saveComment(@ModelAttribute("commentRecord") CommentRecord commentRecord) {
        try {
            interfaceCommentService.save(commentRecord);
        } catch (FilterBadWord ex) {
            return new ModelAndView("/inputs-not-acceptable");
        }
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
        interfaceCommentService.save(commentRecord);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/search", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CommentRecord findByAuthor(@RequestBody Wrapper wrapper) {
        List<CommentRecord> result = interfaceCommentService.findAllByAuthor(wrapper.getAuthor());
        return result.get(0);
    }

    @ExceptionHandler(FilterBadWord.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}
