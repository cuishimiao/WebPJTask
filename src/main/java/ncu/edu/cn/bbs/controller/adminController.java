package ncu.edu.cn.bbs.controller;


import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.service.ReplyArticleService;
import ncu.edu.cn.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {
    @Autowired
    ArticleService articleService;
    @Autowired
     ReplyArticleService replyArticleService;
    @Autowired
    UserService userServiceservice;


    @RequestMapping("/admin/manage")

    public String manage()
    {
        return "/admin/manage";
    }

    //跳转到文章管理界面
    @RequestMapping("/articles_manage")
    public String article_manage()
    {
        return "/admin/article_list";
    }
    //跳转到用户管理界面
    @RequestMapping("/qustion_manage")
    public  String question_manage()
    {
        return "/admin/question_list";
    }

    //跳转到用户管理界面
    @RequestMapping("/user_manage")
    public String user_manage()
    {
        return "/admin/user_list";
    }

}
