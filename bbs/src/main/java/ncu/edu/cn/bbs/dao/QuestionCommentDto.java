package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.QuestionReply;
import ncu.edu.cn.bbs.entity.User;

public class QuestionCommentDto {
    QuestionReply questionReply;
    User user;

    public QuestionReply getQuestionReply() {
        return questionReply;
    }

    public void setQuestionReply(QuestionReply questionReply) {
        this.questionReply = questionReply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
