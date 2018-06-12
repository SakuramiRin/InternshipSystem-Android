package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Commons.Net;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IPersonalModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalModel implements IPersonalModel {
    @Override
    public Call<ResultBean> changeStuPerByPost(String sno, String sname, String qq, String sdept, Integer sage, Integer ssex) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return retrofit.create(IPersonalModel.class).changeStuPerByPost(sno, sname, qq, sdept, sage, ssex);
    }

    @Override
    public Call<ResultBean> changeTeaPerByPost(String tno, String tname, String qq, Integer tsex) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return retrofit.create(IPersonalModel.class).changeTeaPerByPost(tno, tname, qq, tsex);
    }
}
