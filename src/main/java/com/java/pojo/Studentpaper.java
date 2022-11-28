package com.java.pojo;

import java.io.Serializable;

public class Studentpaper implements Serializable {
    private String spid;

    private Integer userid;

    private Integer sid;

    private String studentkey;

    private Integer studentstate;

    private static final long serialVersionUID = 1L;

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid == null ? null : spid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStudentkey() {
        return studentkey;
    }

    public void setStudentkey(String studentkey) {
        this.studentkey = studentkey == null ? null : studentkey.trim();
    }

    public Integer getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(Integer studentstate) {
        this.studentstate = studentstate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spid=").append(spid);
        sb.append(", userid=").append(userid);
        sb.append(", sid=").append(sid);
        sb.append(", studentkey=").append(studentkey);
        sb.append(", studentstate=").append(studentstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}