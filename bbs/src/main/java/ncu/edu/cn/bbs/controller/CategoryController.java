package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
