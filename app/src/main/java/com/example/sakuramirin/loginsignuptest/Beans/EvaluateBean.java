package com.example.sakuramirin.loginsignuptest.Beans;

import java.io.Serializable;

public class EvaluateBean implements Serializable{
    private String tno;
    private String content;
    private Integer star;
    private String sno;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
