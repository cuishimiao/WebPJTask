package cn.ncu.bbs.bbs.dao;



import cn.ncu.bbs.bbs.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Userdao {
    /**
     private Integer uid;        //用户的唯一表示号码
     private String account;    //登录账号
     private Integer flag;      //判断是否为超级管理员  1:管理员， 2：普通用户
     private String password;   //登录密码
     private String phone;      //电话号码，规定为11位数
     private String sex;        //性别
     private String username;   //用户名
     private String job;         //职业
     private String describe;   //个人描述
     private String github;   //github账号
     */
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @Insert("insert into usertable(account, flag, password, phone, sex, username, job, describe, github) " +
            "values(#{account}, #{flag}, #{password}, #{phone}, #{sex}, #{username}, #{job}, #{describe}, #{github})")
    void insertUser(@Param("account") String account, @Param("flag") Integer flag, @Param("password") String password,
                    @Param("phone") String phone, @Param("sex") String sex, @Param("username") String username,
                    @Param("job") String job, @Param("describe") String describe, @Param("github") String github);


    /**
     * 通过账号查询用户信息
     */
    @Select("SELECT * FROM usertable WHERE account = #{account}")
    User findUserByName(@Param("account") String account);

    /**
     * 通过id查询用户信息，返回User对象
     */
    @Select("SELECT * FROM usertable WHERE uid = #{uid}")
    User findUserById(@Param("uid") Integer uid);


    /**
     * 根据 id 更新用户信息
     private Integer uid;        //用户的唯一表示号码
     private String account;    //登录账号
     private Integer flag;      //判断是否为超级管理员  1:管理员， 2：普通用户
     private String password;   //登录密码
     private String phone;      //电话号码，规定为11位数
     private String sex;        //性别
     private String username;   //用户名
     private String job;         //职业
     private String describe;   //个人描述
     private String github;   //github账号
     */
    @Update("UPDATE usertable SET username = #{username}, job = #{job}, sex = #{sex}, phone = #{phone}, describe = #{describe}, github = #{github} WHERE uid = #{uid}")
    void updateUser(@Param("username") String username, @Param("job") String job, @Param("sex") String sex, @Param("phone") String phone,
                    @Param("describe") String describe, @Param("github") String github,
                    @Param("uid") Integer uid);
}
