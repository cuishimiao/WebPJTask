package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.CommentDto;
import ncu.edu.cn.bbs.dao.QuestionReplyDto;
import ncu.edu.cn.bbs.dao.QuestionReplyMapper;
import ncu.edu.cn.bbs.entity.QuestionReply;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionReplyController {
    @Autowired
    QuestionReplyMapper questionReplyMapper;

    @ResponseBody
    @RequestMapping(value = "/questionreply",method = RequestMethod.POST)
    public Object post(@RequestBody QuestionReplyDto questionReplyDto,
                       HttpServletRequest request) {
        QuestionReply questionReply=new QuestionReply();
        questionReply.setQuestion_id(questionReplyDto.getQuestionId());
        questionReply.setReply_content(questionReplyDto.getContent());

        User user =(User) request.getSession().getAttribute("curuser");//需要session
        questionReply.setUsername(user.getUsername());
        // 如果回答内容为空，报错
        if(questionReplyDto.getContent().equals(null)){
            return 0;
        }else{//问题内容不为空，插入数据库内，返回1，局部刷新页面
            questionReplyMapper.questionreply(questionReply);
            return 1;
        }
    }
}
