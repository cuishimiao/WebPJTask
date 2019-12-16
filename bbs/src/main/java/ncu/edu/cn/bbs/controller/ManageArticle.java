package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageArticle {
    @Autowired
    ArticleService service;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/manageart")
    public String findAll(Model m){
        System.out.println("测试");
        List<Article> all = service.findAll();
        m.addAttribute("msg",all);
        return "admin/managearticle";
    }

    @RequestMapping("/managegetArt/{id}")
    public String getArticle(@PathVariable int id, @RequestParam(value = "type",defaultValue = "managesearch")String type, Model m){
        m.addAttribute("msg",service.getArticle(id));
        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/"+type;
    }

    @RequestMapping("/deleteArticle/{id}")
    public String delete(@PathVariable int id){
        service.deleteArticle(id);
        List<Article> all = service.findAll();
        List<Category> all1 = categoryService.findAllCategory();
        for(Category m:all1)
        {
            boolean flag=false;
            for(Article n:all)
            {
                if(n.getCategory_id()==m.getCategory_id())
                {
                    flag=true;
                }
            }
            if(flag)
                continue;
            else
                categoryService.deletebyid(m.getCategory_id());
        }
        return "redirect:/manageart";
    }

    @PostMapping("/modifyArticle")
    public String modify( Article article){
        service.modifyArticle(article);
        return "redirect:/manageart";
    }

    @GetMapping("/findAllByid")
    public String findAllByid(String searchname,Model m){
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
            return "redirect:/manageart";
        List<Article> articles = service.findAllByUid(i);
        m.addAttribute("searchname",searchname);
        m.addAttribute("msg",articles);
        return "admin/managearticle";
    }

}
