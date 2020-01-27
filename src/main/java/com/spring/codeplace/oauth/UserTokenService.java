//package com.spring.codeplace.oauth;
//
//import com.spring.codeplace.enums.SocialType;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//
//public class UserTokenService extends UserInfoTokenServices {
//
//    public UserInfoTokenServices(ClientResources resources, SocialType socialType){
//        super(resources.getResource().getUserInfoUri(), resources.getClient().getClientId());
//        setAuthoritiesExtractor(new OAuth2AuthoritiesEx);
//    }
//}
