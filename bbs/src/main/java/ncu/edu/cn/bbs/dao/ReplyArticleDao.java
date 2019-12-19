package ncu.edu.cn.bbs.dao;


import ncu.edu.cn.bbs.entity.ReplyArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyArticleDao {
    //发布评论（回帖）
    int generateReply(ReplyArticle replyArticle);
    //查看某文章的所有评论
    List<ReplyArticle>findAllReply(int id);

    List<ReplyArticle>findAll();

    //查看某一个评论
    ReplyArticle getReply(int id);
    //删除某评论
    int deleteReply(int id);
    //修改某评论
    int modifyReply(ReplyArticle replyArticle);

    ReplyArticle showReplyById(int id);
}
