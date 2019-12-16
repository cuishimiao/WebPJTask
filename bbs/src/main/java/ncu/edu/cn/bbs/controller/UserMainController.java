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

=======
>>>>>>> d887ef3a5373dce7961155f19393f9827d27b6b5
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
<<<<<<< HEAD

    @RequestMapping("/manage/articles")
    public String showArticle()
    {
        return "/manage/articles";
    }
=======
>>>>>>> d887ef3a5373dce7961155f19393f9827d27b6b5

    @RequestMapping("/manage/comments")
    public String showCategory()
    {
        return "/manage/comments";
    }


<<<<<<< HEAD
=======

>>>>>>> d887ef3a5373dce7961155f19393f9827d27b6b5
}
