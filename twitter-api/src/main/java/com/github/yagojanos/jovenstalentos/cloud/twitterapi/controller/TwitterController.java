package com.github.yagojanos.jovenstalentos.cloud.twitterapi.controller;

import com.github.yagojanos.jovenstalentos.cloud.twitterapi.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("/{account}")
    public String fetchTweetNumberByAccount(@PathVariable("account") String account){
        return twitterService.fetchTweetNumberByAccount(account);
    }
}
