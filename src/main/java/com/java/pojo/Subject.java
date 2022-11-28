package com.java.pojo;

import java.io.Serializable;

public class Subject implements Serializable {
    private Integer sid;

    private String scontent;

    private String sa;

    private String sb;

    private String sc;

    private String sd;

    private String skey;

    private Integer sstate;

    private static final long serialVersionUID = 1L;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent == null ? null : scontent.trim();
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa == null ? null : sa.trim();
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb == null ? null : sb.trim();
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc == null ? null : sc.trim();
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd == null ? null : sd.trim();
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    public Integer getSstate() {
        return sstate;
    }

    public void setSstate(Integer sstate) {
        this.sstate = sstate;
    }

    public String getstateStr() {
        if (sstate == 1) {
            return "可用";
        } else {
            return "不可用";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", scontent=").append(scontent);
        sb.append(", sa=").append(sa);
        sb.append(", sb=").append(sb);
        sb.append(", sc=").append(sc);
        sb.append(", sd=").append(sd);
        sb.append(", skey=").append(skey);
        sb.append(", sstate=").append(sstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}