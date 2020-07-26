package com.charity.service;

import com.charity.entity.Role;
import com.charity.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    //根据用户名查询用户
    public User SelectUsername(String username);

    //登陆查询用户存在与否
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
    public List<User> SelectallUser(String username);

    //管理员修改用户所有信息
    public Boolean alterUserAll(User user);

    //根据id查询客户
    public User SelectUserId(@Param("uid") Integer id);

    public Boolean deleteUser(@Param("uid") Integer id);

    //查询一共多少用户
    public Integer checkuserall();

    //上传头像
    public Boolean InsertImage(User user);

    //查找root权限者
    public List<User> SelectRootUser(int pageNum,int pageSize);

    //核对邮件
    public User SelectEmail(User user);
}