package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserCommentNoticeVo implements Serializable {

    private static final long serialVersionUID = 5351000356807883825L;

    private Integer cid;

    private String comment;

    private Integer cnid;

    private Integer cuid;

    private String capply;

    private Timestamp ctime;

    //是否回复
    private Integer cflag;

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

    private String Caboy;

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

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public Integer getNmoney() {
        return Nmoney;
    }

    public void setNmoney(Integer nmoney) {
        Nmoney = nmoney;
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

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    @Override
    public String toString() {
        return "UserCommentNoticeVo{" +
                "cid=" + cid +
                ", comment='" + comment + '\'' +
                ", cnid=" + cnid +
                ", cuid=" + cuid +
                ", capply='" + capply + '\'' +
                ", ctime=" + ctime +
                ", cflag=" + cflag +
                ", Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                ", uimage='" + uimage + '\'' +
                ", Caboy='" + Caboy + '\'' +
                ", Nid=" + Nid +
                ", Ntitle='" + Ntitle + '\'' +
                ", Ncheckboy='" + Ncheckboy + '\'' +
                ", Narticle='" + Narticle + '\'' +
                ", Ntime=" + Ntime +
                ", Nflag=" + Nflag +
                ", Nauthor='" + Nauthor + '\'' +
                ", Nselect=" + Nselect +
                ", Money=" + Money +
                ", Nmoney=" + Nmoney +
                ", Ncause='" + Ncause + '\'' +
                ", Nimage='" + Nimage + '\'' +
                '}';
    }
}
