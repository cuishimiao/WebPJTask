package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    @ResponseBody
    public List<Category>findCategory(){
        return categoryService.findAllCategory();
    }

<<<<<<< HEAD
    @RequestMapping("/addCategory")
    @ResponseBody
    public String addCategory(@RequestParam String category_name){
        if(categoryService.insertCategory(category_name)==1){
            return "添加成功";
        }
        else{
            return "添加失败";
        }

    }
=======
    //标签管理
    @RequestMapping("/tags")
    public String manageTags(Model model)
    {
        List<Category> tags = categoryService.findAllCategory();
        model.addAttribute("tags", tags);
        return "tags";
    }

    @RequestMapping("/admin/tags/input")
    public String addTags()
    {
        return "/admin/tagsInput";
    }

>>>>>>> 1f1aace1cd6a16495383b9e17c5c9954c2b0b16b
}
