package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Beans.TeacherBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ILoginModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sakuramirin.loginsignuptest.Commons.Net.BASE_URL;


public class LoginModel implements ILoginModel {

    @Override
    public Call<StudentBean> studentLoginByPost(String phone, String password, Integer identity) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit.create(ILoginModel.class).studentLoginByPost(phone, password, identity);
    }

    @Override
    public Call<TeacherBean> teacherLoginByPost(String phone, String password, Integer identity) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILoginModel.class).teacherLoginByPost(phone, password, identity);
    }

}
