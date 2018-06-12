package com.example.sakuramirin.loginsignuptest;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;

import java.util.List;

public class NoticeAdapter extends BaseQuickAdapter<NoticeListBean.NoticeBean, BaseViewHolder>{
    NoticeAdapter(int layoutResId, @Nullable List<NoticeListBean.NoticeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeListBean.NoticeBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_time, item.getPdate());
    }


}
