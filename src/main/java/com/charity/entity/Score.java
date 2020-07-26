package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Score implements Serializable {
    private static final long serialVersionUID = -7734003503255097664L;

    private  Integer Sid;

    private Integer Suid;

    private Timestamp Stime;

    private Integer Score;
    //为何事获得积分
    private String Scause;

    private  String award;


    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSid() {
        return Sid;
    }

    public String getScause() {
        return Scause;
    }

    public void setScause(String scause) {
        Scause = scause;
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

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "Score{" +
                "Sid=" + Sid +
                ", Suid=" + Suid +
                ", Stime=" + Stime +
                ", Score=" + Score +
                ", Scause='" + Scause + '\'' +
                ", award='" + award + '\'' +
                '}';
    }
}
