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
}
