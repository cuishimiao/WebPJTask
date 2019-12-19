package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.QuestionReplyDao;
import ncu.edu.cn.bbs.entity.QuestionReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 15:52
 **/
@Service
public class QuestionReplyService {
    @Autowired
    private QuestionReplyDao replyDao;

    public int deleteque(int id){
        int temp = replyDao.deletequerep(id);
        return temp;
    }

    public QuestionReply findbyid(int id){
        System.out.println(2);
        return replyDao.findbyid(id);
    }

    public int updatequereply(QuestionReply quereply){
        return replyDao.updatequereply(quereply);
    }

    public List<QuestionReply> findAllre(){
        return replyDao.findAllre();
    }
}
