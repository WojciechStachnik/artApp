package com.stachnik.wojciech.artApp.dao;

import com.stachnik.wojciech.artApp.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class  ArticleDAO implements  IArticleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticle(){
        String hgl = "FROM Article as atc1 ORDER BY atcl.articleId";
        return entityManager.createQuery(hgl).getResultList();
    }

    public Article getArticleById(int articleId){
        return  entityManager.find(Article.class, articleId);
    }

    public void addArticle(Article article){
        entityManager.persist(article);
    }

    public void updateArticle(Article article){
        Article artc1 = getArticleById(article.getArticleId());
        artc1.setTitle(article.getTitle());
        artc1.setCategory(article.getCategory());
    }

    public void deleteArticleById(int articleId){
        entityManager.remove(getArticleById(articleId));
    }

    public boolean ifExists(String title, String category){
        String hgl = "FROM Article as atc1 WHERE atc1.title = ? and atc1.category = ?";
        int count = entityManager.createQuery(hgl).setParameter(1, title).setParameter(2,category).getResultList().size();
        return count > 0 ? true : false;
    }
}
