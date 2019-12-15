package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question limit #{offset},#{size}")
    List<Question> getQuestion(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT count(1) FROM question ")
    Integer count();

    @Select("SELECT * FROM question where question_id=#{questionid}")
    Question getQuestionById(@Param(value = "questionid") Integer questionid);
}
