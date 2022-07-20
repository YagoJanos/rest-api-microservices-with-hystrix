package com.github.yagojanos.jovenstalentos.cloud.mainapi.service;

import java.util.Map;

public interface ApiConsumptionService {
    Map<String, String> fetchTweetAndRepoQuantities(String twitterAccount, String githubAccount);
}
