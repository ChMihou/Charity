package com.charity.entity;

import java.io.Serializable;

public class Jsoncheck implements Serializable {

    private int Nid;

    private String Ncheckboy;

    private int Nflag;

    private String Ncause;

    public int getNid() {
        return Nid;
    }

    public void setNid(int nid) {
        Nid = nid;
    }

    public String getNcheckboy() {
        return Ncheckboy;
    }

    public void setNcheckboy(String ncheckboy) {
        Ncheckboy = ncheckboy;
    }

    public int getNflag() {
        return Nflag;
    }

    public void setNflag(int nflag) {
        Nflag = nflag;
    }

    public String getNcause() {
        return Ncause;
    }

    public void setNcause(String ncause) {
        Ncause = ncause;
    }

    @Override
    public String toString() {
        return "Jsoncheck{" +
                "Nid=" + Nid +
                ", Ncheckboy='" + Ncheckboy + '\'' +
                ", Nflag=" + Nflag +
                ", Ncause='" + Ncause + '\'' +
                '}';
    }
}