package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.User;
import ncu.edu.cn.bbs.service.UserService;
import ncu.edu.cn.bbs.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService service;


    @RequestMapping(value = "")
    public String showPage(){
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user,HttpSession session) {
        Map<String,Object>map = new HashMap<>();
        User temp = service.findByName(user);
        if(temp !=null){
            if(service.validate(user)>0){
                map.put("msg",temp);
                session.setAttribute(ConstantUtils.USER_SESSION_KEY,temp);
                return map;
            }
            else{
                map.put("msg","密码错误") ;
                return map;
            }
        }
        else{
            map.put("msg","用户不存在") ;
            return map;
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        User temp = service.findByName(user);
        if(temp != null){
            return "用户名已存在";
        }
        else{
            int count = service.addUser(user);
            if(count == 1){
                return "注册成功";
            }
            else return "注册失败";
        }
    }

    /*
     * @param: [request]
     * @return: java.lang.String
     * @description:退出销毁session
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(ConstantUtils.USER_SESSION_KEY);
        return "redirect:/";
    }

    @RequestMapping("/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(@RequestBody User user){
        int temp = service.ModifyUserInfo(user);
        if(temp ==1){
            return "信息修改成功!";
        }
        else{
            return "信息修改失败!";
        }
    }



}
