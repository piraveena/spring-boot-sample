package com.example.wso2.oidc.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String currentUserName(Model model, Authentication authentication) {

        DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
        System.out.println(userDetails);
        model.addAttribute("userName", userDetails.getName());
        return "index";
    }

    @GetMapping("/userinfo")
    public String getUser(Authentication authentication, Model model) {

        DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
        String username = userDetails.getName();
        System.out.println("userName" + userDetails.getName());
        model.addAttribute("userName", userDetails.getName());

        model.addAttribute("idtoken", userDetails.getClaims());
        System.out.println("idtoken" + userDetails);
        return "userinfo";
    }
}


