package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.Category;
import ncu.edu.cn.bbs.service.ArticleService;
import ncu.edu.cn.bbs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ManageArticle {
    @Autowired
    ArticleService service;

    @Autowired
    CategoryService categoryService;


//    @RequestMapping("/articles")
//    public String findAll(Model m){
//        List<Article> all = service.findAll();
//        m.addAttribute("msg",all);
//        return "managearticle";
//    }
    //编辑与查看文章
    @RequestMapping("/managegetArt/{id}")
    public String getArticle(@PathVariable int id,@RequestParam(value = "type",defaultValue = "managesearch")String type, Model m){
        m.addAttribute("msg",service.getArticle(id));
        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/"+type;
    }

    //删除文章
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

    //修改后的文章修改
    @PostMapping("/modifyArticle")
    public String modify( Article article){
        service.modifyArticle(article);
        return "redirect:/manageart";
    }

    //根据id查找文章
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
        int find=1;
        m.addAttribute("find",find);
        return "admin/managearticle";
    }

    //置顶与取消置顶
//    @RequestMapping("/managesettop/{article_id}")
//    public String getArticle(@PathVariable int article_id,Model m){
//        System.out.println(article_id);
//        if(article_id==0)
//        {
//            mapp.setTop(article_id);
//            System.out.println("******"+article_id);
//        }
//        if(article_id==1)
//        {
//            mapp.canselTop(article_id);
//            System.out.println("--------"+article_id);
//        }
//        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
//        return "redirect:/manageart";
//    }

//查询所有的文章
    @RequestMapping("/manageart")
    public String manageart(@RequestParam(value = "page",defaultValue = "1")String page,@RequestParam(value = "tag",defaultValue = "1")String tag,Model m){
        int size=2; //一页的大小
        int j=1;    //初始值
        System.out.println("查询文章***************");
        if(tag.equals("1")) //当前页面
        {
            j=Integer.parseInt(page);
        }
        else if(tag.equals("0"))    //上一页
        {
            j=Integer.parseInt(page)-1;
        }
        else if(tag.equals("2"))    //下一页
        {
            j=Integer.parseInt(page)+1;
        }
        j--;        //选择的页数-1

        if(j<0)     //不能小于0
            j=0;

        List<Article> all = service.findAll();  //所有内容

        int pagenum=all.size()/size;
        if(all.size()%size>0)
        {
            pagenum++;      //页面数
        }
        if(j>=pagenum)
        {
            j=pagenum-1;    //j允许的最大页数
        }

        List<Article> apage = new ArrayList<Article>(); //每页要显示的内容
        int i=0;
        for(Article h:all)
        {
            i++;
            if(i>j*size&&i<=(j+1)*size)
            {
                apage.add(h);   //选择要显示的内容
                System.out.println(i);
            }
        }


        System.out.println("页数："+pagenum);
        m.addAttribute("msg",apage);

        List<Integer> num = new ArrayList<Integer>();
        for(int k=0;k<pagenum;k++)
        {
            num.add((Integer)(k+1));
            System.out.println(k);
        }
        m.addAttribute("num",num);//页面数
        System.out.println(num.get(0));

        m.addAttribute("currentpage",j+1);  //当前页面
        System.out.println(j+1);
        System.out.println("当前"+(j+1));
        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/managearticle";
    }
}
