package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {

    //序列化id
    private static final long serialVersionUID = 3402607472744869616L;

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

    private String uimage;

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public void setUdatetime(Timestamp udatetime) {
        Udatetime = udatetime;
    }

    public Timestamp getUdatetime() {
        return Udatetime;
    }

    public void setUDatetime(Timestamp datetime) {
        this.Udatetime = datetime;
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

    public String getUaddress() {
        return Uaddress;
    }

    public void setUaddress(String uaddress) {
        Uaddress = uaddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                ", uimage='" + uimage + '\'' +
                '}';
    }
}
