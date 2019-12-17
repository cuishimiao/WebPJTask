package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleDto;
import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.dao.Userdao1;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController1 {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private Userdao1 uerDao;

    @RequestMapping("/article")
    public String article(Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,  //页码
                          @RequestParam(name = "size", defaultValue = "5") Integer size,  //大小
                          @RequestParam(name = "search", required = false) String search,
                          @RequestParam(name = "tag", required = false) String tag,
                          @RequestParam(name = "sort", required = false) String sort){
        Integer offset=size*(page-1);
        List<Article> Articles=articleMapper.getArticle(offset,size);
        //处理分页数据
        Integer totalcount = articleMapper.count();
        Integer totalpage=totalcount/size;
        if(totalcount%size==0){
            totalpage=totalcount/size;
        }else{
            totalpage=totalcount/size+1;
        }
        ArticleDto articleDto=new ArticleDto();
        articleDto.setArticles(Articles);
        articleDto.setPagination(totalpage,page);

        model.addAttribute("articleDto",articleDto);

        //侧边栏，搜索赏金最高的5人
        List<User> goldUsers=uerDao.findGoldUser();
        model.addAttribute("goldUsers",goldUsers);

        //搜索文章得分最高的5篇
        List<Article> goodArticles=articleMapper.findGoodArticle();
        model.addAttribute("goodArticles",goodArticles);

        return "article";
    }


    @GetMapping("/check")//实现搜索功能
    public String article(Model model, @RequestParam(name = "key") String key){
        List<Article> Articles=articleMapper.getcheckArticle(key);
        ArticleDto articleDto=new ArticleDto();
        articleDto.setArticles(Articles);
        articleDto.setPagination(1,1);
        model.addAttribute("articleDto",articleDto);

        List<Article> goodArticles=articleMapper.findGoodArticle();
        model.addAttribute("goodArticles",goodArticles);

        List<User> goldUsers=uerDao.findGoldUser();
        model.addAttribute("goldUsers",goldUsers);

        return "article";
    }





}
