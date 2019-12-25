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
import org.springframework.web.servlet.ModelAndView;
//import sun.text.normalizer.NormalizerBase;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    ArticleService service;

    @Autowired
    private CategoryService categoryService;

    /*
     * @param: []
     * @return: java.util.List<ncu.edu.cn.bbs.entity.Article>
     * @description: 查询所有文章，以列表的形式返回到前端
     */
    @RequestMapping("/articles")
    @ResponseBody
    public List<Article> findAll(){
        return service.findAll();
    }

    /*
     * @param: [id, m]
     * @return: java.lang.String
     * @description: 根据文章id得到文章对象
     */
    @RequestMapping("/getArticle/{id}")
    public String getArticle(@PathVariable int id, Model m){
        m.addAttribute("msg",service.getArticle(id));
        return "article";
    }


    /*
     * @param: [uid]
     * @return: java.util.List<ncu.edu.cn.bbs.entity.Article>
     * @description:根据用户id得到用户的所有文章
     */
    @RequestMapping("/articles/{uid}")
    @ResponseBody
    public List<Article> finaAllByUid(@PathVariable int uid){
        return service.findAllByUid(uid);
    }


    //写文章
    @RequestMapping("/writeArticle")
    @ResponseBody
    public String write(@RequestBody Article article){

        String msg;
        if(article.getTitle()==null || article.getTitle().equals(""))
        {

           msg="文章标题不能为空";
           return msg;
        }
        if (article.getContent()==null || article.getContent().equals(""))
        {
            msg="文章内容不能为空";
            return msg;
        }

         msg = service.generateArticle(article);
        return msg;
    }


    @RequestMapping("/publish")
    public String publish(HttpSession session,Model model)
    {

        if(session.getAttribute("user")!=null)
        {
            model.addAttribute("user",session.getAttribute("user"));

            List<Category> allCategory = categoryService.findAllCategory();
            model.addAttribute("tags",allCategory);
            return "publish";
        }
        else
        {
            model.addAttribute("error","请先登录");
            return "/index";
        }

    }

    //跳到发问题界面
    @RequestMapping("/ask")
    public  String ask(HttpSession session, Model m)
    {
        if(session.getAttribute("user")!=null)
        {
            m.addAttribute("user",session.getAttribute("user"));

            return "question";
        }
        else
        {
            m.addAttribute("error","请先登录");
            return "/index";
        }
    }

    /*
     * @param: [id]
     * @return: java.lang.String
     * @description:根据文章id删除该文章
     */
    @RequestMapping("/deleteArticleById/{id}")
    @ResponseBody
    public String delete(@PathVariable int id){
        return service.deleteArticle(id);
    }

    /*
     * @param: [article]
     * @return: java.lang.String
     * @description:根据文章对象去修改文章
     */
    @RequestMapping("/modifyArt")
    @ResponseBody
    public String modify(@RequestBody Article article){
        return service.modifyArticle(article);
    }

    /*
     * @param: [article_id, model]
     * @return: java.lang.String
     * @description:根据文章id得到文章对象并且进行视图的定位 (查看文章)
     */
    @RequestMapping("/showArticle/{article_id}")
    public String publish(@PathVariable int article_id,Model model){
        Article article = service.getArticle(article_id);
        model.addAttribute("article",article);
        return "/user/showArticle";
    }

    /*
     * @param: [article_id, model]
     * @return: java.lang.String
     * @description: 根据文章id得到文章对象并且进行视图的定位（修改文章）
     */
    @RequestMapping("/modifyArticle/{article_id}")
    public String modifyArticle(@PathVariable int article_id, Model model){
        Article article = service.getArticle(article_id);
        model.addAttribute("article",article);
        return "/user/modifyArticle";
    }
}
