package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IPersonalModel;
import com.example.sakuramirin.loginsignuptest.Modle.PersonalModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IPersonalPersenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IPersonalView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalPresenter implements IPersonalPersenter {
    private IPersonalView iPersonalView;
    private IPersonalModel iPersonalModel;

    public PersonalPresenter(IPersonalView iPersonalView) {
        this.iPersonalModel = new PersonalModel();
        this.iPersonalView = iPersonalView;
    }



    @Override
    public void changeStuPer(String sno, String sname, String sqq, String sdept, Integer sage, Integer ssex) {
        Log.e("??", "changeStuPer: " );
        iPersonalModel.changeStuPerByPost(sno, sname, sqq, sdept, sage, ssex).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
                Log.e("changeStuPerByPost", "onResponse: "+response);
                if (response.isSuccessful()) {
                    Log.e("修改资料返回", "onResponse: "+ Objects.requireNonNull(response.body()).toString() );
                    if (Objects.requireNonNull(response.body()).getResult().equals("success")) {
                        iPersonalView.showToast("学生信息修改成功");
                        iPersonalView.backToHome();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                Log.e("个人资料请求失败", "onFailure: "+t );
            }
        });
    }

    @Override
    public void changeTeaPer(String sno, String sname, String sqq, Integer ssex) {
        iPersonalModel.changeTeaPerByPost(sno, sname, sqq, ssex).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResult().equals("success")) {
                        iPersonalView.showToast("教师信息修改成功");
                        iPersonalView.backToHome();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                Log.e("个人资料请求失败", "onFailure: "+t );
            }
        });
    }
}
