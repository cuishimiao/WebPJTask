package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
