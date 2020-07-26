package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Email implements Serializable {
    private static final long serialVersionUID = -2093205067046948062L;

    private Integer Eid;

    private String Email;

    private String Eusername;

    private String Emess;

    private String Esubject;

    private Timestamp Etime;

    private String Esenduser;

    public String getEsenduser() {
        return Esenduser;
    }

    public void setEsenduser(String esenduser) {
        Esenduser = esenduser;
    }

    public Timestamp getEtime() {
        return Etime;
    }

    public void setEtime(Timestamp etime) {
        Etime = etime;
    }

    public String getEsubject() {
        return Esubject;
    }

    public void setEsubject(String esubject) {
        Esubject = esubject;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEid() {
        return Eid;
    }

    public void setEid(Integer eid) {
        Eid = eid;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEusername() {
        return Eusername;
    }

    public void setEusername(String eusername) {
        Eusername = eusername;
    }

    public String getEmess() {
        return Emess;
    }

    public void setEmess(String emess) {
        Emess = emess;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Eid=" + Eid +
                ", Email='" + Email + '\'' +
                ", Eusername='" + Eusername + '\'' +
                ", Emess='" + Emess + '\'' +
                ", Esubject='" + Esubject + '\'' +
                ", Etime=" + Etime +
                ", Esenduser='" + Esenduser + '\'' +
                '}';
    }
}
