package com.example.sakuramirin.loginsignuptest.Beans;

import java.util.List;

public class CourseListBean {
    private List<CourseBean> course;

    public List<CourseBean> getCourse() {
        return course;
    }

    public void setCourse(List<CourseBean> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseListBean{" +
                "course=" + course +
                '}';
    }

    public static class CourseBean {

        private Integer cid;
        private String cname;
        private Integer cday;
        private String croom;
        private Integer cstart;
        private Integer cend;
        private String cteacher;
        private String cstudent;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public int getCday() {
            return cday;
        }

        public void setCday(int cday) {
            this.cday = cday;
        }

        public String getCroom() {
            return croom;
        }

        public void setCroom(String croom) {
            this.croom = croom;
        }

        public int getCstart() {
            return cstart;
        }

        public void setCstart(int cstart) {
            this.cstart = cstart;
        }

        public int getCend() {
            return cend;
        }

        public void setCend(int cend) {
            this.cend = cend;
        }

        public String getCteacher() {
            return cteacher;
        }

        public void setCteacher(String cteacher) {
            this.cteacher = cteacher;
        }

        public String getCstudent() {
            return cstudent;
        }

        public void setCstudent(String cstudent) {
            this.cstudent = cstudent;
        }

        @Override
        public String toString() {
            return "CourseBean{" +
                    "cid=" + cid +
                    ", cname='" + cname + '\'' +
                    ", cday=" + cday +
                    ", croom='" + croom + '\'' +
                    ", cstart=" + cstart +
                    ", cend=" + cend +
                    ", cteacher='" + cteacher + '\'' +
                    ", cstudent='" + cstudent + '\'' +
                    '}';
        }
    }

}
