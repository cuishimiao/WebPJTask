package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionDao {
    int generateRequest(Question article);
    List<Question> findAllRequest(int uid);
    Question getRequest(int question_id);

    List<Question> findAllr();

    int deleteby(int question_id);

}
