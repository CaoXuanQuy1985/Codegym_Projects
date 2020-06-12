package com.codegym.controller;

import com.codegym.model.CommentRecord;
import com.codegym.model.RatingPoint;
import com.codegym.repository.InterfaceCommentProcessDB;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.InterfaceRatingService;
import com.codegym.service.exception.FilterBadWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CommentRecordController {

    @Autowired
    private InterfaceCommentService interfaceCommentService;

/*    @Autowired
    private InterfaceRatingService interfaceRatingService;*/

    @Autowired
    private InterfaceCommentProcessDB interfaceCommentProcessDB;

/*    @ModelAttribute("ratingPoints")
    public Iterable<RatingPoint> ratingPoints() {
        return interfaceRatingService.findAll();
    }*/

    @RequestMapping(value="/comments/", method = RequestMethod.GET)
    public ResponseEntity<List<CommentRecord>> listAllComments() {
        List<CommentRecord> commentRecordList = interfaceCommentService.findAll();
        if (commentRecordList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentRecordList, HttpStatus.OK);
    }

    @RequestMapping(value="/create-feedback", method= RequestMethod.POST)
    public ResponseEntity<Void> saveComment(@RequestBody CommentRecord commentRecord, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = null;
        try {
            interfaceCommentService.save(commentRecord);
            headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/comments/{id}").buildAndExpand(commentRecord.getId()).toUri());
        } catch (FilterBadWord ex) {
            System.out.println("Exception Badword, comments can not accepted !!!");
        }
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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

    @ExceptionHandler(FilterBadWord.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}
