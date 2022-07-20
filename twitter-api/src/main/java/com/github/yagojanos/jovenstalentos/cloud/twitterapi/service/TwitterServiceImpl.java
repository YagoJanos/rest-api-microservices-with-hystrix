package com.github.yagojanos.jovenstalentos.cloud.twitterapi.service;

import com.github.yagojanos.jovenstalentos.cloud.twitterapi.hystrix.CommandTwitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterServiceImpl implements TwitterService{

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${bearer.token}")
    private String bearerToken;

    @Override
    public String fetchTweetNumberByAccount(String account) {

        return new CommandTwitter(account, bearerToken, restTemplate).execute();
    }
}
