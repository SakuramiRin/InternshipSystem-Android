package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INoticeListModel {
    @GET("noticeList.action")
    Call<NoticeListBean> loadNoticeByGet();
}
