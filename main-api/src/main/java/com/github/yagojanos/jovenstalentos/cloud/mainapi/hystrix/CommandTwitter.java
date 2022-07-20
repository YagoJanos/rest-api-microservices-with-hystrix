package com.github.yagojanos.jovenstalentos.cloud.mainapi.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class CommandTwitter extends HystrixCommand<String> {

    private String account;

    private RestTemplate restTemplate;

    public CommandTwitter(String account, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("Main-Twitter"));
        this.account = account;
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {

        RequestEntity<Object> twitterRequest = new RequestEntity<>(
                null, HttpMethod.GET, URI.create("http://localhost:8081/twitter/" + account));

        return restTemplate.exchange(twitterRequest, String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "Couldn't find";
    }
}
