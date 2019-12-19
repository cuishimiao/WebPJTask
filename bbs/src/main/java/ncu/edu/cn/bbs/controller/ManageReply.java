package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.ReplyArticle;
import ncu.edu.cn.bbs.service.ReplyArticleService;
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
public class ManageReply {

    @Autowired
    private ReplyArticleService articleService;

//    @RequestMapping("/Replys")
//    public String findAll(Model m){
//        List<ReplyArticle> all = articleService.findAll();
//        m.addAttribute("msg",all);
//        return "admin/managecomment";
//    }

    @RequestMapping("/deleteRep/{id}")
    public String delete(@PathVariable int id){
        articleService.deleteReply(id);
        return "redirect:/Replys";
    }

    //根据文章编号查找
    @GetMapping("/findAllBycom")
    public String findAllBycom(String searchname,Model m){
        Integer i = null;
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
            return "redirect:/Replys";
        List<ReplyArticle> replys = articleService.findAllReply(i);
        m.addAttribute("searchname",searchname);
        m.addAttribute("msg",replys);

        m.addAttribute("find",1);
        return "admin/managecomment";
    }


    //根据序号修改
    @RequestMapping("/modifym/{id}")
    public String modifyu(@PathVariable int id, Model m){
        m.addAttribute("msg",articleService.getReply(id));
        return "admin/managemodifycom";
    }

    @PostMapping("/modifycom")
    public String modifyuser(ReplyArticle reply){
        articleService.modifyReply(reply);
        return "redirect:/Replys";
    }


    @RequestMapping("/Replys")
    public String sspage(@RequestParam(value = "page",defaultValue = "1")String page,@RequestParam(value = "tag",defaultValue = "1")String tag,Model m){
        int size=2; //一页的大小
        int j=1;    //初始值
        System.out.println("查询评论***************");
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

        List<ReplyArticle> all = articleService.findAll();  //所有内容

        int pagenum=all.size()/size;
        if(all.size()%size>0)
        {
            pagenum++;      //页面数
        }
        if(j>=pagenum)
        {
            j=pagenum-1;    //j允许的最大页数
        }

        List<ReplyArticle> apage = new ArrayList<ReplyArticle>(); //每页要显示的内容
        int i=0;
        for(ReplyArticle h:all)
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
        return "admin/managecomment";
    }




}
