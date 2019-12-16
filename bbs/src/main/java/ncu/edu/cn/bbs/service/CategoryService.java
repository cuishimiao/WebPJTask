package ncu.edu.cn.bbs.service;


import ncu.edu.cn.bbs.dao.CategoryDao;
import ncu.edu.cn.bbs.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/12/9 23:57
 **/
@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;
    public List<Category> findAllCategory(){return categoryDao.findAll();}

    public String deletebyid(int category_id){
        int temp = categoryDao.deletebyid(category_id);
        if(temp ==1 ){
            return "成功";
        }
        else{
            return "失败";
        }
    }
}
