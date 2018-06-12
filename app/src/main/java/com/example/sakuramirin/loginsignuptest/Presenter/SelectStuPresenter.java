package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ISelectStuModel;
import com.example.sakuramirin.loginsignuptest.Modle.SelectStuModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ISelectStuPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.ISelectStuView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectStuPresenter implements ISelectStuPresenter {
    private ISelectStuView iSelectStuView;
    private ISelectStuModel iSelectStuModel;

    public SelectStuPresenter(ISelectStuView iSelectStuView) {
        this.iSelectStuView = iSelectStuView;
        this.iSelectStuModel = new SelectStuModel();
    }


    @Override
    public void getList() {
        iSelectStuModel.selectStuByGet().enqueue(new Callback<StudentListBean>() {
            @Override
            public void onResponse(@NonNull Call<StudentListBean> call, @NonNull Response<StudentListBean> response) {
                if (response.isSuccessful()) {
                    StudentListBean studentListBean = response.body();
                    Log.e("学生列表", "onResponse: "+ Objects.requireNonNull(studentListBean).toString());
                    List<StudentListBean.StudentsBean> studentBeans = studentListBean.getStudents();
                    iSelectStuView.loadList(studentBeans);
                }
            }

            @Override
            public void onFailure(@NonNull Call<StudentListBean> call, @NonNull Throwable t) {
                Log.e("选择学生列表错误", "onFailure: "+t );
            }
        });
    }
}
