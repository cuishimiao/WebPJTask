package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArticleDetailController {
    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/Articledetail/{id}")
    public String articledetail(@PathVariable(name="id") Integer id, Model model){
        Article article = articleMapper.getArticleById(id);
        //累加阅读数
        articleMapper.plusbyid(id);
        Integer uid=article.getUid();
        List<Article> hisArticles=articleMapper.getAllHisArticle(uid);
        System.out.println(article.toString()+"------------------");
        for (Article hisArticle : hisArticles) {
            System.out.println(hisArticle.toString()+"---------------------------------------");
        }
        model.addAttribute("article",article);
        model.addAttribute("hisArticles",hisArticles);
        return "articledetail";
    }
}
