package com.example.sakuramirin.loginsignuptest.Presenter;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Beans.TeacherBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ILoginModel;
import com.example.sakuramirin.loginsignuptest.Modle.LoginModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ILoginPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.ILoginView;
import com.example.sakuramirin.loginsignuptest.utils.NetWorkUtils;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel mLoginModel;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.mLoginView = iLoginView;
        this.mLoginModel = new LoginModel();
    }

    @Override
    public void toLogin(String phone, String password, final Integer identity, final Context context) {
        if (!loginCheckOut(phone, password)) {
            return;
        }
        if (NetWorkUtils.isNetWorkConnected(context)) {
            mLoginView.showToast("网络未连接");
            return;
        }
        mLoginView.showProgressDialog("网络加载中，请稍后...");

        if (identity == 2) {
            mLoginModel.studentLoginByPost(phone, password, identity)
                    .enqueue(new Callback<StudentBean>() {
                        @Override
                        public void onResponse(@NonNull Call<StudentBean> call, @NonNull Response<StudentBean> response) {
                            Log.d("toLogin", "onResponse: "+response);
                            if (response.isSuccessful()) {
                                if (response.body().getError() != null) {
                                    String error = response.body().getError();
                                    mLoginView.showToast("登录失败，请重试"+error);
                                    mLoginView.stopProgressDialog();
                                } else {
                                    Log.e("studentLoginByPost", "onResponse: " + response.body().toString());
                                    mLoginView.showToast("登录成功");
                                    mLoginView.stopProgressDialog();
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("class",response.body());
                                    mLoginView.toMainActivity(response.body(),identity);
                                }

                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<StudentBean> call, @NonNull Throwable t) {
                            Log.d("toLogin", "onFailure " + t);
                            mLoginView.showToast("网络连接失败");
                            mLoginView.stopProgressDialog();
                        }
                    });

        } else if (identity == 1) {
            mLoginModel.teacherLoginByPost(phone, password, identity)
                    .enqueue(new Callback<TeacherBean>() {
                        @Override
                        public void onResponse(@NonNull Call<TeacherBean> call, @NonNull Response<TeacherBean> response) {
                            Log.e("Identity!!!!!", "onResponse: "+identity );
                            Log.e("jiaoshi!!!!!", "onResponse: "+response );
                            if (response.body() != null) {
                                if (response.body().getError() != null) {
                                    String error = response.body().getError();
                                    mLoginView.showToast(error);
                                    mLoginView.stopProgressDialog();
                                } else {
                                    Log.e("response!!!!!!!!!8", "onResponse: " + response.body().toString());
                                    TeacherBean teacherBean = response.body();
                                    mLoginView.showToast("教师登录成功");
                                    mLoginView.stopProgressDialog();
                                    mLoginView.toMainActivity(teacherBean,identity);
                                }

                            } else {
                                Log.e("response!!!!!!!!!0", "onResponse: " + response.body());
                                mLoginView.showToast("教师登录失败，请重试");
                                mLoginView.stopProgressDialog();
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<TeacherBean> call, @NonNull Throwable t) {
                            Log.d("login", "失败 " + t);
                            mLoginView.showToast("教师网络连接失败");
                            mLoginView.stopProgressDialog();
                        }
                    });
        }
    }
    //根据EditText获得输入本文，并进行本地检验，如通过传递至Model层进行网络处理，回调函数内成功则进入主界面
    private boolean loginCheckOut(String phone, String password) {
        String regExp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";

        if (TextUtils.isEmpty(phone) && mLoginView != null) {
            mLoginView.showToast("用户名不能为空");
            return false;
        }
        if (TextUtils.isEmpty(password) && mLoginView != null) {
            mLoginView.showToast("密码不能为空");
            return false;
        }
        if (!Pattern.compile(regExp).matcher(phone).find()) {
            mLoginView.showToast("手机号不正确");
            return false;
        }
        return true;
    }
    //输入的本地检验与网络检验
}
