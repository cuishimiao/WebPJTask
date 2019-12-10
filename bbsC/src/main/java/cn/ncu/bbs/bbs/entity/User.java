package cn.ncu.bbs.bbs.entity;

public class User {
    private Integer uid;        //用户的唯一表示号码
    private String account;    //登录账号
    private Integer flag;      //判断是否为超级管理员  1:管理员， 2：普通用户
    private String password;   //登录密码
    private String phone;      //电话号码，规定为11位数
    private String sex;        //性别
    private String username;   //用户名
    private String job;         //职业
    private String describe;   //个人描述
    private String github;   //github账号

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", flag=" + flag +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                ", job='" + job + '\'' +
                ", describe='" + describe + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
