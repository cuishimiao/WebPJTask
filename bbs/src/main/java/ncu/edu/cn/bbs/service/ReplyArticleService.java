package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.ReplyArticleDao;
import ncu.edu.cn.bbs.entity.ReplyArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 15:52
 **/
@Service
public class ReplyArticleService {
    @Autowired
    private ReplyArticleDao replyArticleDao;

    public String deleteReply(int id){
        int temp = replyArticleDao.deleteReply(id);
        if(temp ==1 ){
            return "评论删除成功";
        }
        else{
            return "评论删除失败";
        }
    }

    public String generateArticle(ReplyArticle article){
        int temp = replyArticleDao.generateReply(article);
        if(temp ==1 ){
            return "评论生成成功";
        }
        else{
            return "评论生成失败";
        }
    }

    public ReplyArticle getReply(int id){
        return replyArticleDao.getReply(id);
    }

    public List<ReplyArticle> findAllReply(int id){
        return replyArticleDao.findAllReply(id);
    }

    public String modifyReply(ReplyArticle replyArticle){
        int temp = replyArticleDao.modifyReply(replyArticle);
        if(temp ==1 ){
            return "评论修改成功";
        }
        else{
            return "评论修改失败";
        }
    }


    public List<ReplyArticle> findAll(){
        return replyArticleDao.findAll();
    }

    public ReplyArticle showReplyById(int id){return replyArticleDao.showReplyById(id);}

}
