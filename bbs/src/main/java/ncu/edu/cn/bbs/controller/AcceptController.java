package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.*;
import ncu.edu.cn.bbs.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AcceptController {
    @Autowired
    Userdao1 userdao;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuestionReplyMapper questionReplyMapper;

//    @ResponseBody
//    @RequestMapping(value = "/Accept",method = RequestMethod.POST)
    @RequestMapping("/Accept_{qid}_{responserName}_{acceptReplyId}")
    public String accept(@PathVariable(name = "qid") Integer qid,   //问题ID
                         @PathVariable(name = "responserName") String responserName,//回复者的昵称
                         @PathVariable(name = "acceptReplyId") Integer acceptReplyId) {  //回答的ID

        System.out.println(qid+"   "+responserName+"  "+acceptReplyId);
        Question curquestion=questionMapper.getQuestionById(qid);
        //增加回答者的wealthy
        Integer wealthy=curquestion.getWealthy();
        userdao.addWealthyByName(responserName,wealthy);
        //将问题的wealthy设为0，标记以及被采纳
        Integer curquestionId=curquestion.getQuestion_id();
        questionMapper.UpdateWeathyById(curquestionId);
        //将被采纳的回复的标志位设为1
//        return "redirect:/allquestion.html";
        questionReplyMapper.setAcceptById(acceptReplyId);
        String adress="questiondetial/"+qid.toString();
        System.out.println(adress);
        return "redirect:/askandanswer";
    }
}
