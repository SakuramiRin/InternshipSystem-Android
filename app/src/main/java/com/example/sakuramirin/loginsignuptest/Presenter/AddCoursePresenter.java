package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.AddCourseMode;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.IAddCourseModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddCoursePresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddCourseView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCoursePresenter implements IAddCoursePresenter {

    private final String TAG = "AddCoursePresenter";

    private IAddCourseView iAddCourseView;
    private IAddCourseModel iAddCourseModel;

    public AddCoursePresenter(IAddCourseView iAddCourseView) {
        this.iAddCourseView = iAddCourseView;
        this.iAddCourseModel = new AddCourseMode();
    }

    @Override
    public void ToAddCourse(String courseName, String teacher, String classRoom, String day, String start, String end, String sid) {
        if (courseName.equals("") || day.equals("") || start.equals("") || end.equals("")) {
            iAddCourseView.showToast("基本信息未填写完成");
            return;
        }

        iAddCourseModel.addCourseByPost(courseName, teacher, classRoom, day, start, end, sid)
                .enqueue(new Callback<ResultBean>() {
                    @Override
                    public void onResponse(@NonNull Call<ResultBean> call, @NonNull Response<ResultBean> response) {

                        Log.d(TAG, "onResponse: ");

                        if (response.isSuccessful()) {
                            if (Objects.requireNonNull(response.body()).getResult().equals("success")) {
//                            if (response.body().getResult().equals("success")) {
                                iAddCourseView.showToast("课程添加成功");
                                iAddCourseView.backToCourse();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResultBean> call, @NonNull Throwable t) {
                        iAddCourseView.showToast(t.toString());
                    }
                });

    }

}
