package com.example.sakuramirin.loginsignuptest.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IRegisterModel;
import com.example.sakuramirin.loginsignuptest.Modle.RegisterModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IRegisterPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IRegisterView;
import com.example.sakuramirin.loginsignuptest.utils.NetWorkUtils;


import java.util.Objects;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements IRegisterPresenter {

    private IRegisterView mRegisterView;
    private IRegisterModel mRegisterModel;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.mRegisterView = iRegisterView;
        this.mRegisterModel = new RegisterModel();
    }
    //省略MVP模式构建

    @Override
    public void toRegister(String phone, String password, String passwordAgain, String userName, final String number, final Context context) {
        final int identity;
        if (!Pattern.compile("100\\d{3,7}").matcher(number).find()) {
            identity = 2;
        } else {
            identity = 1;
        }

        if (!registerCheckOut(phone, password, passwordAgain, userName,number)) {
            return;
        }
        if (NetWorkUtils.isNetWorkConnected(context)){
            mRegisterView.showToast("网络未连接");
            return;
        }
        mRegisterView.showProgressDialog("注册中，请稍后...");

        Log.e("!!!!!!!zhi", "toRegister: "+phone+password+userName+number );

        mRegisterModel.registerByPost(phone, password, userName, number,identity).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
                mRegisterView.stopProgressDialog();
                if (Objects.requireNonNull(response.body()).getResult().equals("success")) {
                    mRegisterView.showToast("注册成功");
                    if (identity==1) {
                        mRegisterView.toTeacherDetails(number,identity);
                    }
                    else {
                        mRegisterView.toStudentDetails(number,identity);
                    }
                }
                else {
                    mRegisterView.showToast("注册失败");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                mRegisterView.stopProgressDialog();
                mRegisterView.showToast("连接超时"+t);
            }
        });
    }
    //根据EditText获得文本，并进行本地检验，符合要交则传递Model层进行网络通信，回调一个Result函数，成功则进入详细填写界面
    private boolean registerCheckOut(String phone, String password, String passwordAgain, String userName, String number) {
        String regExp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";


        if (TextUtils.isEmpty(phone) && phone != null) {
            mRegisterView.showToast("用户名不能为空");
            return false;
        }
        if (TextUtils.isEmpty(password) && password != null) {
            mRegisterView.showToast("密码不能为空");
            return false;
        }
        if (TextUtils.isEmpty(passwordAgain) && passwordAgain != null) {
            mRegisterView.showToast("确认密码不能为空");
            return false;
        }
        if (TextUtils.isEmpty(userName) && userName != null) {
            mRegisterView.showToast("昵称不能为空");
            return false;
        }
        if (!Pattern.compile(regExp).matcher(phone).find()) {
            mRegisterView.showToast("手机号不正确");
            return false;
        }
        if (!passwordAgain.equals(password)) {
            mRegisterView.showToast("两次密码不一致");
            return false;
        }
        if (TextUtils.isEmpty(number) && number != null) {
            mRegisterView.showToast("学号不能为空");
            return false;
        }
        return true;
    }
    //输入文本的本地检验和网络检测
}
