package com.charity.entity;

import java.io.Serializable;

public class Cabinet implements Serializable {

    private Integer Cid;

    //物品存放点
    private String Caddress;

    //公益柜名称
    private String Cname;

    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String caddress) {
        Caddress = caddress;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "Cid=" + Cid +
                ", Caddress='" + Caddress + '\'' +
                ", Cname='" + Cname + '\'' +
                '}';
    }
}
