package com.stachnik.wojciech.artApp.service;

import com.stachnik.wojciech.artApp.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticle();

    Article getArticleById(int articleId);

    boolean addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticleById(int articleId);

}
