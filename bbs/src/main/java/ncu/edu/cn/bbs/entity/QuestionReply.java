package ncu.edu.cn.bbs.entity;


import java.sql.Timestamp;

public class QuestionReply {
    private int id;
    private int question_id;//回复的问题编号
    private String username;//回复者姓名
    private Timestamp time; //回复时间
    private String reply_content;//解答内容
    private int is_adopt;//是否采纳

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getIs_adopt() {
        return is_adopt;
    }

    public void setIs_adopt(int is_adopt) {
        this.is_adopt = is_adopt;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    @Override
    public String toString() {
        return "QuestionReply{" +
                "id=" + id +
                ", question_id=" + question_id +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", reply_content='" + reply_content + '\'' +
                ", is_adopt=" + is_adopt +
                '}';
    }
}
