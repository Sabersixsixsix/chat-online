package com.saber.chatonline.controller;

import com.saber.chatonline.pojo.Result;
import com.saber.chatonline.pojo.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        Result result = new Result();
//        System.out.println(user);
        if(user != null && "123".equals(user.getPassword())) {
            result.setFlag(true);
            session.setAttribute("user", user.getUserName());
        } else {
            result.setFlag(false);
            result.setMessage("用户名或密码错误");
        }
        return result;
    }

    @GetMapping("/getUserName")
    public String getUserName(HttpSession session) {
//        log.info("{}", HttpSession.class.getName());
        String username = (String) session.getAttribute("user");
//        log.info("{}", session.getAttribute("user"));
        return username;
    }
}
