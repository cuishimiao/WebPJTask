package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArticleDetailController {
//    @Autowired
    @Resource
    private ArticleMapper articleMapper;
    boolean flag=true;

    @GetMapping("/Articledetail/{id}")
    public String articledetail(@PathVariable(name="id") Integer id, Model model){
        Article article = articleMapper.getArticleById(id);
        //累加阅读数
        System.out.println(article.toString());
        articleMapper.plusbyid(id);
        Integer uid=article.getUid();
        List<Article> hisArticles=articleMapper.getAllHisArticle(uid);
        model.addAttribute("article",article);
        model.addAttribute("hisArticles",hisArticles);
        return "articledetail";
    }

    @GetMapping("/Articlelike/{id}")
    public String Articlelike(@PathVariable(name="id") Integer id, Model model){
        //增加喜欢数
        Article article = articleMapper.getArticleById(id);
        if(flag) {
            articleMapper.pluslike(id);
            flag=false;
        }
        model.addAttribute("article",article);
        return "articledetail";
    }
}
