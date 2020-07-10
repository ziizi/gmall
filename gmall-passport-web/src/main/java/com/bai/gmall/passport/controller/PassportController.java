package com.bai.gmall.passport.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PassportController {

    @RequestMapping("login")
    @ResponseBody
    public String login() {



        return "token";
    }


    @RequestMapping("index")
    public String index(String returnUrl, ModelMap modelMap) {
        modelMap.put("returnUrl",returnUrl);
        return "index";
    }


    @RequestMapping("verify")
    public String verify(String token) {
        // 通过jwt检验真假

        return "success";
    }
}
