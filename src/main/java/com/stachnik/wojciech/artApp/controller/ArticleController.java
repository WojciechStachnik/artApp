package com.stachnik.wojciech.artApp.controller;

import com.stachnik.wojciech.artApp.model.Article;
import com.stachnik.wojciech.artApp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getAllArticles(){
        return articleService.getAllArticle();
    }

    @GetMapping("/articles/{id}")
    public Article  getArticleById(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @PostMapping("/articles")
    public void addArticle(@Valid @RequestBody Article article){
        articleService.addArticle(article);
    }

    @PutMapping("/notes/{id}")
    public void updateArticle(@PathVariable int id, @Valid @RequestBody Article article){
        articleService.updateArticle(article);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteArticleById(@PathVariable int id){
        articleService.deleteArticleById(id);
    }





}
