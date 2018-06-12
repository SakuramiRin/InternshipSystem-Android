package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Beans.TeacherBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ILoginModel {
    @FormUrlEncoded
    @POST("login.action")
    Call<StudentBean> studentLoginByPost(@Field("user_code") String phone, @Field("user_password") String password, @Field("identity") Integer identity);

    @FormUrlEncoded
    @POST("login.action")
    Call<TeacherBean> teacherLoginByPost(@Field("user_code") String phone, @Field("user_password") String password, @Field("identity") Integer identity);
}
