package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("replyArticle")
public class ReplyArticle {
    private int id;
    private int articleId;
    private int responderId;
    private String context;
    private Timestamp replyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getResponderId() {
        return responderId;
    }

    public void setResponderId(int responderId) {
        this.responderId = responderId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "ReplyArticle{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", responderId=" + responderId +
                ", context='" + context + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }
}
