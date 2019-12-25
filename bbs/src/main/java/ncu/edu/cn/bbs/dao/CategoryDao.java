package ncu.edu.cn.bbs.dao;


import ncu.edu.cn.bbs.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {
    /*
     * @param: []
     * @return: java.util.List<com.example.demo.entity.Category>
     * @description:查询所有帖子分类
     */
    List<Category> findAll();

    /*
     * @param: [category_id]
     * @return: int
     * @description:根据id删除类别
     */
    int deletebyid(int category_id);

    /*
     * @param: [category_name]
     * @return: int
     * @description:插入类别
     */
    int insertCategory(String  category_name);


}
