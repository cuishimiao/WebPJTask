package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.User;
import ncu.edu.cn.bbs.entity.managelogin;
import ncu.edu.cn.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManageUser {
    @Autowired
    UserService service;

    //查找所有的用户
//    @RequestMapping("/Users")
//    public String findAll(Model m){
//        List<User> all = service.findAll();
//        m.addAttribute("msg",all);
//        int admin=0;
//        int user=0;
//        for (int i = 0; i <all.size() ; i++) {
//            User temp = all.get(i);
//            System.out.println(temp.getIs_admin());
//            String a=temp.getIs_admin();
//            if(a== null)
//                continue;
//            if(a.equals("true"))
//            {
//                admin++;
//            }
//            else user++;
//        }
//        m.addAttribute("admin",admin);
//        m.addAttribute("user",user);
//        return "admin/manageuser";
//    }

    //添加用户
    @RequestMapping("/adduser")
    public String adduser(Model m){
        return "admin/manageadd";
    }

    //保存添加的用户
    @PostMapping("/save")
    public String save(User user, Model m){
        System.out.println("***********************"+user);
        if(user.getUsername().isEmpty()||user.getPassword().isEmpty())
        {
            m.addAttribute("wrong",1);
            return "admin/manageadd";
        }
        service.saveuser(user);
        return "redirect:/Users";
    }

    //根据用户名修改用户
    @RequestMapping("/modifyu/{username}")
    public String modifyu(@PathVariable String username, Model m){
        System.out.println("根据用户名修改用户");
        m.addAttribute("msg",service.findusername(username));
        return "admin/managemodifyuser";
    }

    //将修改后的信息更新
    @PostMapping("/modifyuser")
    public String modifyuser(User user){
        System.out.println("将修改后的信息更新");
        service.updateuser(user);
        return "redirect:/Users";
    }

    //根据名字查找用户
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

        m.addAttribute("find", 1);
        return "admin/manageuser";
    }

    //删除用户
    @RequestMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable String name){
        service.delete(name);
        return "redirect:/Users";
    }

    //查询用户
    @RequestMapping("/Users")
    public String Users(@RequestParam(value = "page",defaultValue = "1")String page,@RequestParam(value = "tag",defaultValue = "1")String tag,Model m){
        int size=2; //一页的大小
        int j=1;    //初始值
        System.out.println("查询用户***************");
        if(tag.equals("1")) //当前页面
        {
            j=Integer.parseInt(page);
        }
        else if(tag.equals("0"))    //上一页
        {
            j=Integer.parseInt(page)-1;
        }
        else if(tag.equals("2"))    //下一页
        {
            j=Integer.parseInt(page)+1;
        }
        j--;        //选择的页数-1

        if(j<0)     //不能小于0
            j=0;

        List<User> all = service.findAll();  //所有内容

        int pagenum=all.size()/size;
        if(all.size()%size>0)
        {
            pagenum++;      //页面数
        }
        if(j>=pagenum)
        {
            j=pagenum-1;    //j允许的最大页数
        }

        List<User> apage = new ArrayList<User>(); //每页要显示的内容
        int i=0;
        for(User h:all)
        {
            i++;
            if(i>j*size&&i<=(j+1)*size)
            {
                apage.add(h);   //选择要显示的内容
                System.out.println(i);
            }
        }


        System.out.println("页数："+pagenum);
        m.addAttribute("msg",apage);

        List<Integer> num = new ArrayList<Integer>();
        for(int k=0;k<pagenum;k++)
        {
            num.add((Integer)(k+1));
            System.out.println(k);
        }
        m.addAttribute("num",num);//页面数
        System.out.println(num.get(0));

        m.addAttribute("currentpage",j+1);  //当前页面
        System.out.println(j+1);
        System.out.println("当前"+(j+1));


        int admin=0;
        int user=0;
        for (int x = 0; x <all.size() ; x++) {
            User temp = all.get(x);
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


        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/manageuser";
    }


    //登录管理
    @PostMapping("/managelogin")
    public String login(User user, HttpServletRequest request, Model m){

        if(user.getUsername().isEmpty()||user.getPassword().isEmpty())
        {
            m.addAttribute("wrong","不能为空！！！");
            return  "admin/login";
        }
        List<User> all = service.findAll();  //所有内容
        for(User h:all)
        {
            if(user.getUsername().equals(h.getUsername())&&user.getPassword().equals(h.getPassword())&&h.getIsAdmin().equals("true"))
            {
                HttpSession session1=request.getSession();
                session1.setAttribute("username",h.getUsername());
                session1.setAttribute("password",h.getPassword());
                System.out.println(session1.getAttribute("username"));
                System.out.println(session1);
                return "redirect:/Users";
            }
        }
        m.addAttribute("wrong","账户或密码错误！！！");
        return  "admin/login";
    }

    //登录
    @RequestMapping("/loginconvert")
    public String loginconvert(Model m){
        return "admin/login";
    }

    //个人设置
    @RequestMapping("/managesetting")
    public String managesetting(Model m){
        return "admin/manageset";
    }

    //修改密码
    @PostMapping("/modifypassword")
    public String managesetting(managelogin user,HttpServletRequest request,Model m){

        List<User> all = service.findAll();  //所有内容
        String username=(String) request.getSession().getAttribute("username");
        String password=(String) request.getSession().getAttribute("password");
        System.out.println("*******************"+username);
        System.out.println("*******************"+password);
        System.out.println("*******************"+user.getUsernamee()+user.getOriginal()+user.getPresent()+user.getConfirm());
        if(user.getOriginal().isEmpty()||user.getPresent().isEmpty()||user.getConfirm().isEmpty())
        {
            m.addAttribute("wrong","不能有空！！！");
            return  "admin/manageset";
        }
        if(!user.getPresent().equals(user.getConfirm()))
        {
            m.addAttribute("wrong","修改密码与确认密码不一致！！！");
        }
        if(user.getUsernamee().equals(username)&&user.getOriginal().equals(password))
        {
            service.modifypass(username,user.getPresent());
            request.getSession().invalidate();
            m.addAttribute("right","修改密码成功！！！");
            return "admin/login";
        }
        else{
            m.addAttribute("wrong","原密码不正确！！！");
        }
        return  "admin/manageset";
    }


    //退出并返回首页
    @RequestMapping("/logoutandreturn")
    public String logoutandreturn(Model m,HttpServletRequest request){
        request.getSession().invalidate();
        String username=(String) request.getSession().getAttribute("username");
        String password=(String) request.getSession().getAttribute("password");
        System.out.println("退出登录");
        return "index";
    }

    //退出登录
    @RequestMapping("/managelogout")
    public String managelogout(Model m,HttpServletRequest request){
        request.getSession().invalidate();
        String username=(String) request.getSession().getAttribute("username");
        String password=(String) request.getSession().getAttribute("password");
        System.out.println("退出登录***************************");
        return "admin/login";
    }

}
