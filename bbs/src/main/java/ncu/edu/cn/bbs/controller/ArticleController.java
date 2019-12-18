package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import sun.text.normalizer.NormalizerBase;

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


    //写文章
    @RequestMapping("/writeArticle")
    @ResponseBody
    public String write(@RequestBody Article article){
        String msg;
        if(article.getTitle()==null || article.getTitle()=="")
        {

           msg="文章标题不能为空";
           return msg;
        }
        if (article.getContent()==null || article.getContent()=="")
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
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY)!=null)
        {
            model.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY));

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
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY)!=null)
        {
            m.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY));

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

    @RequestMapping("/modifyArticle")
    @ResponseBody
    public String modify(@RequestBody Article article){
        return service.modifyArticle(article);
    }


}
