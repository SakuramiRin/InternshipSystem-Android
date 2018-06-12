package com.example.sakuramirin.loginsignuptest.Presenter.Interface;

public interface IAddDetailsPresenter {
    void doStudentDetails(String sno, String sname,String sqq,String sdept, Integer sage,Integer ssex);

    void doTeacherDetails(String sno, String sname,String sqq, Integer ssex);
}
