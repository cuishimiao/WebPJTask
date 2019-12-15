package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {
    /*
     * @param: [article]
     * @return: int
     * @description:发布帖子
     */
    int generateArticle(Article article);

    /*
     * @param: [id]
     * @return: com.example.demo.entity.PostArticle
     * @description:根据帖子id获取帖子
     */
    Article getArticle(int id);

    /*
     * @param: [article]
     * @return: int
     * @description:修改帖子
     */
    int modifyArticle(Article article);

    /*
     * @param: [id]
     * @return: int
     * @description:根据帖子id删除帖子
     */
    int deleteArticle(int id);

    /*
     * @param: []
     * @return: java.util.List<ncu.edu.cn.bbs.entity.PostArticle>
     * @description:查看所有帖子
     */
    List<Article> findAll();


    List<Article> findAllByUid(int uid);

}
