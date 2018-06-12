package com.example.sakuramirin.loginsignuptest.View.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;

import java.util.List;

public interface INoticeListView {
    void addNotice();

    void  getNoticeListBean(List<NoticeListBean.NoticeBean> noticeBeans);
}
