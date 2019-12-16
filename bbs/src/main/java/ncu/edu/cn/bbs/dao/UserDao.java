package ncu.edu.cn.bbs.dao;


import ncu.edu.cn.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    /*
     * @param: [user]
     * @return: com.example.demo.entity.User
     * @description:根据用户名查找用户
     */
    User findByName(User user);

    /*
     * @param: [user]
     * @return: int
     * @description:根据用户名和密码去查找用户
     */
    int validate(User user);

    /*
     * @param: [user]
     * @return: int
     * @description:实现用户注册功能
     */
    int addUser(User user);
    int modifyUserInfo(User user);
}
