package com.charity.service.impl;

import com.charity.entity.Role;
import com.charity.entity.User;
import com.charity.entity.UserRole;
import com.charity.dao.RoleDao;
import com.charity.entity.UserRoleVo;
import com.charity.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RoleService")
public class RoleServiceimpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public Boolean adduserrole(UserRole userRole) {
        return roleDao.adduserrole(userRole);
    }

    @Override
    public List<UserRoleVo> selectRolename(List<User> userList, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return roleDao.selectRolename(userList);
    }

    @Override
    public UserRoleVo selectRoleOne(Integer id) {
        return roleDao.selectRoleOne(id);
    }

    @Override
    public Boolean alterUserRole(UserRole userRole) {
        return roleDao.alterUserRole(userRole);
    }
}
