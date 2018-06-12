package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddNoticeModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sakuramirin.loginsignuptest.Commons.Net.BASE_URL;

public class AddNoticeModel implements IAddNoticeModel {
    @Override
    public Call<ResultBean> addNoticeByPost(String noticeTitle, String noticeContent, String publisher) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IAddNoticeModel.class).addNoticeByPost(noticeTitle, noticeContent, publisher);
    }

}
