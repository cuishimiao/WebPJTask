package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.service.ReplyArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 16:01
 **/
@Controller
public class ReplyArticleController {
    @Autowired
    private ReplyArticleService articleService;

    @RequestMapping("/replyAll/{id}")
    @ResponseBody
    public List<ReplyArticle> findAllReply(@PathVariable int id){
        return articleService.findAllReply(id);
    }

    @RequestMapping("/getReply/{id}")
    @ResponseBody
    public Map<String,Object>getReply(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",articleService.getReply(id));
        return map;
    }

    @RequestMapping("/generateReply")
    @ResponseBody
    public String generateReply(@RequestBody ReplyArticle replyArticle){
        return articleService.generateArticle(replyArticle);
    }

    @RequestMapping("/deleteReply/{id}")
    @ResponseBody
    public String deleteReply(@PathVariable int id){
        return articleService.deleteReply(id);
    }

    @RequestMapping("/modifyReply")
    @ResponseBody
    public String modifyReply(@RequestBody ReplyArticle article){
        return articleService.modifyReply(article);
    }

    @RequestMapping("/showReplyById/{id}")
    public String showReplyById(@PathVariable int id , Model model){
        ReplyArticle reply = articleService.showReplyById(id);
        model.addAttribute("reply",reply);
        return "/user/showReply";
    }
}
