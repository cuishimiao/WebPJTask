package ncu.edu.cn.bbs.controller;

//import jdk.nashorn.internal.ir.RuntimeNode;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.QuestionArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
<<<<<<< HEAD:bbs/src/main/java/ncu/edu/cn/bbs/controller/QuestionArticleController.java
public class QuestionArticleController {
=======

public class RequestArticleController {
>>>>>>> ccc5c9fdc9bb7b9f803fdb6e8545692c1eef759c:bbs/src/main/java/ncu/edu/cn/bbs/controller/RequestArticleController.java
    @Autowired
    private QuestionArticleService articleService;

    @RequestMapping("/generateRequest")
    public String generate(@RequestBody Question article) throws  IOException {
         articleService.generateRequest(article);

         return "/main";

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
}
