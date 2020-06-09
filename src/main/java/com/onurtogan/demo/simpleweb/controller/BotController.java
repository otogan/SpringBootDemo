package com.onurtogan.demo.simpleweb.controller;

import com.onurtogan.demo.simpleweb.model.Greeting;
import com.onurtogan.demo.simpleweb.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BotController {

    private static final String GREETING_TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

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

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(GREETING_TEMPLATE, name));
    }
}
