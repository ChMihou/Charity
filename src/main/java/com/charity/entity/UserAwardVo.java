package com.charity.entity;

import java.sql.Timestamp;

public class UserAwardVo {
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

    private Timestamp Atime;

    private Integer Aid;

    private  Integer Auid;

    private String Aname;

    private String uimage;

    private String Acomment;


    public String getAcomment() {
        return Acomment;
    }

    public void setAcomment(String acomment) {
        Acomment = acomment;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
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

    public Timestamp getAtime() {
        return Atime;
    }

    public void setAtime(Timestamp atime) {
        Atime = atime;
    }

    public Integer getAid() {
        return Aid;
    }

    public void setAid(Integer aid) {
        Aid = aid;
    }

    public Integer getAuid() {
        return Auid;
    }

    public void setAuid(Integer auid) {
        Auid = auid;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    @Override
    public String toString() {
        return "UserAwardVo{" +
                "Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                ", Atime=" + Atime +
                ", Aid=" + Aid +
                ", Auid=" + Auid +
                ", Aname='" + Aname + '\'' +
                ", uimage='" + uimage + '\'' +
                ", Acomment='" + Acomment + '\'' +
                '}';
    }
}
