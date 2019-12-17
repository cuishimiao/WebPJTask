package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Userdao1 {

    @Select("select * from user order by gold desc limit 5")
    List<User> findGoldUser();

    @Select("select * from user where user_id = #{id}")
    User findById(@Param("id") Integer id);

    @Update("update user set gold=gold+#{wealthy} where username = #{responserName}")
    void addWealthyByName(@Param("responserName")String responserName, @Param("wealthy")Integer wealthy);
}
