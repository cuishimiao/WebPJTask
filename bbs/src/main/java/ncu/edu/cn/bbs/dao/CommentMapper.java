package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface CommentMapper {
    @Insert("insert into reply_table (article_id, responder_id, context) values ( #{article_id} , #{responder_id}, #{context} )")
    void insertcomment(ReplyArticle replyArticle);
}
