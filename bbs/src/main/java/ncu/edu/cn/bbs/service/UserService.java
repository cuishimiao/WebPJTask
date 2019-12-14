package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.UserDao;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findByName(User user){
         return userDao.findByName(user);
    }

    public int validate(User user){
        return userDao.validate(user);
    }

    public int addUser(User user){
        return userDao.addUser(user);
    }

}
