package com.example.sakuramirin.loginsignuptest.Modle;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Commons.Net;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IRegisterModel;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterModel implements IRegisterModel {

    @Override
    public Call<ResultBean> registerByPost(String account, String password, String username, String number,int identity) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Net.BASE_URL)
                .build();
        return retrofit.create(IRegisterModel.class).registerByPost( account,  password,  username,  number, identity);
    }
}
