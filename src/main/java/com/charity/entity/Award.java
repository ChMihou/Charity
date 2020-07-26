package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Award  implements Serializable {

    private static final long serialVersionUID = -2210359608799906662L;

    private Timestamp Atime;

    private Integer Aid;

    private  Integer Auid;

    private String Aname;

    private String Acomment;

    public String getAcomment() {
        return Acomment;
    }

    public void setAcomment(String acomment) {
        Acomment = acomment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        return "Award{" +
                "Atime=" + Atime +
                ", Aid=" + Aid +
                ", Auid=" + Auid +
                ", Aname='" + Aname + '\'' +
                ", Acomment='" + Acomment + '\'' +
                '}';
    }
}
