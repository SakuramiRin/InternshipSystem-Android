package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IPersonalPersenter;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ISelectStuPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.PersonalPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.SelectStuPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.ISelectStuView;

import java.util.ArrayList;
import java.util.List;

public class SelectStuActivity extends AppCompatActivity implements ISelectStuView {

    private ISelectStuPresenter iSelectStuPresenter;
    private List<StudentListBean.StudentsBean> studentBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iSelectStuPresenter = new SelectStuPresenter(this);
        iSelectStuPresenter.getList();
    }

    @Override
    public void loadList(final List<StudentListBean.StudentsBean> studentBeans) {
        this.studentBeans = studentBeans;

        RecyclerView recyclerView = findViewById(R.id.select_student);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        SelectStudentAdapter adapter = new SelectStudentAdapter(R.layout.student_item_layout, studentBeans);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                StudentListBean.StudentsBean studentsBean = studentBeans.get(position);
                Log.d("列表选择", "onItemClick: "+studentsBean.toString());
                StudentBean studentBean = new StudentBean();

                studentBean.setSno(studentsBean.getSno());
                studentBean.setSage(studentsBean.getSage());
                studentBean.setSdept(studentsBean.getSdept());
                studentBean.setSname(studentsBean.getSname());
                studentBean.setSqq(studentsBean.getQq());
                studentBean.setSsex(studentsBean.getSsex());
                studentBean.setError(null);

                startActivity(new Intent(SelectStuActivity.this, PersonalActivity.class).putExtra("data", studentBean));            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
