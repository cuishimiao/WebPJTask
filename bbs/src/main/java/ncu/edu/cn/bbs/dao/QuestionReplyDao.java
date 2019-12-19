package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.QuestionReply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionReplyDao {
    int deletequerep(int id);

    QuestionReply findbyid(int id);

    List<QuestionReply>findAllre();

    int updatequereply(QuestionReply quereply);
}
