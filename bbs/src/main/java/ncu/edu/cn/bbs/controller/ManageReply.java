package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.service.ReplyArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageReply {

    @Autowired
    private ReplyArticleService articleService;

    @RequestMapping("/Replys")
    public String findAll(Model m){
        List<ReplyArticle> all = articleService.findAll();
        m.addAttribute("msg",all);
        return "admin/managecomment";
    }

    @RequestMapping("/deleteRep/{id}")
    public String delete(@PathVariable int id){
        articleService.deleteReply(id);
        return "redirect:/Replys";
    }

    @GetMapping("/findAllBycom")
    public String findAllBycom(String searchname,Model m){
        Integer i = null;
        if(!searchname.isEmpty()){
            try {
                i=Integer.parseInt(searchname);
            }
            catch (NumberFormatException e) {
                i=-1;
            }
            System.out.println(i);
        }
        else
            return "redirect:/Replys";
        List<ReplyArticle> replys = articleService.findAllReply(i);
        m.addAttribute("searchname",searchname);
        m.addAttribute("msg",replys);
        return "admin/managecomment";
    }

}
