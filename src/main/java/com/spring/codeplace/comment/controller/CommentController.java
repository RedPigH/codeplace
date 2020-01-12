package com.spring.codeplace.comment.controller;

import com.spring.codeplace.comment.entity.Comment;
import com.spring.codeplace.comment.service.CommentService;
import com.spring.codeplace.question.entity.Question;
import com.spring.codeplace.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    CommentService cservice;
    @Autowired
    QuestionService qservice;

    @PostMapping("/comment/write-comment/{targetoid}")
    public String writeComment(Comment comment, @PathVariable("targetoid") Long targetoid){
        //ModelAndView mv = new ModelAndView("question/questionRead");
        cservice.writeComment(comment);

        Question tmp = qservice.getOneQuestion(targetoid);

        qservice.updateAddCmtcnt(tmp.getOid(), tmp);

        //mv.addObject("Question",tmp);

        return "redirect:/questions/view/"+targetoid;
    }

    @RequestMapping("/comment/delete-comment/{oid}")
//    , @RequestParam(value = "targetoid") Long targetoid
    public String deleteComment(@PathVariable("oid") Long oid){
        //ModelAndView mv = new ModelAndView("question/questionRead");
        Long targetoid = cservice.getOneComment(oid).getTargetoid();
        cservice.deleteComment(oid);

        Question tmp = qservice.getOneQuestion(targetoid);
        qservice.updateSubCmtcnt(tmp.getOid(),tmp);

        return "redirect:/questions/view/"+targetoid;
    }

    @RequestMapping("/comment/modify-comment")
    public ModelAndView modifyComment(@PathVariable("oid") Long oid, @PathVariable("targetoid") Long targetoid, Comment comment){
        ModelAndView mv = new ModelAndView("question/questionRead");
        cservice.modifyQuestion(oid,comment);
        Question tmp = qservice.readQuestion(targetoid);
        mv.addObject("Question",tmp);
        return mv;
    }
}
