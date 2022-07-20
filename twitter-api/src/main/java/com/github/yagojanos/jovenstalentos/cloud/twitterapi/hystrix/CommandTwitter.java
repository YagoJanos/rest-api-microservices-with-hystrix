package com.github.yagojanos.jovenstalentos.cloud.twitterapi.hystrix;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class CommandTwitter extends HystrixCommand<String> {

    private String account;

    private String token;

    private RestTemplate restTemplate;

    public CommandTwitter(String account, String token, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("Twitter"));
        this.account = account;
        this.token = token;
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception{

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + token);
        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create("https://api.twitter.com/2/tweets/counts/recent?query=from%3A" + account));

        return restTemplate.exchange(request, ObjectNode.class).getBody().get("meta").get("total_tweet_count").asText();
    }

    @Override
    protected String getFallback(){
        return "Couldn't find";
    }
}
