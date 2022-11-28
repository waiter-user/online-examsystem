package com.java.vo;

import com.java.pojo.Subject;

public class SubjectVO extends Subject {
    //单选试题学生的答案
    private String studentkey;

    public SubjectVO() {
    }

    public SubjectVO(String studentkey) {
        this.studentkey = studentkey;
    }

    public String getStudentkey() {
        return studentkey;
    }

    public void setStudentkey(String studentkey) {
        this.studentkey = studentkey;
    }

    @Override
    public String toString() {
        return "SubjectVO{" +
                "studentkey='" + studentkey + '\'' +
                '}';
    }
}
