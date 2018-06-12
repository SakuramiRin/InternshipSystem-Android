package com.example.sakuramirin.loginsignuptest.View.Interface;

public interface IRegisterView {
    void completeRegister();

    void showToast(String s);

    void showProgressDialog(String s);

    void stopProgressDialog();

    void toTeacherDetails(String number, int identity);

    void toStudentDetails(String number, int identity);
}
