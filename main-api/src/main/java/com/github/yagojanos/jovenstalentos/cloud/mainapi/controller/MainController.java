package com.github.yagojanos.jovenstalentos.cloud.mainapi.controller;

import com.github.yagojanos.jovenstalentos.cloud.mainapi.service.ApiConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pubcounter")
public class MainController {

    @Autowired
    private ApiConsumptionService apiConsumptionService;

    @GetMapping("/accounts")
    public Map<String, String> fetchTweetAndRepoQuantities(@RequestParam(value = "twitter", required = false) String twitterAccount, @RequestParam(value = "github", required = false) String githubAccount){

        return apiConsumptionService.fetchTweetAndRepoQuantities(twitterAccount, githubAccount);
    }
}
