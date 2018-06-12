package com.example.sakuramirin.loginsignuptest.Modle;

import android.util.Log;


import com.example.sakuramirin.loginsignuptest.Beans.CourseListBean;
import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ICourseModel;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sakuramirin.loginsignuptest.Commons.Net.BASE_URL;

public class CourseModel implements ICourseModel {
    @Override
    public Call<CourseListBean> CourseByGet(String username) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ICourseModel.class).CourseByGet(username);
    }

    @Override
    public Call<ResultBean> DeleteCourseByGet(String courseName, String sid) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ICourseModel.class).DeleteCourseByGet(courseName,sid);
    }
}
