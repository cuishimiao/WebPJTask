package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("SELECT * FROM article")
    List<Article> getAllArticle();

    @Select("SELECT * FROM article order by top desc limit #{offset},#{size}")
    List<Article> getArticle(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT count(1) FROM article ")
    Integer count();

//    @Select("SELECT * FROM article where title like '%'+ #{key} +'%' order by top desc limit #{offset},#{size}")
//    @Select("SELECT * FROM article WHERE title LIKE CONCAT(CONCAT('%', #{key}), '%') order by top desc limit #{offset},#{size};")
//    @Select("SELECT * FROM article WHERE title LIKE '%${key}%'order by top desc limit #{offset},#{size}")
//    List<Article> getcheckArticle(@Param(value = "key") String key,@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT * FROM article WHERE title LIKE '%${key}%'order by top desc ")
    List<Article> getcheckArticle(@Param(value = "key") String key);

    @Select("select * from article order by score desc limit 5")
    List<Article> findGoodArticle();

    @Select("select * from article where article_id=#{articleid}")
    Article getArticleById(@Param(value = "articleid") Integer articleid);

    @Update("update article set count=count+1 where article_id = #{id}")
    void plusbyid(@Param("id")Integer id);

    @Select("select * from article where uid=#{uid} order by score desc limit 4")//找到该作者所有的文章
    List<Article> getAllHisArticle(@Param(value = "uid") Integer uid);

    @Update("update article set `like`=`like`+1 where article_id = #{id}")
    void pluslike(Integer id);

    @Update("update article set top=1 where article_id = #{id}")
    void setTop(Integer id);

    @Update("update article set top=0 where article_id = #{id}")
    void canselTop(Integer id);

    @Update("update article set contend=#{newContend} where article_id = #{id}")
    void alterContend(@Param(value = "newContend")String newContend);

    @Update("update article set score=#{newscore} where article_id = #{id}")
    void updateScore(@Param(value = "newscore")String newscore);

    @Select("SELECT count(1) FROM article WHERE title LIKE '%${key}%'")
    Integer countCheck(String key);
}
