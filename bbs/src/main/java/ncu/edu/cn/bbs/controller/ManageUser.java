package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.User;
import ncu.edu.cn.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManageUser {
    @Autowired
    UserService service;

    @RequestMapping("/Users")
    public String findAll(Model m){
        List<User> all = service.findAll();
        System.out.println(all);
        m.addAttribute("msg",all);
        int admin=0;
        int user=0;
        for (int i = 0; i <all.size() ; i++) {
            User temp = all.get(i);
            System.out.println(temp.getIsAdmin());
            String a=temp.getIsAdmin();
            if(a== null)
                continue;
            if(a.equals("true"))
            {
                admin++;
            }
            else user++;
        }
        m.addAttribute("admin",admin);
        m.addAttribute("user",user);
        return "admin/manageuser";
    }

    @RequestMapping("/adduser")
    public String adduser(Model m){
        return "admin/manageadd";
    }

    @PostMapping("/save")
    public String save(User user,Model m){
        if(user.getUsername().isEmpty()||user.getPassword().isEmpty())
        {
            m.addAttribute("wrong","wrong");
            return "admin/manageadd";
        }
        user.setIsAdmin("false");
        service.saveuser(user);
        return "redirect:/Users";
    }

    @GetMapping("/findAllByname")
    public String findAllByid(String searchname,Model m) {
        if (searchname.isEmpty()) {
            return "redirect:/Users";
        }
        List<User> user1 = service.findby(searchname);
        int admin=0;
        int user=0;
        for (int i = 0; i <user1.size() ; i++) {
            User temp = user1.get(i);
            System.out.println(temp.getIsAdmin());
            String a=temp.getIsAdmin();
            if(a== null)
                continue;
            if(a.equals("true"))
            {
                admin++;
            }
            else user++;
        }
        m.addAttribute("admin",admin);
        m.addAttribute("user",user);

        m.addAttribute("msg", user1);
        m.addAttribute("searchname", searchname);
        return "admin/manageuser";
    }

    @RequestMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable String name){
        service.delete(name);
        return "redirect:/Users";
    }

}
