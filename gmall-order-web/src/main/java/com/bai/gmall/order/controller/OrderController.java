package com.bai.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.annotations.LoginRequired;
import com.bai.gmall.services.CartService;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Reference
    CartService cartService;

    @RequestMapping("order")
    @LoginRequired(logSuccess = true)
    public String order(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap){
        String memberId = (String)request.getAttribute("memberId");
        String nickName = (String) request.getAttribute("nickName");

        //

        List<Object> list = cartService.cartList();
        return null;
    }
}
