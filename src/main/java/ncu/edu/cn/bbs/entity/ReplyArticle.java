package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("replyArticle")
public class ReplyArticle {
    private int id;
    private int article_id;
    private int responder_id;
    private String context;
    private Timestamp reply_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getResponder_id() {
        return responder_id;
    }

    public void setResponder_id(int responder_id) {
        this.responder_id = responder_id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getReply_time() {
        return reply_time;
    }

    public void setReply_time(Timestamp reply_time) {
        this.reply_time = reply_time;
    }

    @Override
    public String toString() {
        return "ReplyArticle{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", responder_id=" + responder_id +
                ", context='" + context + '\'' +
                ", reply_time=" + reply_time +
                '}';
    }
}
