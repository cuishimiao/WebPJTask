package ncu.edu.cn.bbs.entity;


import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("postArticle")
public class Article {
    private int article_id;
    private int uid;
    private String title;
    private String content;
    private int category_id;
    private Timestamp create_time;
    private int top;
    private String uhead;
    private String like;
    private String score;
    private String uname;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getUhead() {
        return uhead;
    }

    public void setUhead(String uhead) {
        this.uhead = uhead;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "article{" +
                "article_id=" + article_id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", create_time=" + create_time +
                ", top=" + top +
                ", uhead='" + uhead + '\'' +
                ", like='" + like + '\'' +
                ", score='" + score + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
