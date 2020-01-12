package com.spring.codeplace.user.login.controller;


import com.spring.codeplace.user.Naver.NaverLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {

    @Autowired
    NaverLoginService naverLoginService;

    @RequestMapping(value = "/login")
    public String Login(Model model, HttpSession session) throws Exception {

        String naverAuthUrl = naverLoginService.getAuthorizationUrl(session);

        /* 생성한 인증 URL을 View로 전달 */
        model.addAttribute("naver_url", naverAuthUrl);

        /* 생성한 인증 URL을 Model에 담아서 전달 */
        return "member/login/login";

    }

    @RequestMapping(value = "/callback")
    public String naverCallback() throws IOException {

        System.out.println("naver login success");

        return "redirect:/questions/list";
    }
}
