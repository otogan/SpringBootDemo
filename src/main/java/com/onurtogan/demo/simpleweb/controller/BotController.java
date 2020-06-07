package com.onurtogan.demo.simpleweb.controller;

import com.onurtogan.demo.simpleweb.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BotController {

    @PostMapping(value = "/greet", consumes = "application/json")
    public String greet(@RequestBody UserInfo userInfo) {
        if (userInfo.isEnabled()) {
            return String.format("Hello! Nice to see you, %s!", userInfo.getName());
        } else return String.format("Hello! Nice to see you, %s! Your account is disabled.", userInfo.getName());
    }

    @PostMapping(value = "/greets", consumes = "application/json")
    public String greets(@RequestBody List<UserInfo> userInfoList) {
        // logging out users
        return String.format("OK, %d of users have been logged out!", userInfoList.size());
    }
}
