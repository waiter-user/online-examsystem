package com.java.vo;

import com.java.pojo.Paper;

/**
 * 封装试卷列表需要展示的 数据
 */
public class PaperVO extends Paper {
    private String pname;
    private Integer totalCount;

    public PaperVO() {
    }

    public PaperVO(String pname, Integer totalCount) {
        this.pname = pname;
        this.totalCount = totalCount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PaperVO{" +
                "pname='" + pname + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }
}
