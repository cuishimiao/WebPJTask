package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyArticleMaper {

    @Select("select * from reply_table where article_id=#{Aid}")
    List<ReplyArticle> findAllReply(@Param(value = "Aid") Integer Aid);

    @Select("SELECT count(1) FROM reply_table where article_id=#{id}")
    Integer countReply(@Param(value = "id") Integer id);
}
