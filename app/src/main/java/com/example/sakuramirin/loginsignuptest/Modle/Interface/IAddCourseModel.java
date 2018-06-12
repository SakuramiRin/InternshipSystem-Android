package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IAddCourseModel {
    @FormUrlEncoded
    @POST("addCourse.action")
    Call<ResultBean> addCourseByPost(@Field("cname") String courseName, @Field("cteacher") String teacher, @Field("croom") String classRoom, @Field("cday") String cday,@Field("cstart") String start, @Field("cend") String end, @Field("cstudent") String sid );
}
