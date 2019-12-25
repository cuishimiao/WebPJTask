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

    /*
     * @param: [id]
     * @return: java.util.List<ncu.edu.cn.bbs.entity.ReplyArticle>
     * @description:根据用户id查看用户所有的回复
     */
    @RequestMapping("/replyAll/{id}")
    @ResponseBody
    public List<ReplyArticle> findAllReply(@PathVariable int id){
        return articleService.findAllReply(id);
    }

    /*
     * @param: [id]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @description:根据回复的id得到回复文章对象
     */
    @RequestMapping("/getReply/{id}")
    @ResponseBody
    public Map<String,Object>getReply(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",articleService.getReply(id));
        return map;
    }

    //生成一个回复
    @RequestMapping("/generateReply")
    @ResponseBody
    public String generateReply(@RequestBody ReplyArticle replyArticle){
        return articleService.generateArticle(replyArticle);
    }

    //删除一个回复
    @RequestMapping("/deleteReply/{id}")
    @ResponseBody
    public String deleteReply(@PathVariable int id){
        return articleService.deleteReply(id);
    }

    //修改回复
    @RequestMapping("/modifyReply")
    @ResponseBody
    public String modifyReply(@RequestBody ReplyArticle article){
        return articleService.modifyReply(article);
    }

    //根据id得到一个回复
    @RequestMapping("/showReplyById/{id}")
    public String showReplyById(@PathVariable int id , Model model){
        ReplyArticle reply = articleService.showReplyById(id);
        model.addAttribute("reply",reply);
        return "/user/showReply";
    }
}
