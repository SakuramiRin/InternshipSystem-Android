package com.example.sakuramirin.loginsignuptest.Modle;

import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ISelectStuModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sakuramirin.loginsignuptest.Commons.Net.BASE_URL;

public class SelectStuModel implements ISelectStuModel {
    @Override
    public Call<StudentListBean> selectStuByGet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ISelectStuModel.class).selectStuByGet();
    }
}
