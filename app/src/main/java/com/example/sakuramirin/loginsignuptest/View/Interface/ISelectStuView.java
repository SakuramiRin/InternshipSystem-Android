package com.example.sakuramirin.loginsignuptest.View.Interface;

import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;

import java.util.List;

public interface ISelectStuView {
    void loadList(List<StudentListBean.StudentsBean> studentBeans);
}
