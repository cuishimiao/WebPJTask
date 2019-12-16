package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("postArticle")
public class Article {
    private Integer articleId;
    private Integer uid;
    private String title;
    private String content;
    private int category_id;
    private Integer count;
    private Timestamp createTime;
    private Integer top;
    private String uhead;
    private Integer like;
    private Integer score;
    private String uname;
    private Integer categoryId;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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


    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getUhead() {
        return uhead;
    }

    public void setUhead(String uhead) {
        this.uhead = uhead;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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
        return "Article{" +
                "articleId=" + articleId +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", count=" + count +
                ", createTime=" + createTime +
                ", top=" + top +
                ", uhead='" + uhead + '\'' +
                ", like=" + like +
                ", score=" + score +
                ", uname='" + uname + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
