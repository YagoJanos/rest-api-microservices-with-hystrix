package com.github.yagojanos.jovenstalentos.cloud.mainapi.service;

import com.github.yagojanos.jovenstalentos.cloud.mainapi.hystrix.CommandGithub;
import com.github.yagojanos.jovenstalentos.cloud.mainapi.hystrix.CommandTwitter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiConsumptionServiceImpl implements ApiConsumptionService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Map<String, String> fetchTweetAndRepoQuantities(String twitterAccount, String githubAccount) {

        HashMap<String, String> response = new HashMap<>();

        response.put("Number of tweets", new CommandTwitter(twitterAccount, restTemplate).execute());

        response.put("Number of repositories", new CommandGithub(githubAccount, restTemplate).execute());

        return response;
    }
}
