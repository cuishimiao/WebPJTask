package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.ArticleDao;
import ncu.edu.cn.bbs.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public String generateArticle(Article article){
        int temp = articleDao.generateArticle(article);
        if(temp==1){
            return "帖子发布成功";
        }
        else{
            return "帖子发布失败";
        }
    }

    public String modifyArticle(Article article){
        int temp = articleDao.modifyArticle(article);
        if(temp==1){
            return "帖子修改成功";
        }
        else {
            return "帖子修改失败";
        }
    }

    public Article getArticle(int id){
        return articleDao.getArticle(id);
    }

    public String deleteArticle(int id){
        int temp = articleDao.deleteArticle(id);
        if(temp ==1 ){
            return "帖子删除成功";
        }
        else{
            return "帖子删除失败";
        }
    }

    public List<Article>findAll(){
        return articleDao.findAll();
    }

    public List<Article>findAllByUid(int uid){
        return articleDao.findAllByUid(uid);
    }

}
