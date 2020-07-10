package com.bai.gmall.user.controller;

import com.bai.gmall.beans.UmsMember;
import com.bai.gmall.beans.UmsMemberReceiveAddress;
import com.bai.gmall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "index",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello user";
    }

    @RequestMapping(path = "getAllUser",method = RequestMethod.GET)
    @ResponseBody
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping(path = "getReceiveAddressByMemberId",method = RequestMethod.GET)
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
}
