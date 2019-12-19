package ncu.edu.cn.bbs.entity;

import org.apache.ibatis.type.Alias;

@Alias("managelogin")
public class managelogin {

    private String usernamee;//用户名
    private String original;//原始密码
    private String present;//修改密码
    private String confirm;//确认密码

    public String getUsernamee() {
        return usernamee;
    }

    public void setUsernamee(String usernamee) {
        this.usernamee = usernamee;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }


    @Override
    public String toString() {
        return "Question{" +
                ", usernamee='" + usernamee + '\'' +
                ", original='" + original + '\'' +
                ", present='" + present + '\'' +
                ", confirm='" + confirm + '\'' +
                '}';
    }
}
