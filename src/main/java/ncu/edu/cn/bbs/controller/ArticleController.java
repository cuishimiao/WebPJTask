package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    ArticleService service;




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


    @RequestMapping("/writeArticle")
    public ModelAndView write(@RequestBody Article article, ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("article",service.generateArticle(article));
        return modelAndView;

    }

    @RequestMapping("/publish")
    public String publish(HttpSession session,Model m)
    {
        m.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY));
        return "publish";
    }

    //跳到发问题界面
    @RequestMapping("/ask")
    public  String ask(HttpSession session, Model m)
    {
        m.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY));
        return "question";
    }


    @RequestMapping("/deleteArticle")
    @ResponseBody
    public String delete(int id){
        return service.deleteArticle(id);
    }

    @RequestMapping("/modifyArticle")
    @ResponseBody
    public String modify(@RequestBody Article article){
        return service.modifyArticle(article);
    }





}
