package cn.ncu.bbs.bbs.Controller;


import cn.ncu.bbs.bbs.dao.Userdao;
import cn.ncu.bbs.bbs.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class RegisterController {
    @Resource
    Userdao userdao;

    @GetMapping("/user/register")
    public String Inregister() {
        System.out.println("111");
        return "redirect:/register.html";
    }

    /**
     * 插入用户信息
     *    1 private String account;    //登录账号
     *    2 private Integer flag;      //判断是否为超级管理员
     *    3 private String needroom;   //判断参加会议的时候，是否需要房间
     *    4 private String numberid;   //身份证号码，规定为18位数
     *    5 private String password;   //登录密码
     *    6 private String phone;      //电话号码，规定为11位数
     *    7 private String sex;        //性别
     *    8 private String username;   //用户名
     *    9 private String workplace;  //工作地点
     */


    @PostMapping("/user/register")
    public String Register(@RequestParam("account") String account,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("passwordagain") String passwordagain,
                           Map<String, Object> map) {
        User user = userdao.findUserByName(account);
        if(!password.equals(passwordagain)) {
            map.put("msg", "两次输入的密码不一致，请重新输入");
            return "register";
        } else if(user != null) {
            map.put("msg", "该账号已经被使用，请重新输入");
            return "register";
        }

        userdao.insertUser(account, 2, null, null, password, null, null, username, null);
        return "redirect:/login.html";
    }
}

