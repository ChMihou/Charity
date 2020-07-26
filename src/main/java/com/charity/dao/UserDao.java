package com.charity.dao;

import com.charity.entity.Role;
import com.charity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    //根据名字查询用户
    public User SelectUsername(String username);

    //根据账号密码查询用户
    public User SelectUPw(User user);

    //查询用户角色信息
    public Role checkRole(Integer Userid);

    //增加用户
    public Boolean addUser(User user);

    //通过手机号和用户名查找用户
    public Boolean SelectUPhone(User user);

    //更新密码
    public Boolean updateUserPassword(User user);

    //修改用户信息
    public Boolean alterUser(User user);

    //查询所有用户
    public List<User> SelectallUser(@Param("username") String username);

    //管理员修改用户所有信息
    public Boolean alterUserAll(User user);

    //根据id查询客户
    public User SelectUserId(@Param("uid") Integer id);

    //根据id删除用户
     public Boolean deleteUser(@Param("uid") Integer id);

     //查询一共多少用户
    public Integer checkuserall();

    //上传头像
    public Boolean InsertImage(User user);

    //查找root权限者
    public List<User> SelectRootUser();

    //核对邮件
    public User SelectEmail(User user);
}
