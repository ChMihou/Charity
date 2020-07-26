package com.charity.entity;

import java.io.Serializable;

public class UserRole implements Serializable {


    private static final long serialVersionUID = -1489548016291937671L;

    private Integer URid;

    private Integer Userid;

    private Integer Roleid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getURid() {
        return URid;
    }

    public void setURid(Integer URid) {
        this.URid = URid;
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public Integer getRoleid() {
        return Roleid;
    }

    public void setRoleid(Integer roleid) {
        Roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "URid=" + URid +
                ", Userid=" + Userid +
                ", Roleid=" + Roleid +
                '}';
    }
}
