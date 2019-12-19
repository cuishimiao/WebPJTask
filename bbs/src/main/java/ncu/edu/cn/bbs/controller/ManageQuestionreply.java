package ncu.edu.cn.bbs.controller;


import ncu.edu.cn.bbs.entity.QuestionReply;
import ncu.edu.cn.bbs.service.QuestionReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 16:01
 **/
@Controller
public class ManageQuestionreply {

    @Autowired
    private QuestionReplyService questionReplyService;

//    @RequestMapping("/Replyques")
//    public String findAllre(Model m){
//        List<QuestionReply> all = questionReplyService.findAllre();
//        m.addAttribute("msg",all);
//        return "admin/managequereply";
//    }

    @RequestMapping("/deletequerep/{id}")
    public String deleteque(@PathVariable int id){
        questionReplyService.deleteque(id);
        return "redirect:/Replyques";
    }

    @GetMapping("/findquerep")
    public String findbyid(String searchname, Model m){
        Integer i = null;
        System.out.println("******************");
        if(!searchname.isEmpty()){
            try {
                i=Integer.parseInt(searchname);
            }
            catch (NumberFormatException e) {
                i=-1;
            }
            System.out.println(i);
        }
        else
            return "redirect:/Replyques";
        QuestionReply quereply = questionReplyService.findbyid(i);
        m.addAttribute("msg",quereply);
        m.addAttribute("searchname", searchname);

        m.addAttribute("find", 1);
        return "admin/managequereply";
    }


    @RequestMapping("/modifyquere/{id}")
    public String modifyquere(@PathVariable int id, Model m){
        System.out.println("fsfasg******************"+id);
        QuestionReply quereply = questionReplyService.findbyid(id);
        m.addAttribute("msg",quereply);
        System.out.println("fsfasg******************"+quereply);
        return "admin/managemodifyquereply";
    }

    @PostMapping("/modifyquereply")
    public String modifyuser(QuestionReply reply){

        questionReplyService.updatequereply(reply);
        return "redirect:/Replyques";
    }

    @RequestMapping("/Replyques")
    public String Replyques(@RequestParam(value = "page",defaultValue = "1")String page, @RequestParam(value = "tag",defaultValue = "1")String tag, Model m){
        int size=2; //一页的大小
        int j=1;    //初始值
        System.out.println("查询文章***************");
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

        List<QuestionReply> all = questionReplyService.findAllre();  //所有内容

        int pagenum=all.size()/size;
        if(all.size()%size>0)
        {
            pagenum++;      //页面数
        }
        if(j>=pagenum)
        {
            j=pagenum-1;    //j允许的最大页数
        }

        List<QuestionReply> apage = new ArrayList<QuestionReply>(); //每页要显示的内容
        int i=0;
        for(QuestionReply h:all)
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

        m.addAttribute("currentpage",j+1);  //当前页面
        System.out.println(j+1);
        System.out.println("当前"+(j+1));
        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/managequereply";
    }

}
