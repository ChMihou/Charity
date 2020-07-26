package com.charity.dao;

import com.charity.entity.Role;
import com.charity.entity.User;
import com.charity.entity.UserRole;
import com.charity.entity.UserRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {

    //绑定用户和角色
    public  boolean adduserrole(UserRole userRole);

    //查询所有角色用户
    public List<UserRoleVo> selectRolename(@Param("userList")List<User> userList);

    //根据id查询角色用户
    public UserRoleVo selectRoleOne(@Param("uid") Integer id);

    //修改用户权限
    public Boolean alterUserRole(UserRole userRole);
}
