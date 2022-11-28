package com.java.vo;

import com.java.pojo.Studentpaper;

import java.sql.Timestamp;

/**
 * 学生让那个答题记录的vo类
 */
public class StudentPaperVO extends Studentpaper {
    private String pname;
    private Integer errorCount;
    private Integer rightCount;
    private String spid;

    public StudentPaperVO(String pname, Integer errorCount, Integer rightCount, String spid) {
        this.pname = pname;
        this.errorCount = errorCount;
        this.rightCount = rightCount;
    }

    public StudentPaperVO() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    @Override
    public String getSpid() {
        return spid;
    }

    @Override
    public void setSpid(String spid) {
        this.spid = spid;
    }

    /**
     * 获取分数的方法
     *
     * @return
     */
    public Integer getSumScore() {
        return rightCount * 2;
    }

    /**
     * 把spid字符串转换成日期时间型
     * @return
     */
    public Timestamp getMinTime() {
        Long time = Long.valueOf(spid);
        return new Timestamp(time);
    }
}
