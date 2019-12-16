package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

import javax.annotation.sql.DataSourceDefinition;
import java.sql.Timestamp;
@Alias("requestArticle")
public class
Question {
    private Integer questionId;
    private int uid;
    private Timestamp time;
    private String content;
    private String questionTitle;
    private String uhead;

    public String getUhead() {
        return uhead;
    }

    public void setUhead(String uhead) {
        this.uhead = uhead;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", uid=" + uid +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", uhead='" + uhead + '\'' +
                '}';
    }
}
