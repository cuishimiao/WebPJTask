package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.dao.QuestionDto;
import ncu.edu.cn.bbs.dao.QuestionMapper;
import ncu.edu.cn.bbs.dao.Userdao1;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.entity.User;
import ncu.edu.cn.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    Userdao1 userdao;


    @RequestMapping(value = {"","/index"})
    public String showPage(Model model){
        List<Article> goodArticles=articleMapper.findGoodArticle();
        model.addAttribute("goodArticles",goodArticles);

        List<QuestionDto> questionDtos=new ArrayList<>();
        List<Question> questions=questionMapper.findLeastQuestion();
        for (Question question : questions) {
            QuestionDto questionDto=new QuestionDto();
            User user=userdao.findById(question.getUid());
            questionDto.setQuestion(question);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        model.addAttribute("questionDtos",questionDtos);

        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user,HttpSession session) {
        Map<String,Object>map = new HashMap<>();
        User temp = service.findByName(user);
        if(temp !=null){
            if(service.validate(user)>0){
                map.put("msg",temp);
                session.setAttribute("user",temp);
                session.setAttribute("curuser",temp);
                return map;
            }
            else{
                map.put("msg","密码错误") ;
                return map;
            }
        }
        else{
            map.put("msg","用户不存在") ;
            return map;
        }
    }
    @RequestMapping("/register")
    public String showRegister(){
        return "register";
    }

    @RequestMapping("/reg")
    @ResponseBody
    public String register(@RequestBody User user){
        if(user.getUsername()==null || user.getUsername().equals("")){
            return "用户名不能为空";
        }
        if(user.getPassword()==null || user.getPassword().equals("")){
            return "密码不能为空";
        }
        User temp = service.findByName(user);
        if(temp != null){
            return "用户名已存在";
        }
        else{
            int count = service.addUser(user);
            if(count == 1){
                return "注册成功";
            }
            else return "注册失败";
        }
    }

    /*
     * @param: [request]
     * @return: java.lang.String
     * @description:退出销毁session
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model){
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("curuser");
        return "/";
    }

    @RequestMapping("/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(@RequestBody User user){
        int temp = service.ModifyUserInfo(user);
        if(temp ==1){
            return "信息修改成功!";
        }
        else{
            return "信息修改失败!";
        }
    }

    @RequestMapping("/isLogin")
    @ResponseBody
    public Map<String,Object> isLogin(HttpSession session){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",session.getAttribute("user"));
        return map;
    }

    @RequestMapping("/modifyPassword")
    @ResponseBody
    public String modifyPassword(@RequestBody User user){
        if(service.modifyPassword(user)==1){
            return "密码修改成功!";
        }
        else{
            return "密码修改失败";
        }
    }

    @RequestMapping("/modifyEmail")
    @ResponseBody
    public String modifyEmail(@RequestParam String email,@RequestParam String uid){
        if(service.modifyEmail(email,uid)==1){
            return "邮箱修改成功!";
        }
        else{
            return "邮箱修改失败!";
        }
    }

    @RequestMapping("/chooseHead")
    public String chooseHead(@RequestBody User user,Model model,HttpSession session,HttpServletRequest request){
        service.modifyHead(user);
        User temp = service.findByName(user);
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("curuser");
        session.setAttribute("user",temp);
        session.setAttribute("curuser",temp);
        return "/center";
    }
}
