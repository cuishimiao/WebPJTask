package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.CommentDto;
import ncu.edu.cn.bbs.dao.CommentMapper;
import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class commentController {
    @Autowired
    CommentMapper commentMapper;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDto commentDto,
                       HttpServletRequest request) {
        ReplyArticle replyArticle=new ReplyArticle();
//        replyArticle.setReply_time();
        replyArticle.setContext(commentDto.getContent());
        replyArticle.setArticle_id(commentDto.getArticleId());
//        User user =(User) request.getSession().getAttribute("user");需要session
//        replyArticle.setResponder_id(user.getUser_id());
        replyArticle.setResponder_id(1);

        if(commentDto.getContent().equals(null)){
            return 0;
        }else{
            commentMapper.insertcomment(replyArticle);
            return 1;
        }

    }
}
