package ncu.edu.cn.bbs.controller;

//import jdk.nashorn.internal.ir.RuntimeNode;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 17:34
 **/
@RestController

public class RequestArticleController {
    @Autowired
    private RequestArticleService articleService;

    //发问题
    @RequestMapping("/generateRequest")
    public String generate(@RequestBody Question article) throws  IOException {

        if(article.getQuestion_title()==null || article.getQuestion_title()=="")
        {
            return "问题标题不能为空";
        }
        if(article.getContent()==null || article.getContent()=="")
        {

            return "文章内容不能为空";
        }
        String msg = articleService.generateRequest(article);
        return msg;

    }

    @RequestMapping("/findAllRequest/{user_id}")
    public List<Question> findAll(@PathVariable int user_id){
        return articleService.findAllRequest(user_id);
    }

    @RequestMapping("/getRequest/{id}")
    public Map<String,Object>getRequest(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",articleService.getRequestArticle(id));
        return map;
    }
    
    @RequestMapping("/deleteByQId/{id}")
    public String deleteByQid(@PathVariable int id){
        return articleService.deleteByQId(id);
    }


    @RequestMapping("/showQuestion/{id}")
    public String showQuestion(@PathVariable int id ,Model model){
        Question question = articleService.getRequestArticle(id);
        model.addAttribute("request",question);
        return "user/showQuestion";
    }
}
