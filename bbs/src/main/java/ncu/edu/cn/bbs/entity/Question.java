package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

import javax.annotation.sql.DataSourceDefinition;
import java.sql.Timestamp;
@Alias("requestArticle")
public class
Question {
    private Integer question_id;
    private String uid;
    private Timestamp time;
    private String content;
    private String question_title;
    private String uhead;

    public String getUhead() {
        return uhead;
    }

    public void setUhead(String uhead) {
        this.uhead = uhead;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", uid='" + uid + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", question_title='" + question_title + '\'' +
                ", uhead='" + uhead + '\'' +
                '}';
    }
}
