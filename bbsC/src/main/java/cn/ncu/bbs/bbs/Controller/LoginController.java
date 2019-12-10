package cn.ncu.bbs.bbs.Controller;


import cn.ncu.bbs.bbs.dao.Userdao;
import cn.ncu.bbs.bbs.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    Userdao userdao;

    @GetMapping("/user/login")
    public String login(@RequestParam("account") String account,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session,
                        Model model, RedirectAttributes attr) {
        User user = userdao.findUserByName(account);

        if(user == null || !(user.getPassword().equals(password))) {
            map.put("msg", "账号或密码输入错误");
            return "login";
        } else {
            session.setAttribute("user", user);
            System.out.println(user);
            return "redirect:/main.html";
        }

    }
}
