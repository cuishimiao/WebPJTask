package ncu.edu.cn.bbs.dao;


import ncu.edu.cn.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    User findByName(User user);

    int validate(User user);

    int addUser(User user);

    int modifyUserInfo(User user);

    List<User> findby(String username);

    List<User> findAll();

    int delete(String username);

    int updatePassword(User user);

    int saveuser(User user);

    int modifyEmail(String email,String uid);

    int modifyHeader(User user);

    int updateuser(User user);

    User findusername(String username);;

    int modifypass(String username,String password);
}
