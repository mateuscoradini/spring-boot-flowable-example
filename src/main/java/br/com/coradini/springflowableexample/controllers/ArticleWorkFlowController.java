package br.com.coradini.springflowableexample.controllers;


import br.com.coradini.springflowableexample.domain.Approval;
import br.com.coradini.springflowableexample.domain.Article;
import br.com.coradini.springflowableexample.services.ArticleWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleWorkFlowController {


    @Autowired
    private ArticleWorkflowService service;


    public ArticleWorkFlowController(ArticleWorkflowService articleWorkflowService) {
        this.service = articleWorkflowService;

    }

    @PostMapping("/submit")
    public void submit(@RequestBody Article article) {
        service.startProcess(article);
    }

    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam String assignee) {
        return service.getTasks(assignee);
    }

    @PostMapping("/review")
    public void review(@RequestBody Approval approval) {
        service.submitReview(approval);
    }
}
