package com.github.yagojanos.jovenstalentos.cloud.githubapi.hystrix;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class CommandGithub extends HystrixCommand<String> {

    private String account;

    private RestTemplate restTemplate;

    public CommandGithub(String account, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("Github"));
        this.account = account;
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {

        RequestEntity<Object> request = new RequestEntity<>(
                null, HttpMethod.GET, URI.create("https://api.github.com/users/" + account));

        return restTemplate.exchange(request, ObjectNode.class).getBody().get("public_repos").asText();
    }

    @Override
    protected String getFallback() {
        return "Couldn't find";
    }
}
