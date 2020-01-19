package com.spring.codeplace.admin.service;

import com.spring.codeplace.admin.pageMaker.PageMaker;
import com.spring.codeplace.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PageMakerService {
    public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<User, Long> repository){
        PageMaker pageMaker = new PageMaker();

        int totalCount = (int) repository.count();
        pageMaker.setTotalCount(totalCount);    //전체 게시글 수를 지정한다.
        pageMaker.setPageNum(pageNum -1);   //현재 페이지를 페이지 객체에 지정한다. -1을 해야 쿼리에서 사용할 수 있다.
        pageMaker.setContentNum(contentNum);    //현재 페이지에 몇개의 게시글을 보여줄지 지정한다.
        pageMaker.setCurrentBlock(pageNum); //현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
        pageMaker.setLastblock(pageMaker.getTotalCount());  //마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
        pageMaker.prevNext(pageNum);    //현재 페이지 번호로 화살표를 나타낼지 정한다.
        pageMaker.setStartPage(pageMaker.getCurrentBlock());    //시작 페이지를 페이지 블록 번호로 정한다.
        pageMaker.setEndPage(pageMaker.getLastBlock(), pageMaker.getCurrentBlock()); //마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.
        pageMaker.setCountlist(pageMaker.getStartPage(), pageMaker.getEndPage());

        return pageMaker;
    }

    public PageMaker generateCustomPageMaker(int pageNum, int contentNum, long count){
        PageMaker pageMaker = new PageMaker();

        int totalCount = (int) count;
        pageMaker.setTotalCount(totalCount);    //전체 게시글 수를 지정한다.
        pageMaker.setPageNum(pageNum -1);   //현재 페이지를 페이지 객체에 지정한다. -1을 해야 쿼리에서 사용할 수 있다.
        pageMaker.setContentNum(contentNum);    //현재 페이지에 몇개의 게시글을 보여줄지 지정한다.
        pageMaker.setCurrentBlock(pageNum); //현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
        pageMaker.setLastblock(pageMaker.getTotalCount());  //마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
        pageMaker.prevNext(pageNum);    //현재 페이지 번호로 화살표를 나타낼지 정한다.
        pageMaker.setStartPage(pageMaker.getCurrentBlock());    //시작 페이지를 페이지 블록 번호로 정한다.
        pageMaker.setEndPage(pageMaker.getLastBlock(), pageMaker.getCurrentBlock()); //마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.
        pageMaker.setCountlist(pageMaker.getStartPage(), pageMaker.getEndPage());

        return pageMaker;
    }
}