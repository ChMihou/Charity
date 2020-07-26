package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserRoleVo implements Serializable {
    private static final long serialVersionUID = 4449105958851147637L;
    private Integer Uid;

    //真实姓名
    private  String  Uname;

    private String  Uiphone;

    private String Uemail;

    private String Usex;

    private String Upassword;

    //用户名
    private String Username;

    //注册时间
    private Timestamp Udatetime;

    private  String Uaddress;

    private Integer Rid;

    private String Rname;

    //权限级别
    private Integer Permissionlevel;

    private String uimage;

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    @Override
    public String toString() {
        return "UserRoleVo{" +
                "Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                ", Rid=" + Rid +
                ", Rname='" + Rname + '\'' +
                ", Permissionlevel=" + Permissionlevel +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUiphone() {
        return Uiphone;
    }

    public void setUiphone(String uiphone) {
        Uiphone = uiphone;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUsex() {
        return Usex;
    }

    public void setUsex(String usex) {
        Usex = usex;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Timestamp getUdatetime() {
        return Udatetime;
    }

    public void setUdatetime(Timestamp udatetime) {
        Udatetime = udatetime;
    }

    public String getUaddress() {
        return Uaddress;
    }

    public void setUaddress(String uaddress) {
        Uaddress = uaddress;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public Integer getPermissionlevel() {
        return Permissionlevel;
    }

    public void setPermissionlevel(Integer permissionlevel) {
        Permissionlevel = permissionlevel;
    }
}
