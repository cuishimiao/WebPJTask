package ncu.edu.cn.bbs.service;

import ncu.edu.cn.bbs.dao.UserDao;
import ncu.edu.cn.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int ModifyUserInfo(User user){return userDao.modifyUserInfo(user);}

    public List<User> findAll(){
        return userDao.findAll();
    }

    public List<User> findby(String username){
        return userDao.findby(username);
    }

    public String delete(String username){
        int temp = userDao.delete(username);
        if(temp ==1 ){
            return "成功";
        }
        else{
            return "失败";
        }
    }

    public int modifyPassword(User user){return userDao.updatePassword(user);}

    public int saveuser(User user){
        return userDao.saveuser(user);
    }

    public int modifyEmail(String email,String uid){return userDao.modifyEmail(email,uid);}

    public int modifyHead(User user){return userDao.modifyHeader(user);}


    public int modifypass(String username,String password){
        return userDao.modifypass(username,password);
    }

    public int updateuser(User user){
        return userDao.updateuser(user);
    }

    public User findusername(String username){
        return userDao.findusername(username);
    }
}
