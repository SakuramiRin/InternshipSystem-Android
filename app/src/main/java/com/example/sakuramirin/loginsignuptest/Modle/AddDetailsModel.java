package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Commons.Net;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddDetailsModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddDetailsModel implements IAddDetailsModel {
    @Override
    public Call<ResultBean> studentDetailsByPost(String sno, String sname, String qq, String sdept, Integer sage, Integer ssex) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return retrofit.create(IAddDetailsModel.class).studentDetailsByPost(sno, sname, qq, sdept, sage, ssex);
    }

    @Override
    public Call<ResultBean> teacherDetailsByPost(String tno, String tname, String qq, Integer tsex) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return  retrofit.create(IAddDetailsModel.class).teacherDetailsByPost(tno,tname,qq,tsex);
    }
}
