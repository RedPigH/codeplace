package com.spring.codeplace.admin.service;

import com.spring.codeplace.admin.entity.Opinion;
import com.spring.codeplace.admin.pageMaker.PageMaker;
import com.spring.codeplace.admin.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminOpinionService {
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private PageMakerService pageMakerService;


    public String getOpinionList(int pageNum) {

        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "oid");
        Page<Opinion> opinionPage = opinionRepository.findAll(pageRequest);
        PageMaker pageMaker = pageMakerService.generateCustomPageMaker(pageNum, 10, opinionPage.getTotalElements());

        if(opinionPage.getSize() == 0){
            session.setAttribute("opinionList", new ArrayList<Opinion>());
            session.setAttribute("pageMaker", pageMaker);
            return "admin/opinionlist";
        }

        List<Opinion> opinionList = opinionPage.getContent();
        session.setAttribute("opinionList", opinionList);
        session.setAttribute("pageMaker", pageMaker);
        return "admin/opinionlist";
    }

    public String getOpinionInfo(String strOid) {

        Long oid = Long.parseLong(strOid);
        Opinion opinion = opinionRepository.findByOid(oid);

        if(opinion == null){
            return "/admin/opinionlist";
        }

        session.setAttribute("opinion", opinion);
        return "admin/opinioninfo";
    }

}
