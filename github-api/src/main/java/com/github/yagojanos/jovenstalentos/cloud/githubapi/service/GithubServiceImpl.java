package com.github.yagojanos.jovenstalentos.cloud.githubapi.service;


import com.github.yagojanos.jovenstalentos.cloud.githubapi.hystrix.CommandGithub;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubServiceImpl implements GithubService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String fetchRepositoryQuantityByAccount(String account) {

        return new CommandGithub(account, restTemplate).execute();
    }
}
