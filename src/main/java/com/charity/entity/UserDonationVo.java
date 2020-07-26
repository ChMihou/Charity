package com.charity.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDonationVo implements Serializable {
    private static final long serialVersionUID = -5624495541422738275L;
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

    private Integer Did;

    //捐赠人id
    private Integer Duid;

    //捐款
    private String Dmoney;

    //捐赠物品
    private String Donations;

    //捐赠品流向
    private  String Daddress;

    //与那个慈善活动有关编号
    private Integer Dnid;

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

    public Integer getDid() {
        return Did;
    }

    public void setDid(Integer did) {
        Did = did;
    }

    public Integer getDuid() {
        return Duid;
    }

    public void setDuid(Integer duid) {
        Duid = duid;
    }

    public String getDmoney() {
        return Dmoney;
    }

    public void setDmoney(String dmoney) {
        Dmoney = dmoney;
    }

    public String getDonations() {
        return Donations;
    }

    public void setDonations(String donations) {
        Donations = donations;
    }

    public String getDaddress() {
        return Daddress;
    }

    public void setDaddress(String daddress) {
        Daddress = daddress;
    }

    public Integer getDnid() {
        return Dnid;
    }

    public void setDnid(Integer dnid) {
        Dnid = dnid;
    }

    @Override
    public String toString() {
        return "UserDonationVo{" +
                "Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Uiphone='" + Uiphone + '\'' +
                ", Uemail='" + Uemail + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Username='" + Username + '\'' +
                ", Udatetime=" + Udatetime +
                ", Uaddress='" + Uaddress + '\'' +
                ", Did=" + Did +
                ", Duid=" + Duid +
                ", Dmoney='" + Dmoney + '\'' +
                ", Donations='" + Donations + '\'' +
                ", Daddress='" + Daddress + '\'' +
                ", Dnid=" + Dnid +
                '}';
    }
}
