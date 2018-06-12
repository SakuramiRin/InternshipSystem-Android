package com.example.sakuramirin.loginsignuptest.Beans;

import java.io.Serializable;

public class TeacherBean implements Serializable {
    private String tname;
    private String tno;
    private String  tsex;
    private String tmobile;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private String error;


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTmobile() {
        return tmobile;
    }

    public void setTmobile(String tmobile) {
        this.tmobile = tmobile;
    }
}
