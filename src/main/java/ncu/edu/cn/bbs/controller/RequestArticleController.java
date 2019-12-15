package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    //发布问题之后跳转的页面
    @RequestMapping("/generateRequest")
    public ModelAndView generate(@RequestBody Question article,ModelAndView modelAndView){

        modelAndView.setViewName("index");
        modelAndView.addObject("article",articleService.generateRequest(article));
        return modelAndView;


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
