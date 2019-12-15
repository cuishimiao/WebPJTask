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


    @RequestMapping("/manage")

    public String manage()
    {
        return "/admin/manage";
    }

}
