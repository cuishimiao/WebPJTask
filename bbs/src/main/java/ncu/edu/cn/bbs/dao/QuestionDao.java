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

    int deleteby(int uid);
    
    int deleteByQId(int question_id);


    Question findrequest(int question_id);
    int modifyqu(Question article);
    List<Question> findAllr();

}
