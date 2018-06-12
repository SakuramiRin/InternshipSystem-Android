package com.example.sakuramirin.loginsignuptest;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;
import com.example.sakuramirin.loginsignuptest.Beans.StudentListBean;

import java.util.List;

public class SelectStudentAdapter extends BaseQuickAdapter<StudentListBean.StudentsBean,BaseViewHolder> {

    SelectStudentAdapter(int layoutResId, @Nullable List<StudentListBean.StudentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StudentListBean.StudentsBean item) {
        helper.setText(R.id.student_name,item.getSname());
    }
}
