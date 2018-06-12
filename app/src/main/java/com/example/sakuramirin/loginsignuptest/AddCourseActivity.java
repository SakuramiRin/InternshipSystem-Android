package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.EditText;

import android.widget.Toast;


import com.example.sakuramirin.loginsignuptest.Presenter.AddCoursePresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddCoursePresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddCourseView;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddCourseActivity extends AppCompatActivity implements IAddCourseView{

    private IAddCoursePresenter iAddCoursePresenter;

    @BindView(R.id.course_name)
    EditText inputCourseName;

    @BindView(R.id.teacher_name)
    EditText inputTeacher;

    @BindView(R.id.class_room)
    EditText inputClassRoom;

    @BindView(R.id.week)
    EditText inputDay;

    @BindView(R.id.classes_begin)
    EditText inputStart;

    @BindView(R.id.classes_ends)
    EditText inputEnd;

    private String sid;

    @OnClick(R.id.button)
    public void getIuput(){
        String courseName = inputCourseName.getText().toString();
        String teacher = inputTeacher.getText().toString();
        String classRoom = inputClassRoom.getText().toString();
        String day = inputDay.getText().toString();
        String start = inputStart.getText().toString();
        String end = inputEnd.getText().toString();

        iAddCoursePresenter.ToAddCourse(courseName, teacher, classRoom, day, start, end, sid);

//        startActivity(new Intent(this,CourseActivity.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
//        setFinishOnTouchOutside(false);


        ButterKnife.bind(this);

        iAddCoursePresenter = new AddCoursePresenter(this);


        Intent intent = getIntent();
        sid = intent.getStringExtra("sid");

        Log.e("添加课程", "onCreate: "+sid );

    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void backToCourse() {
//        startActivity(new Intent(this,CourseActivity.class));
//        finish();
    }
}
