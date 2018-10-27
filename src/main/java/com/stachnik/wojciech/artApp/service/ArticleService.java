package com.stachnik.wojciech.artApp.service;

import com.stachnik.wojciech.artApp.dao.IArticleDAO;
import com.stachnik.wojciech.artApp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDAO iArticleDAO;

    @Override
    public List<Article> getAllArticle(){
        return iArticleDAO.getAllArticle();
    }

    @Override
    public Article getArticleById(int articleId){
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public boolean addArticle(Article article){
        if (iArticleDAO.ifExists(article.getTitle(), article.getCategory())){
            return false;
        }else {
            iArticleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article){
        iArticleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticleById(int articleId){
        iArticleDAO.deleteArticleById(articleId);
    }

}
