package com.example.sakuramirin.loginsignuptest.Beans;

import java.util.List;

public class StudentListBean {

    private List<StudentsBean> students;

    @Override
    public String toString() {
        return "StudentListBean{" +
                "students=" + students +
                '}';
    }

    public List<StudentsBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsBean> students) {
        this.students = students;
    }

    public static class StudentsBean {
        @Override
        public String toString() {
            return "StudentsBean{" +
                    "sno='" + sno + '\'' +
                    ", sname='" + sname + '\'' +
                    ", ssex=" + ssex +
                    ", sdept='" + sdept + '\'' +
                    ", qq='" + qq + '\'' +
                    ", sage=" + sage +
                    '}';
        }

        /**
         * sno : 20141111
         * sname : a
         * ssex : 0
         * sdept : sss
         * qq : 17862912773
         * sage : 12
         */

        private String sno;
        private String sname;
        private int ssex;
        private String sdept;
        private String qq;
        private int sage;

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

        public int getSsex() {
            return ssex;
        }

        public void setSsex(int ssex) {
            this.ssex = ssex;
        }

        public String getSdept() {
            return sdept;
        }

        public void setSdept(String sdept) {
            this.sdept = sdept;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public int getSage() {
            return sage;
        }

        public void setSage(int sage) {
            this.sage = sage;
        }
    }
}
