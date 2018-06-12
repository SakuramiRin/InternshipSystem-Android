package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.AddNoticeModel;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddNoticeModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddNoticePresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddNoticeView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNoticePresenter implements IAddNoticePresenter {
    private IAddNoticeModel iAddNoticeModel;
    private IAddNoticeView iAddNoticeView;

    public AddNoticePresenter(IAddNoticeView iAddNoticeView){
        this.iAddNoticeView = iAddNoticeView;
        this.iAddNoticeModel = new AddNoticeModel();
    }


    @Override
    public void toAddNotice(String title, String content,String tno) {


        iAddNoticeModel.addNoticeByPost(title, content,tno ).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {
                Log.e("toAddNotice", "onResponse: "+response );
                if (Objects.requireNonNull(response.body()).getResult().equals("success")) {
//                if (response.body().getResult().equals("success")) {
                    iAddNoticeView.showToast("发布成功");
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                Log.e("toAddNotice", "onFailure: "+t );
            }
        });
    }
}
