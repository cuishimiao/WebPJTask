package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserMainController {
    @RequestMapping("/main")
    public String showMain(Model model, HttpSession session){
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY )!=null){
            model.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY) );
            return "main";
        }
        else
            return "/";
    }
<<<<<<< HEAD
    @RequestMapping("/center")
    public String showCenter(Model model,HttpSession session){
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY)!=null){
            model.addAttribute("user",session.getAttribute(ConstantUtils.USER_SESSION_KEY));
            return "center";
        }
        else{
            return "/";
        }

    }
=======
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


>>>>>>> de449c133c4d8271a54c307c1bfa65bac21d6e80
}
