package ncu.edu.cn.bbs.dao;

import ncu.edu.cn.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Userdao1 {

    @Select("select * from user order by gold desc limit 5")
    List<User> findGoldUser();
}
