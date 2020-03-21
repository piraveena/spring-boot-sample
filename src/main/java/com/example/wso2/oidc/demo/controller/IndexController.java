package com.example.wso2.oidc.demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getUserName(Model model, OAuth2AuthenticationToken token) {
        model.addAttribute("userName", token.getName());
        model.addAttribute("country", token.getPrincipal().getAttribute("country"));
        model.addAttribute("email", token.getPrincipal().getAttribute("email"));
        return "index" ;
    }
}

