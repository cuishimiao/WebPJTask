package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.QuestionCommentDto;
import ncu.edu.cn.bbs.dao.QuestionMapper;
import ncu.edu.cn.bbs.dao.QuestionReplyMapper;
import ncu.edu.cn.bbs.dao.Userdao1;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.entity.QuestionReply;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AskAndAnswerDetailController {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private Userdao1 uerDao;
    @Autowired
    private QuestionReplyMapper questionReplyMapper;
    @GetMapping("/questiondetail/{id}")
    public String askandanswerdetail(@PathVariable(name="id") Integer questionid, Model model){

        Question question=questionMapper.getQuestionById(questionid);
        model.addAttribute(question);

        if(question!=null)
            System.out.println(question.toString());
        else
            System.out.println("为空--------------------------------------");

        List<User> goldUsers=uerDao.findGoldUser();
        for (User goldUser : goldUsers) {
            System.out.println(goldUser.toString());
        }
        model.addAttribute("goldUsers",goldUsers);

        //添加所有该问题的回答到model
        List<QuestionReply> questionReplies=questionReplyMapper.getQuestionReplyById(questionid);

        List <QuestionCommentDto> questionCommentDtos=new ArrayList<>();
        for (QuestionReply questionReply : questionReplies) {
            QuestionCommentDto questionCommentDto =new QuestionCommentDto();
            questionCommentDto.setQuestionReply(questionReply);
            User user=uerDao.findByname(questionReply.getUsername());
            questionCommentDto.setUser(user);
            questionCommentDtos.add(questionCommentDto);
        }
//        model.addAttribute("questionReplies",questionReplies);
        model.addAttribute("questionCommentDtos",questionCommentDtos);

        for (QuestionCommentDto questionCommentDto : questionCommentDtos) {
            System.out.println(questionCommentDto.getUser().toString()+"--------------------------");
        }
        //添加问题回复数到model
        Integer questionReplyCount=questionReplyMapper.getQuestionReplyCountById(questionid);
        model.addAttribute("questionReplyCount",questionReplyCount);

        return "questiondetail";
    }
}
