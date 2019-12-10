package cn.ncu.bbs.bbs.Controller;



import cn.ncu.bbs.bbs.dao.Userdao;
import cn.ncu.bbs.bbs.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EditePersonController {

    @Resource
    Userdao userdao;

    //来到编辑个人资料页面
    @GetMapping("/per/{uid}")
    public String editepersonPage(@PathVariable("uid") Integer uid, HttpSession session) {
        User user = userdao.findUserById(uid);
        session.setAttribute("user", user);
        return "redirect:/edit.html";
    }

//    <!--                private String username;   //用户名-->
//<!--                private String describe;   //真实姓名-->
//<!--                private String sex;        //性别-->
//<!--                private String job;   //身份证号码，规定为18位数-->
//<!--                private String phone;      //电话号码，规定为11位数-->
//<!--                private String github;  //工作地点-->
    @PostMapping("/per/{uid}")
    public String editadd(@PathVariable("uid") Integer uid,@RequestParam("username") String username,
                          @RequestParam("describe") String describe, @RequestParam("sex") String sex,
                          @RequestParam("job") String job, @RequestParam("phone") String phone,
                          @RequestParam("github") String github,
                          HttpSession session) {
        userdao.updateUser(username, describe, sex,job,phone,github,uid);
        User user = userdao.findUserById(uid);
        session.setAttribute("user", user);
        System.out.println(user);
        return "redirect:/main.html";
    }
}
