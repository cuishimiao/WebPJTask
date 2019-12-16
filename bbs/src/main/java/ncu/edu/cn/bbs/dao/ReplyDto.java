package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.entity.User;

//将评论和用户打包到一起
public class ReplyDto {
    private ReplyArticle replyArticle;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReplyArticle getReplyArticle() {
        return replyArticle;
    }

    public void setReplyArticle(ReplyArticle replyArticle) {
        this.replyArticle = replyArticle;
    }
}
