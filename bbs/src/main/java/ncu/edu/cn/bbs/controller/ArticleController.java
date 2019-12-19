package ncu.edu.cn.bbs.controller;


import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import sun.text.normalizer.NormalizerBase;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    ArticleService service;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/articles")
    @ResponseBody
    public List<Article> findAll(){
        return service.findAll();
    }

    @RequestMapping("/getArticle/{id}")
    public String getArticle(@PathVariable int id, Model m){
        m.addAttribute("msg",service.getArticle(id));
        return "article";
    }


    @RequestMapping("/articles/{uid}")
    @ResponseBody
    public List<Article> finaAllByUid(@PathVariable int uid){
        return service.findAllByUid(uid);
    }


    //写文章
    @RequestMapping("/writeArticle")
    @ResponseBody
    public String write(@RequestBody Article article){


        String msg;
        if(article.getTitle()==null || article.getTitle().equals(""))
        {

           msg="文章标题不能为空";
           return msg;
        }
        if (article.getContent()==null || article.getContent().equals(""))
        {
            msg="文章内容不能为空";
            return msg;
        }

         msg = service.generateArticle(article);
        return msg;
    }




    @RequestMapping("/publish")
    public String publish(HttpSession session,Model model)
    {

        if(session.getAttribute("user")!=null)
        {
            model.addAttribute("user",session.getAttribute("user"));

            List<Category> allCategory = categoryService.findAllCategory();
            model.addAttribute("tags",allCategory);
            return "publish";
        }
        else
        {
            model.addAttribute("error","请先登录");
            return "/index";
        }

    }

    //跳到发问题界面
    @RequestMapping("/ask")
    public  String ask(HttpSession session, Model m)
    {
        if(session.getAttribute("user")!=null)
        {
            m.addAttribute("user",session.getAttribute("user"));

            return "question";
        }
        else
        {
            m.addAttribute("error","请先登录");
            return "/index";
        }
    }


    @RequestMapping("/deleteArticleById/{id}")
    @ResponseBody
    public String delete(@PathVariable int id){
        return service.deleteArticle(id);
    }

    @RequestMapping("/modifyArt")
    @ResponseBody
    public String modify(@RequestBody Article article){
        return service.modifyArticle(article);
    }

    @RequestMapping("/showArticle/{article_id}")
    public String publish(@PathVariable int article_id,Model model){
        Article article = service.getArticle(article_id);
        model.addAttribute("article",article);
        return "/user/showArticle";
    }

    @RequestMapping("/modifyArticle/{article_id}")
    public String modifyArticle(@PathVariable int article_id, Model model){
        Article article = service.getArticle(article_id);
        model.addAttribute("article",article);
        return "/user/modifyArticle";
    }
}
