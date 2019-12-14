package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.service.ReplyArticleService;
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
 * @Date:Createed in 2019/12/10 16:01
 **/
@RestController
public class ReplyArticleController {
    @Autowired
    private ReplyArticleService articleService;

    @RequestMapping("/replyAll/{id}")
    public List<ReplyArticle> findAllReply(@PathVariable int id){
        return articleService.findAllReply(id);
    }

    @RequestMapping("/getReply/{id}")
    public Map<String,Object>getReply(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",articleService.getReply(id));
        return map;
    }

    @RequestMapping("/generateReply")
    public String generateReply(@RequestBody ReplyArticle replyArticle){
        return articleService.generateArticle(replyArticle);
    }

    @RequestMapping("/deleteReply/{id}")
    public String deleteReply(@PathVariable int id){
        return articleService.deleteReply(id);
    }

    @RequestMapping("/modifyReply")
    public String modifyReply(@RequestBody ReplyArticle article){
        return articleService.modifyReply(article);
    }

}
