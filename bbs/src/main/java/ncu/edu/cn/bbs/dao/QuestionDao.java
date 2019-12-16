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
    Question getRequest(int questionId);

    List<Question> findAll();

<<<<<<< HEAD
    int deleteByUid(int uid);
=======
    int deleteby(int question_id);
>>>>>>> ccc5c9fdc9bb7b9f803fdb6e8545692c1eef759c

}
