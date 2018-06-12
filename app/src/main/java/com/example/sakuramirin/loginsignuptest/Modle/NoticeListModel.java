package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.INoticeListModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sakuramirin.loginsignuptest.Commons.Net.BASE_URL;

public class NoticeListModel implements INoticeListModel {

    @Override
    public Call<NoticeListBean> loadNoticeByGet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(INoticeListModel.class).loadNoticeByGet();
    }
}
