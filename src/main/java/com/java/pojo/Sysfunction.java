package com.java.pojo;

import java.io.Serializable;

public class Sysfunction implements Serializable {
    private Integer funid;

    private String funname;

    private String funurl;

    private Integer funpid;

    private Integer funstate;
    //父功能名称
    private String parentFunname;
    //与权限是当前的角色关联的权限时，就被勾选，checked值时true
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private static final long serialVersionUID = 1L;

    public Integer getFunid() {
        return funid;
    }

    public void setFunid(Integer funid) {
        this.funid = funid;
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname == null ? null : funname.trim();
    }

    public String getFunurl() {
        return funurl;
    }

    public void setFunurl(String funurl) {
        this.funurl = funurl == null ? null : funurl.trim();
    }

    public Integer getFunpid() {
        return funpid;
    }

    public void setFunpid(Integer funpid) {
        this.funpid = funpid;
    }

    public Integer getFunstate() {
        return funstate;
    }

    public void setFunstate(Integer funstate) {
        this.funstate = funstate;
    }

    public String getParentFunname() {
        if(this.parentFunname==null){
            return "无";
        }
        return parentFunname;
    }

    /**
     * 获取功能状态的字符串
     * @return
     */
    public String getstateStr() {
        if(funstate==1){
            return "正常";
        }else{
            return "禁用";
        }

    }
    public void setParentFunname(String parentFunname) {
        this.parentFunname = parentFunname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", funid=").append(funid);
        sb.append(", funname=").append(funname);
        sb.append(", funurl=").append(funurl);
        sb.append(", funpid=").append(funpid);
        sb.append(", funstate=").append(funstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}