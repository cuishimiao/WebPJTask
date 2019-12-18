package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
