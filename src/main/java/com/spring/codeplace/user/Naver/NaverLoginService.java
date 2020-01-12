package com.spring.codeplace.user.Naver;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;

@AllArgsConstructor
@Service
public class NaverLoginService {

    private final static String CLIENT_ID = "0b16Yb9dgkG6JzCRFIot";
    private final static String CLIENT_SECRET = "qZz2voGc7_";
    private final static String REDIRECT_URI = "http://localhost:8080/callback";

    public String generateState()
    {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    /* 네아로 인증  URL 생성  Method */
    public String getAuthorizationUrl(HttpSession session) {

        String state = generateState();
        session.setAttribute("state", state);

        /* Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 네아로 인증 URL 생성 */
        OAuth20Service oauthService = new ServiceBuilder(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state)
                .build(NaverLoginAPI.instance());

        return oauthService.getAuthorizationUrl();
    }
}
