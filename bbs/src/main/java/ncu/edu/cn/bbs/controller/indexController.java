package ncu.edu.cn.bbs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/test")
    public String test()
    {
        int i =9/0;
        return "/";
    }
}
