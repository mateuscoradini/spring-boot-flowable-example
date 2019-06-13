package br.com.coradini.flowable.example.controllers;

import br.com.coradini.flowable.example.models.Approval;
import br.com.coradini.flowable.example.models.Article;
import br.com.coradini.flowable.example.services.ArticleWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleWorkFlowController {

    private final ArticleWorkFlowService service;

    @Autowired
    public ArticleWorkFlowController(ArticleWorkFlowService service) {
        this.service = service;
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