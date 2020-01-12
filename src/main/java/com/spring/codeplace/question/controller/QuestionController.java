package com.spring.codeplace.question.controller;

import com.spring.codeplace.comment.entity.Comment;
import com.spring.codeplace.comment.service.CommentService;
import com.spring.codeplace.question.entity.Question;
import com.spring.codeplace.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionService qservice;
    @Autowired
    CommentService cservice;

    @RequestMapping("/questions/list")
    public ModelAndView listQuestion(Pageable pageable){
        Page<Question> list = qservice.findAll(pageable);
        ModelAndView mv = new ModelAndView("question/questionList");
        mv.addObject("questionList", list);
        return mv;
    }

    @RequestMapping("/questions/tag")
    public ModelAndView listTag(){
        List<String> list = qservice.findTag();
        ModelAndView mv = new ModelAndView("question/tagList");
        mv.addObject("tagList", list);
        return mv;
    }

    @RequestMapping("/questions/taglist/{tag}")
    public ModelAndView tagListQuestion(Pageable pageable, @PathVariable("tag") String tag){
        Page<Question> list = qservice.findTagAll(pageable, tag);
        ModelAndView mv = new ModelAndView("question/questionList");
        mv.addObject("questionList", list);
        return mv;
    }

    @RequestMapping("/questions/create")
    public ModelAndView createQuestion(){
        ModelAndView mv = new ModelAndView("question/questionCreate");

        return mv;
    }

    @PostMapping("/questions/write")
    public String writeQuestion(Question question){
        qservice.createQuestion(question);

        return "redirect:/questions/list";
    }

    @GetMapping("/questions/view/{oid}")
    public ModelAndView showQuestion(@PathVariable("oid") Long oid){
        ModelAndView mv = new ModelAndView("question/questionRead");
        Question question = qservice.readQuestion(oid);
        //Page<Comment> list = cservice.findAll(pageable,oid);
        List<Comment> list = cservice.findAll(oid);
        mv.addObject("Question", question);
        mv.addObject("CommentList", list);
        return mv;
    }

    @GetMapping("/questions/modify/{oid}")
    public ModelAndView modifyQuestion(@PathVariable("oid") Long oid){
        ModelAndView mv = new ModelAndView("question/questionModify");
        Question question = qservice.readQuestion(oid);
        mv.addObject("Question",question);
        return mv;
    }

    @PostMapping("/questions/modify/{oid}")
    public ModelAndView modifyQuestion(@PathVariable("oid") Long oid, Question question){
        ModelAndView mv = new ModelAndView("question/questionRead");
        qservice.updateQuestion(oid,question);
        Question tmp = qservice.readQuestion(oid);
        mv.addObject("Question",tmp);
        return mv;
    }

    @GetMapping("/questions/delete/{oid}")
    public String deleteQuestion(@PathVariable("oid") Long oid){
        qservice.deleteQuestion(oid);

        return "redirect:/questions/list";
    }

    @RequestMapping("/questions/answer")
    public ModelAndView answerQuestion(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }

    @RequestMapping("/questions/recommend")
    public ModelAndView recommend(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }

    @RequestMapping("/questions/bookmark")
    public ModelAndView bookmarkQuestion(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }
}
