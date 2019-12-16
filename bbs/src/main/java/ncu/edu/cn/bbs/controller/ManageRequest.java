package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.QuestionArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManageRequest {

    @Autowired
    private QuestionArticleService articleService;

    @RequestMapping("/Requests")
    public String findAll(Model m){
        List<Question> all = articleService.findAllr();
        m.addAttribute("msg",all);
        return "admin/managequestion";
    }

<<<<<<< HEAD
    @RequestMapping("/deleteRequest/{id}")
    public String delete(@PathVariable int id){
        articleService.deleteByUid(id);
=======
    @RequestMapping("/deleteRequest/{question_id}")
    public String delete(@PathVariable int question_id){
        articleService.deleteby(question_id);
>>>>>>> ccc5c9fdc9bb7b9f803fdb6e8545692c1eef759c
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
