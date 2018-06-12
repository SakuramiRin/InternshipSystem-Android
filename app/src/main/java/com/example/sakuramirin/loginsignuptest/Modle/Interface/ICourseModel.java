package com.example.sakuramirin.loginsignuptest.Modle.Interface;


import com.example.sakuramirin.loginsignuptest.Beans.CourseListBean;
import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;


public interface ICourseModel {
        @FormUrlEncoded
        @POST("getStudentCourse.action")
        Call<CourseListBean> CourseByGet(@Field("cstudent") String username);

        @FormUrlEncoded
        @POST("deleteCourse.action")
        Call<ResultBean> DeleteCourseByGet(@Field("cstudent") String courseName,@Field("cname") String sid);
}
