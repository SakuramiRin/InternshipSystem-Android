package com.example.sakuramirin.loginsignuptest.View.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.CourseListBean;

public interface ICourseView {
    void createLeftView(CourseListBean.CourseBean courseBean);

    void createCourseView(CourseListBean.CourseBean courseBean);

    void showToast(String s);
}
