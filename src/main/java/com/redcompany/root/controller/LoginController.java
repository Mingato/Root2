package com.redcompany.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/oauth-login")
    public String getLoginPage(Model model) {

        return "redirect:/oauth2/authorization/wso2";
    }
}
