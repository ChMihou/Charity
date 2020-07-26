package com.charity.entity;

import java.io.Serializable;

public class Donation implements Serializable {


    private static final long serialVersionUID = 7493861218267417604L;

    private Integer Did;

    //捐赠人id
    private Integer Duid;

    //捐款
    private Integer Dmoney;

    //捐赠物品
    private String Donations;

    //捐赠品流向
    private  String Daddress;

    //与那个慈善活动有关编号
    private Integer Dnid;

    private Integer Dsid;


    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getDmoney() {
        return Dmoney;
    }

    public void setDmoney(Integer dmoney) {
        Dmoney = dmoney;
    }

    public Integer getDsid() {
        return Dsid;
    }

    public void setDsid(Integer dsid) {
        Dsid = dsid;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "Did=" + Did +
                ", Duid=" + Duid +
                ", Dmoney=" + Dmoney +
                ", Donations='" + Donations + '\'' +
                ", Daddress='" + Daddress + '\'' +
                ", Dnid=" + Dnid +
                ", Dsid=" + Dsid +
                '}';
    }
}
