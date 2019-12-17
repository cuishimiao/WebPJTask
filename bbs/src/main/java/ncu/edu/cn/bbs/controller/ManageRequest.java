package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
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
public class ManageRequest {

    @Autowired
    private RequestArticleService articleService;

//    @RequestMapping("/Requests")
//    public String findAll(Model m){
//        List<Question> all = articleService.findAllr();
//        m.addAttribute("msg",all);
//        return "admin/managequestion";
//    }

    @RequestMapping("/deleteRequest/{id}")
    public String delete(@PathVariable int id){
        articleService.deleteby(id);
        return "redirect:/Requests";
    }

    @GetMapping("/findAllByque")
    public String findAllByque(String searchname,Model m){
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
            return "redirect:/Requests";
        List<Question> articles = articleService.findAllRequest(i);
        m.addAttribute("searchname",searchname);
        m.addAttribute("msg",articles);
        return "admin/managequestion";
    }

}
