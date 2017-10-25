package com.qhx.baobaotao.test;

import com.qhx.baobaotao.domain.User;
import com.qhx.baobaotao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by QIUHX on 2017/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/spring/applicationContext.xml")
public class BaobaotaoTest {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","1111");
        System.out.print(b1+""+b2);
    }


    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        System.out.println(user);
    }
}
