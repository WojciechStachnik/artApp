package com.stachnik.wojciech.artApp.dao;

import com.stachnik.wojciech.artApp.model.Article;

import java.util.List;

public interface IArticleDAO {
    List<Article> getAllArticle();

    //get article using Id
    Article getArticleById(int articleId);

    //add article
    void addArticle(Article article);

    //update article
    void updateArticle(Article article);

    //delete
    void deleteArticleById(int articleId);

    //ifExists
    boolean ifExists(String title, String category);
}
