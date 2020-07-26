package com.charity.entity;

import java.io.Serializable;

public class Role  implements Serializable {

    private static final long serialVersionUID = 1975616406763208017L;

    private Integer Rid;

    private String Rname;

    //权限级别
    private Integer Permissionlevel;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer roleid) {
        Rid = roleid;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rolename) {
        Rname = rolename;
    }

    public Integer getPermissionlevel() {
        return Permissionlevel;
    }

    public void setPermissionlevel(Integer permissionlevel) {
        Permissionlevel = permissionlevel;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Roleid=" + Rid +
                ", Rolename='" + Rname + '\'' +
                ", Permissionlevel=" + Permissionlevel +
                '}';
    }
}

