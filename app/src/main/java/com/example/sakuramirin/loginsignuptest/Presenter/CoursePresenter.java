package com.example.sakuramirin.loginsignuptest.Presenter;

import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.CourseListBean;
import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;
import com.example.sakuramirin.loginsignuptest.Modle.CourseModel;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.ICourseModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ICoursePresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.ICourseView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursePresenter implements ICoursePresenter {
    private ICourseModel mCourseModel;
    private ICourseView mCourseView;

    public CoursePresenter(ICourseView iCourseView) {
        this.mCourseView = iCourseView;
        this.mCourseModel = new CourseModel();
    }


    @Override
    public void getCourseList(String sid) {
        Log.d("课程传入", "getCourseList: "+sid);
        mCourseModel.CourseByGet(sid).enqueue(new Callback<CourseListBean>() {
            @Override
            public void onResponse(Call<CourseListBean> call, Response<CourseListBean> response) {
                Log.e("课程P层", "onResponse: "+response.body() );
                if (response.isSuccessful()) {
                    CourseListBean courseListBean = response.body();
                    List<CourseListBean.CourseBean> courseBeanList = courseListBean.getCourse();
                    for (CourseListBean.CourseBean courseBean : courseBeanList){
                        mCourseView.createLeftView(courseBean);
                        mCourseView.createCourseView(courseBean);
                    }
                }
            }

            @Override
            public void onFailure(Call<CourseListBean> call, Throwable t) {
                Log.d("错误？", "onFailure: "+t);
            }
        });
    }

    @Override
    public void deleteCourse(String courseName, String sid) {
        mCourseModel.DeleteCourseByGet(courseName, sid).enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(Call<ResultBean> call, Response<ResultBean> response) {
                if (response.isSuccessful()) {
                    if (response.body().toString().equals("succes")){
                        mCourseView.showToast("删除成功");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultBean> call, Throwable t) {

            }
        });
    }
}
