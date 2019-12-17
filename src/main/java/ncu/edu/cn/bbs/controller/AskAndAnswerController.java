package ncu.edu.cn.bbs.controller;

import ncu.edu.cn.bbs.dao.ArticleDto;
import ncu.edu.cn.bbs.dao.QuestionMapper;
import ncu.edu.cn.bbs.dao.Userdao1;
import ncu.edu.cn.bbs.entity.Question;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AskAndAnswerController {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private Userdao1 uerDao;

    @RequestMapping("/askandanswer")
    public String askdananswer(Model model,
                               @RequestParam(name = "page", defaultValue = "1") Integer page,  //页码
                               @RequestParam(name = "size", defaultValue = "5") Integer size,  //大小
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "tag", required = false) String tag,
                               @RequestParam(name = "sort", required = false) String sort) {

        Integer offset=size*(page-1);
        List<Question> questions=questionMapper.getQuestion(offset,size);
        Integer totalcount = questionMapper.count();

        Integer totalpage=totalcount/size;

        if(totalcount%size==0){
            totalpage=totalcount/size;
        }else{
            totalpage=totalcount/size+1;
        }

        ArticleDto askandanswerDto=new ArticleDto();

        System.out.println(totalcount+"-------------------------------------");
        askandanswerDto.setQuestions(questions);
        for (Question question : questions) {
            System.out.println(question.toString());
        }

        askandanswerDto.setPagination(totalpage,page);

        List<User> goldUsers=uerDao.findGoldUser();
        model.addAttribute("goldUsers",goldUsers);
        model.addAttribute("askandanswerDto",askandanswerDto);

        return "askandanswer";
    }
}