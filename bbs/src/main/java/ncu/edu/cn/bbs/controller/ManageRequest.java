package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.service.RequestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/10 17:34
 **/
@Controller
public class ManageRequest {
    @Autowired
    private RequestArticleService articleService;

//    @RequestMapping("/Requests")
//    public String findAll(Model m){
//        List<Question> all = articleService.findAllr();
//        m.addAttribute("msg",all);
//        return "admin/managequestion";
//    }

    @RequestMapping("/deleteRequest/{question_id}")
    public String delete(@PathVariable int question_id){
        articleService.deleteby(question_id);
        return "redirect:/Requests";
    }

    @GetMapping("/findAllByque")
    public String findAllByque(String searchname,Model m){
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
            return "redirect:/Requests";
        List<Question> articles = articleService.findAllRequest(i);
        m.addAttribute("searchname",searchname);
        m.addAttribute("msg",articles);

        m.addAttribute("find",1);
        return "admin/managequestion";
    }


    @RequestMapping("/modifyq/{question_id}")
    public String modifyu(@PathVariable int question_id, Model m){
        m.addAttribute("msg",articleService.findrequest(question_id));
        return "admin/managemodifyque";
    }

    @PostMapping("/modifyque")
    public String modifyuser(Question question){
        System.out.println("dufhiaushfdiu");
        articleService.modifyqu(question);
        return "redirect:/Requests";
    }


    @RequestMapping("/Requests")
    public String Requests(@RequestParam(value = "page",defaultValue = "1")String page,@RequestParam(value = "tag",defaultValue = "1")String tag,Model m){
        int size=2; //一页的大小
        int j=1;    //初始值
        System.out.println("查询问题***************");
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

        List<Question> all = articleService.findAllr();  //所有内容

        int pagenum=all.size()/size;
        if(all.size()%size>0)
        {
            pagenum++;      //页面数
        }
        if(j>=pagenum)
        {
            j=pagenum-1;    //j允许的最大页数
        }

        List<Question> apage = new ArrayList<Question>(); //每页要显示的内容
        int i=0;
        for(Question h:all)
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
        //如果没传参数，则type为managesearch，传了参数则为则type为managemodify
        return "admin/managequestion";
    }

}
