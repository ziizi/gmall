package com.bai.gmall.cart.controller;

import com.bai.gmall.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    // 添加购物车逻辑
    @RequestMapping("addToCart")
    public String addToCart(String skuId, int quality, HttpServletRequest request,
                            HttpServletResponse response, HttpSession session){

        String cartListCookie = CookieUtil.getCookieValue(request, "cartListCookie", true);
        String memberid = "";

        // 判断用户没有登录
        if (true) {
            // 登录的用户之间更新数据和缓存

        }else {
            // 没有登录的用户直接更新cookie
            if (true) { // 存在cookie， 则更新数量或者新增

            }else { // 不存在cookie 直接新增

            }

            // 设置cookie
            CookieUtil.setCookie(request,response,"cartListCookie",null,72*36,true);
        }


        return "";
    }
}
