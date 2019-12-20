package ncu.edu.cn.bbs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@Controller
public class UserMainController {
    @RequestMapping("/main")
    public String showMain(Model model, HttpSession session){
        if(session.getAttribute("user")!=null){
            return "main";
        }
        else
            return "/";
    }

    @RequestMapping("/center")
    public String showCenter(Model model,HttpSession session){
        if(session.getAttribute("user")!=null){
                return "center";
        }
        else{
            return "/";
        }

    }

    @RequestMapping("/manage/articles")
    public String showArticle()
    {
        return "/manage/articles";
    }

    @RequestMapping("/manage/comments")
    public String showCategory()
    {
        return "/manage/comments";
    }


}
