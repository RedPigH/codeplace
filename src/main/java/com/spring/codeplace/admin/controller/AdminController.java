package com.spring.codeplace.admin.controller;

import com.spring.codeplace.admin.service.AdminOpinionService;
import com.spring.codeplace.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminOpinionService adminOpinionService;

    private int returnIntValue(String stringToInt) {
        return Integer.parseInt(stringToInt);
    }


    @GetMapping("/adminUserList")   //모든 유저 리스트 페이지
    public String adminUserList(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {

        String page = adminUserService.getUserList(returnIntValue(pageNum));
        return page;
    }

    @GetMapping("/adminBlackList")  //블랙 리스트 페이지
    public String adminBlackList(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {

        String page = adminUserService.getBlackList(returnIntValue(pageNum));
        return page;
    }

    @GetMapping("/adminUserInfo")
    public String adminUserInfo(@RequestParam(value = "oid") String oid) {

        String page = adminUserService.getUserInfo(oid);
        return page;
    }

    @GetMapping("/adminUserSearch")
    public String adminUserSearch(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
                                  @RequestParam(value = "accountPart", defaultValue = "thisisnonexistentid") String accountPart) {

        String page = adminUserService.searchUser(returnIntValue(pageNum), accountPart);
        return page;
    }

    @GetMapping("/adminOpinionList")
    public String adminOpinionList(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum){

        String page = adminOpinionService.getOpinionList(returnIntValue(pageNum));
        return page;
    }

    @GetMapping("/adminOpinionInfo")
    public String adminOpinionInfo(@RequestParam(value = "oid") String oid){

        String page = adminOpinionService.getOpinionInfo(oid);
        return page;
    }
}