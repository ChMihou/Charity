package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notice implements Serializable {

    private static final long serialVersionUID = 2535011012687476707L;

    private Integer Nid;

    //题目
    private String Ntitle;

    //审核人
    private String Ncheckboy;

    //文章
    private String Narticle;

    //发布时间
    private Timestamp Ntime;

    //标志是否审核 2未通过审核，1通过审核，0未审核，3草稿
    private Integer  Nflag;

    //作者
    private String Nauthor;

    //标志发布类型 0为新闻，1为帮助新闻
    int Nselect;

    //目标筹款
    private  Integer Money;

    //得到的资助款
    private Integer Nmoney;

    //审核不通过原因
    private String Ncause;

    //文章开篇图
    private String Nimage;

    private String Nintro;

    public String getNintro() {
        return Nintro;
    }

    public void setNintro(String nintro) {
        Nintro = nintro;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNid() {
        return Nid;
    }

    public void setNid(Integer nid) {
        Nid = nid;
    }

    public String getNtitle() {
        return Ntitle;
    }

    public void setNtitle(String ntitle) {
        Ntitle = ntitle;
    }

    public String getNcheckboy() {
        return Ncheckboy;
    }

    public void setNcheckboy(String ncheckboy) {
        Ncheckboy = ncheckboy;
    }

    public String getNarticle() {
        return Narticle;
    }

    public void setNarticle(String narticle) {
        Narticle = narticle;
    }

    public Timestamp getNtime() {
        return Ntime;
    }

    public void setNtime(Timestamp ntime) {
        Ntime = ntime;
    }

    public Integer getNflag() {
        return Nflag;
    }

    public void setNflag(Integer nflag) {
        Nflag = nflag;
    }

    public String getNauthor() {
        return Nauthor;
    }

    public void setNauthor(String nauthor) {
        Nauthor = nauthor;
    }

    public int getNselect() {
        return Nselect;
    }

    public void setNselect(int nselect) {
        Nselect = nselect;
    }

    public String getNcause() {
        return Ncause;
    }

    public void setNcause(String ncause) {
        Ncause = ncause;
    }

    public String getNimage() {
        return Nimage;
    }

    public void setNimage(String nimage) {
        Nimage = nimage;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        this.Money = money;
    }

    public Integer getNmoney() {
        return Nmoney;
    }

    public void setNmoney(Integer nmoney) {
        Nmoney = nmoney;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "Nid=" + Nid +
                ", Ntitle='" + Ntitle + '\'' +
                ", Ncheckboy='" + Ncheckboy + '\'' +
                ", Narticle='" + Narticle + '\'' +
                ", Ntime=" + Ntime +
                ", Nflag=" + Nflag +
                ", Nauthor='" + Nauthor + '\'' +
                ", Nselect=" + Nselect +
                ", money=" + Money +
                ", Nmoney=" + Nmoney +
                ", Ncause='" + Ncause + '\'' +
                ", Nimage='" + Nimage + '\'' +
                '}';
    }
}
