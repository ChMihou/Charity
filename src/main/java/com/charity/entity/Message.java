package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message  implements Serializable {
    private static final long serialVersionUID = 6847840707679757284L;

    private Integer Mid;

    //留言人
    private String Mname;

    //留言内容
    private String Mess;

    //留言时间
     private  Timestamp Mtime;

    //是否回复
    private Integer Mflag;

    private String Mtitle;

     //回复
    private  String Mapply;

    private  String Mcheckboy;

    public Integer getMflag() {
        return Mflag;
    }

    public void setMflag(Integer mflag) {
        Mflag = mflag;
    }

    public String getMcheckboy() {
        return Mcheckboy;
    }

    public void setMcheckboy(String mcheckboy) {
        Mcheckboy = mcheckboy;
    }

    public String getMtitle() {
        return Mtitle;
    }

    public void setMtitle(String mtitle) {
        Mtitle = mtitle;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMess() {
        return Mess;
    }

    public void setMess(String mess) {
        Mess = mess;
    }

    public Timestamp getMtime() {
        return Mtime;
    }

    public void setMtime(Timestamp mtime) {
        Mtime = mtime;
    }

    public String getMapply() {
        return Mapply;
    }

    public void setMapply(String mapply) {
        Mapply = mapply;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Mid=" + Mid +
                ", Mname='" + Mname + '\'' +
                ", Mess='" + Mess + '\'' +
                ", Mtime=" + Mtime +
                ", Mflag=" + Mflag +
                ", Mtitle='" + Mtitle + '\'' +
                ", Mapply='" + Mapply + '\'' +
                ", Mcheckboy='" + Mcheckboy + '\'' +
                '}';
    }
}
