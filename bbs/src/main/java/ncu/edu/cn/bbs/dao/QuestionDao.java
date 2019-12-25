package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionDao {
    /*
     * @param: [article]
     * @return: int
     * @description:发布问题
     */
    int generateRequest(Question article);

    /*
     * @param: [uid]
     * @return: java.util.List<ncu.edu.cn.bbs.entity.Question>
     * @description:根据用户id查看用户提出的所有问题
     */
    List<Question> findAllRequest(int uid);

    /*
     * @param: [question_id]
     * @return: ncu.edu.cn.bbs.entity.Question
     * @description:根据问题id获得问题对象
     */
    Question getRequest(int question_id);

    /*
     * @param: [uid]
     * @return: int
     * @description:根据用户id删除所有问题
     */
    int deleteby(int uid);

    /*
     * @param: [question_id]
     * @return: int
     * @description:根据问题id删除问题
     */
    int deleteByQId(int question_id);

    Question findrequest(int question_id);

    /*
     * @param: [article]
     * @return: int
     * @description: 修改问题
     */
    int modifyqu(Question article);

    /*
     * @param: []
     * @return: java.util.List<ncu.edu.cn.bbs.entity.Question>
     * @description:查询所有问题
     */
    List<Question> findAllr();

}
