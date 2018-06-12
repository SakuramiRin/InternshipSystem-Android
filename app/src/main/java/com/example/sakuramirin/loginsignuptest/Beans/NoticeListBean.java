package com.example.sakuramirin.loginsignuptest.Beans;

import java.util.List;

public class NoticeListBean {
    private List<NoticeBean> notice;

    public List<NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeBean> notice) {
        this.notice = notice;
    }

    public static class NoticeBean {
        /**
         * nid : 36a080d1638233270163823346810000
         * pdate : 2018-05-21 06:16:00.0
         * content : 5151sad
         * title : 5454sa
         * publisher : 55
         */

        private String nid;
        private String pdate;
        private String content;
        private String title;
        private String publisher;

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public String getPdate() {
            return pdate;
        }

        public void setPdate(String pdate) {
            this.pdate = pdate;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @Override
        public String toString() {
            return "NoticeBean{" +
                    "nid='" + nid + '\'' +
                    ", pdate='" + pdate + '\'' +
                    ", content='" + content + '\'' +
                    ", title='" + title + '\'' +
                    ", publisher='" + publisher + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "NoticeListBean{" +
                "notice=" + notice +
                '}';
    }
}
