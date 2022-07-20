package com.github.yagojanos.jovenstalentos.cloud.githubapi.controller;

import com.github.yagojanos.jovenstalentos.cloud.githubapi.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/{account}")
    public String fetchRepositoryQuantityByAccount(@PathVariable("account") String account){
        return githubService.fetchRepositoryQuantityByAccount(account);
    }
}
