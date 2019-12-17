package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.QuestionReply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionReplyMapper {
    @Insert("insert into question_reply (question_id, username, reply_content) values ( #{question_id} , #{username}, #{reply_content} )")
    void questionreply(QuestionReply questionReply);

    @Select("select * from question_reply where question_id=#{questionid}")
    List<QuestionReply> getQuestionReplyById(@Param(value = "questionid") Integer questionid);

    @Select("SELECT count(1) FROM question_reply where question_id=#{questionid}")
    Integer getQuestionReplyCountById(@Param(value = "questionid")Integer questionid);

    @Update("update question_reply set is_adopt=1 where id=#{acceptReplyId}")
    void setAcceptById(Integer acceptReplyId);
}
