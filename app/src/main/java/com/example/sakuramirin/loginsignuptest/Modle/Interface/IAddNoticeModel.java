package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IAddNoticeModel {
    @FormUrlEncoded
    @POST("saveNotice.action")
    Call<ResultBean> addNoticeByPost(@Field("title") String noticeTitle, @Field("content") String noticeContent ,@Field("publisher.tno") String publisher);
}
