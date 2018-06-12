package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddDetailsModel;
import com.example.sakuramirin.loginsignuptest.Modle.AddDetailsModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddDetailsPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddDetailsView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDetailsPresent implements IAddDetailsPresenter {

    private IAddDetailsView mStudentDetailsView;
    private IAddDetailsModel mStudentDetailsModel;

    public AddDetailsPresent(IAddDetailsView iStudentDetailsView) {
        this.mStudentDetailsView = iStudentDetailsView;
        this.mStudentDetailsModel = new AddDetailsModel();
    }

    @Override
    public void doStudentDetails(String sno, String sname, String sqq, String sdept, Integer sage, Integer ssex) {


        mStudentDetailsModel.studentDetailsByPost(sno, sname, sqq, sdept, sage, ssex).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
                Log.e("AddDetailsPresent", "onResponse: "+response );
                if (Objects.requireNonNull(response.body()).getResult().equals("succes")) {
//                if (response.body().getResult().equals("succes")) {
                    mStudentDetailsView.showToast("学生信息添加成功");
                    mStudentDetailsView.backToLogin();
                }
                else {
                    mStudentDetailsView.showToast("学生信息添加失败");
                    mStudentDetailsView.backToLogin();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                Log.d("sdp", "onFailure: "+t);
            }
        });

    }
    @Override
    public void doTeacherDetails(String tno, String tname, String qq, Integer tsex) {
        mStudentDetailsModel.teacherDetailsByPost(tno, tname, qq, tsex).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
//                if (Objects.requireNonNull(response.body()).getResult().equals("succes")) {
                Log.e("填写详情", "onResponse: "+response );
                if (response.isSuccessful()) {
                    Log.e("教师注册信息", "onResponse: "+response.body() );
                    if (response.body().getResult().equals("success")) {
                        mStudentDetailsView.showToast("教师信息添加成功");
                        mStudentDetailsView.backToLogin();
                    } else {
                        mStudentDetailsView.showToast("教师信息添加失败");
                        mStudentDetailsView.backToLogin();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                Log.d("sdp", "onFailure: "+t);
            }
        });
    }

}
