package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
    private static final long serialVersionUID = -2374871443298828740L;

    private Integer cid;

    private String comment;

    private Integer cnid;

    private Integer cuid;

    private String capply;

    private Timestamp ctime;

    private String Caboy;

    //是否回复
    private Integer cflag;


    public String getCaboy() {
        return Caboy;
    }

    public void setCaboy(String caboy) {
        Caboy = caboy;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCnid() {
        return cnid;
    }

    public void setCnid(Integer cnid) {
        this.cnid = cnid;
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public String getCapply() {
        return capply;
    }

    public void setCapply(String capply) {
        this.capply = capply;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Integer getCflag() {
        return cflag;
    }

    public void setCflag(Integer cflag) {
        this.cflag = cflag;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", comment='" + comment + '\'' +
                ", cnid=" + cnid +
                ", cuid=" + cuid +
                ", capply='" + capply + '\'' +
                ", ctime=" + ctime +
                ", Caboy='" + Caboy + '\'' +
                ", cflag=" + cflag +
                '}';
    }
}
