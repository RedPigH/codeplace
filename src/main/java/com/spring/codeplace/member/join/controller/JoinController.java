package com.spring.codeplace.member.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {

    @RequestMapping("/join")
    public String join() {
        return "/member/join/join";
    }

    @RequestMapping("/join_complete")
    public String joinComplete() {
        return "/member/join/join_complete";
    }
}
