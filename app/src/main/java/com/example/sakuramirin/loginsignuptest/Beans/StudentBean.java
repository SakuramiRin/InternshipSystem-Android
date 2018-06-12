package com.example.sakuramirin.loginsignuptest.Beans;

import java.io.Serializable;

public class StudentBean implements Serializable {

    private String sno;
    private String sname;
    private Integer ssex;
    private String sdept;
    private String qq;
    private  Integer sage;
    private String error;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSsex() {
        return ssex;
    }

    public void setSsex(Integer ssex) {
        this.ssex = ssex;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public String getSqq() {
        return qq;
    }

    public void setSqq(String sqq) {
        this.qq = sqq;
    }


    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }


    @Override
    public String toString() {
        return "StudentBean{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex=" + ssex +
                ", sdept='" + sdept + '\'' +
                ", sqq='" + qq + '\'' +
                ", sage=" + sage +
                ", error='" + error + '\'' +
                '}';
    }
}
