package com.spring.codeplace.admin.service;

import com.spring.codeplace.admin.pageMaker.PageMaker;
import com.spring.codeplace.user.Entity.User;
import com.spring.codeplace.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private PageMakerService pageMakerService;

    /* 모든 유저 리스트 가져오는 서비스 */
    public String getUserList(int pageNum) {

        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 10, userRepository);
        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "oid");
        Page<User> userPage = userRepository.findAll(pageRequest);

        if(userPage.getSize() == 0){
            session.setAttribute("userList", new ArrayList<User>());
            session.setAttribute("pageMaker", pageMaker);
            return "/admin/userlist";
        }

        List<User> userList = userPage.getContent();
        session.setAttribute("userList", userList);
        session.setAttribute("pageMaker", pageMaker);
        return "/admin/userlist";
    }

    /* 블랙 리스트 가져오는 서비스 */
    public String getBlackList(int pageNum){

        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "oid");
        Page<User> userPage = userRepository.findByReportcntGreaterThanEqual(pageRequest, 10L);
        PageMaker pageMaker = pageMakerService.generateCustomPageMaker(pageNum, 10, userPage.getTotalElements());

        if(userPage.getSize() == 0){
            session.setAttribute("blackList", new ArrayList<User>());
            session.setAttribute("pageMaker", pageMaker);
            return "/admin/blacklist";
        }

        List<User> blackList = userPage.getContent();
        session.setAttribute("blackList", blackList);
        session.setAttribute("pageMaker", pageMaker);
        return "/admin/blacklist";

    }

    /* 유저 정보 가져오는 서비스 */
    public String getUserInfo(String strOid) {
        long oid = Long.parseLong(strOid);
        User user = userRepository.findByOid(oid);

        if(user == null){
            return "/admin/userlist";
        }

        session.setAttribute("user", user);
        return "/admin/userinfo";
    }

    /* 유저 정보 검색하는 서비스 */
    public String searchUser(int pageNum, String accountPart) {
        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "oid");
        String inputAccount = "%"+accountPart+"%";
        Page<User> userPage = userRepository.findByAccountLike(pageRequest, inputAccount);
        PageMaker pageMaker = pageMakerService.generateCustomPageMaker(pageNum, 10, userPage.getTotalElements());

        if(userPage.getSize() == 0){
            session.setAttribute("searchList", new ArrayList<User>());
            session.setAttribute("pageMaker", pageMaker);
            session.setAttribute("accountPart", accountPart);
            return "admin/usersearch";
        }

        List<User> usersList = userPage.getContent();
        session.setAttribute("searchList", usersList);
        session.setAttribute("pageMaker", pageMaker);
        session.setAttribute("accountPart", accountPart);

        return "admin/usersearch";
    }
}
