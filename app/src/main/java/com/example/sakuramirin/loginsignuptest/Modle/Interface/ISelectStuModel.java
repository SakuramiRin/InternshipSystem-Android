package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ISelectStuModel {
    @GET("getAllStudent.action")
    Call<StudentListBean> selectStuByGet();
}
