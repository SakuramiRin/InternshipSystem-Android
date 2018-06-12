package com.example.sakuramirin.loginsignuptest.View.Interface;


import java.io.Serializable;

public interface ILoginView {

    void showProgressDialog(String s);

    void stopProgressDialog();

    void showToast(String s);

    void toMainActivity(Serializable s, int identity);

    void toRegister();


}
