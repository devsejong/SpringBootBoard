package com.example.article.service;

import com.example.article.dto.ArticleDTO;
import com.example.article.model.Article;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    public void 게시물생성하기(){

        //1. given
        Article article = articleService.create(new ArticleDTO("title", "content", "pw", "autor"));

        //2. when
        List<Article> articles = articleService.findAll();

        //3. then
        Assert.assertEquals(articles.get(0).getTitle(), "title");
    }

    @Test
    public void 게시물_제목으로_조회하기(){
        //1. given
        Article article = articleService.create(new ArticleDTO("title", "content", "pw", "autor"));

        //2. when
        List<Article> results = articleService.findByTitle(new ArticleDTO("title", null, null, null));

        //3. then
    }

    @Ignore
    @Test
    public void 게시물_삭제하기(){

    }

}
