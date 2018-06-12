package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Commons.Net;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddCourseModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddCourseMode implements IAddCourseModel {
    @Override
    public Call<ResultBean> addCourseByPost(String courseName, String teacher, String classRoom,String day, String start, String end, String sid) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return retrofit.create(IAddCourseModel.class).addCourseByPost(courseName, teacher, classRoom,day, start, end, sid);
    }
}
