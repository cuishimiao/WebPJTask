package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question limit #{offset},#{size}")
    List<Question> getQuestion(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT count(1) FROM question ")
    Integer count();

    @Select("SELECT * FROM question where question_id=#{questionid}")
    Question getQuestionById(@Param(value = "questionid") Integer questionid);

    @Update("update question set wealthy=0 where question_id=#{curquestionId}")
    void UpdateWeathyById(Integer curquestionId);

    @Select("select * from question order by time desc limit 5")
    List<Question> findLeastQuestion();

}
