package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleMapper;
import ncu.edu.cn.bbs.dao.ReplyArticleMaper;
import ncu.edu.cn.bbs.dao.ReplyDto;
import ncu.edu.cn.bbs.dao.Userdao1;
import ncu.edu.cn.bbs.entity.Article;
import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleDetailController {
//    @Autowired
    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private ReplyArticleMaper replyArticleMaper;
    @Autowired
    private Userdao1 userdao;


    boolean flag=true;

    @GetMapping("/Articledetail/{id}")
    public String articledetail(@PathVariable(name="id") Integer id, Model model){
        Article article = articleMapper.getArticleById(id);
        model.addAttribute("article",article);
        int tag=article.getCategory_id();
        //添加文章标签
        String Category;
        if(tag==1)
            Category="公告";
        else if(tag==2)
            Category="科技";
        else if(tag==3)
            Category="IT";
        else if(tag==4)
            Category="娱乐";
        else if(tag==5)
            Category="文学";
        else if(tag==6)
            Category="体育";
        else Category=" ";
        //累加阅读数
        model.addAttribute("articleCategory",Category);
        articleMapper.plusbyid(id);

        Integer uid=article.getUid();
        //获取他分数最高的前4篇文章
        List<Article> hisArticles=articleMapper.getAllHisArticle(uid);
        model.addAttribute("hisArticles",hisArticles);


        //获取文章作者
        User articleuser=userdao.findById(uid);
        model.addAttribute("articleuser",articleuser);
        if(articleuser==null){
            System.out.println("对象为空"+uid);
        }else
            System.out.println(articleuser.toString()+"____________________________________");

        //获取所有评论,以及评论数
        List<ReplyDto> replyDtos=new ArrayList<>();
        List<ReplyArticle> replyArticles=replyArticleMaper.findAllReply(id);
        //将用户对象和评论对象封装到replyDto中
        for (ReplyArticle replyArticle : replyArticles) {
            ReplyDto replyDto=new ReplyDto();
            replyDto.setReplyArticle(replyArticle);
            replyDto.setUser(userdao.findById(replyArticle.getResponder_id()));
            replyDtos.add(replyDto);
        }
        Integer Count=replyArticleMaper.countReply(id);

        model.addAttribute("replyDtos",replyDtos);
        model.addAttribute("Count",Count);
        return "articledetail";
    }

    @GetMapping("/Articlelike/{id}")
    public String Articlelike(@PathVariable(name="id") Integer id, Model model){
        //增加喜欢数
        if(flag) {
            articleMapper.pluslike(id);
            flag=false;
        }
        Article article = articleMapper.getArticleById(id);
        model.addAttribute("article",article);
        return "articledetail";
    }
}
