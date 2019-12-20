package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.entity.User;

public class QuestionDto {
    Question question;
    User user;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
