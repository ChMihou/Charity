package com.charity.service;

import com.charity.entity.Role;
import com.charity.entity.User;
import com.charity.entity.UserRole;
import com.charity.entity.UserRoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {

    public  Boolean adduserrole(UserRole userRole);

    //查询所有角色用户
    public List<UserRoleVo> selectRolename(List<User> userList, int pageNum, int pageSize);

    public UserRoleVo selectRoleOne(Integer id);

    public Boolean alterUserRole(UserRole userRole);
}
