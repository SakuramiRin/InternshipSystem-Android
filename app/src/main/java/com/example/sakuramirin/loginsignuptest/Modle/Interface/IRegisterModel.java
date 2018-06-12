package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRegisterModel {
    @FormUrlEncoded
    @POST("register.action")
    Call<ResultBean> registerByPost(@Field("user_code") String account, @Field("user_password")
            String password, @Field("user_name") String username, @Field("no") String number, @Field("Identity") int identity);
}
