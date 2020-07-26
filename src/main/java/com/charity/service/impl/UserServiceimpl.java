package com.charity.service.impl;

import com.charity.dao.UserDao;
import com.charity.entity.Role;
import com.charity.entity.User;
import com.charity.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceimpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User SelectUsername(String username) {
        return userDao.SelectUsername(username);
    }

    @Override
    public User SelectUPw(User user)
    {
        return userDao.SelectUPw(user);
    }

    @Override
    public Role checkRole(Integer Userid) {
        return userDao.checkRole(Userid);
    }

    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Boolean SelectUPhone(User user) {
        return userDao.SelectUPhone(user);
    }
    @Override
    public Boolean updateUserPassword(User user) {
        return userDao.updateUserPassword(user);
    }

    @Override
    public Boolean alterUser(User user) {
        return userDao.alterUser(user);
    }

    @Override
    public List<User> SelectallUser(String username) {
        return userDao.SelectallUser(username);
    }

    @Override
    public Boolean alterUserAll(User user) {
        return userDao.alterUserAll(user);
    }

    @Override
    public User SelectUserId(Integer id) {
        return userDao.SelectUserId(id);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer checkuserall() {
        return userDao.checkuserall();
    }

    @Override
    public Boolean InsertImage(User user) {
        return userDao.InsertImage(user);
    }

    @Override
    public List<User> SelectRootUser(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.SelectRootUser();
    }

    @Override
    public User SelectEmail(User user) {
        return userDao.SelectEmail(user);
    }


}
