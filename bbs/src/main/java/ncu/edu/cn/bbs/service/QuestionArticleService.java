package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.QuestionDao;
import ncu.edu.cn.bbs.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 17:28
 **/
@Service
public class QuestionArticleService {
    @Autowired
    private QuestionDao articleDao;
    public List<Question>findAllRequest(int user_id){
        return articleDao.findAllRequest(user_id);
    }

    public String generateRequest(Question article){
        int temp = articleDao.generateRequest(article);
        if(temp==1){
            return "需求贴发布成功";
        }
        else{
            return "需求贴发布失败";
        }
    }

    public Question getRequestArticle(int id){
        return articleDao.getRequest(id);
    }

    public List<Question>findAllr(){
        return articleDao.findAll();
    }

    public String deleteByUid(int uid){
        int temp = articleDao.deleteByUid(uid);
        if(temp ==1 ){
            return "成功";
        }
        else{
            return "失败";
        }
    }


}
