package com.qhx.baobaotao.controller;

import com.qhx.baobaotao.domain.User;
import com.qhx.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by QIUHX on 2017/10/18.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService uesrService;

    @RequestMapping(value="/index.do")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.do")
    public ModelAndView loginCheck(HttpServletRequest request,
                                            String username,String password){
        boolean isVaildUser = uesrService.hasMatchUser(username,password);
        if(!isVaildUser){
            return new ModelAndView("login","error","用户名或密码错误！！！");
        }else{
            User user = uesrService.findUserByUserName(username);
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            uesrService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}

