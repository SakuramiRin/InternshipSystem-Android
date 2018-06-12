package com.example.sakuramirin.loginsignuptest.Modle.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.ResultBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IAddDetailsModel {
    @FormUrlEncoded
    @POST("saveStudent.action")
    Call<ResultBean> studentDetailsByPost(@Field("sno") String sno, @Field("sname") String sname,@Field("qq") String qq,
                                          @Field("sdept") String sdept, @Field("sage") Integer sage, @Field("ssex") Integer ssex);

    @FormUrlEncoded
    @POST("saveTeacher.action")
    Call<ResultBean> teacherDetailsByPost(@Field("tno") String tno, @Field("tname") String tname,@Field("qq") String qq,
                                           @Field("tsex") Integer tsex);
}
