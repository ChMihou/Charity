package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserScoreVo implements Serializable {
    private static final long serialVersionUID = 2924765755109830789L;

    private  Integer Sid;

    private Integer Suid;

    private Timestamp Stime;

    private  String Score;

    private  String award;

    private String Scause;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public Integer getSuid() {
        return Suid;
    }

    public void setSuid(Integer suid) {
        Suid = suid;
    }

    public Timestamp getStime() {
        return Stime;
    }

    public void setStime(Timestamp stime) {
        Stime = stime;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
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

    public String getScause() {
        return Scause;
    }

    public void setScause(String scause) {
        Scause = scause;
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

    @Override
    public String toString() {
        return "UserScoreVo{" +
                "Sid=" + Sid +
                ", Suid=" + Suid +
                ", Stime=" + Stime +
                ", Score='" + Score + '\'' +
                ", award='" + award + '\'' +
                ", Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                '}';
    }
}
