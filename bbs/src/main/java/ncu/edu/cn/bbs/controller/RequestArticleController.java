package ncu.edu.cn.bbs.controller;

//import jdk.nashorn.internal.ir.RuntimeNode;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@Controller
public class RequestArticleController {
    @Autowired
    private RequestArticleService articleService;

    /*
     * @param: [article]
     * @return: java.lang.String
     * @description:发布一个问题
     */
    @RequestMapping("/generateRequest")
    @ResponseBody
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

    /*
     * @param: [user_id]
     * @return: java.util.List<ncu.edu.cn.bbs.entity.Question>
     * @description:根据用户的id得到用户发布的所有问题
     */
    @RequestMapping("/findAllRequest/{user_id}")
    @ResponseBody
    public List<Question> findAll(@PathVariable int user_id){
        return articleService.findAllRequest(user_id);
    }

    /*
     * @param: [id]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @description:根据问题的id得到question对象
     */
    @RequestMapping("/getRequest/{id}")
    @ResponseBody
    public Map<String,Object>getRequest(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",articleService.getRequestArticle(id));
        return map;
    }

    /*
     * @param: [id]
     * @return: java.lang.String
     * @description:根据问题Id删除该问题
     */
    @RequestMapping("/deleteByQId/{id}")
    @ResponseBody
    public String deleteByQid(@PathVariable int id){
        return articleService.deleteByQId(id);
    }

    /*
     * @param: [id, model]
     * @return: java.lang.String
     * @description:根据问题的id查看问题（视图定位）
     */
    @RequestMapping("/showQuestion/{id}")
    public String showQuestion(@PathVariable int id ,Model model){
        Question question = articleService.getRequestArticle(id);
        model.addAttribute("request",question);
        return "user/showQuestion";
    }
}
