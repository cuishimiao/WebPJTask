package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/generateRequest")
    public String generate(@RequestBody Question article){
        return articleService.generateRequest(article);
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
