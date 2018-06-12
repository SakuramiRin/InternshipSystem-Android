package com.example.sakuramirin.loginsignuptest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;
import com.example.sakuramirin.loginsignuptest.Modle.Interface.INoticeListModel;
import com.example.sakuramirin.loginsignuptest.Modle.NoticeListModel;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.INoticeListPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.INoticeListView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeListPresenter implements INoticeListPresenter {
    private INoticeListModel mNoticeListModel;
    private INoticeListView mNoticeListView;
//    private List<NoticeListBean.NoticeBean> noticeBeans;

    public NoticeListPresenter(INoticeListView iNoticeListView) {
        mNoticeListView = iNoticeListView;
        mNoticeListModel = new NoticeListModel();
    }

    @Override
    public void loadView() {

        mNoticeListModel.loadNoticeByGet().enqueue(new Callback<NoticeListBean>() {

            @Override
            public void onResponse(@NonNull Call<NoticeListBean> call, @NonNull Response<NoticeListBean> response) {
                Log.e("NoticeList返回", "onResponse: "+response.body() );
                if (response.isSuccessful()){
                    NoticeListBean noticeListBean = response.body();
                    Log.e("返回", "onResponse: "+ Objects.requireNonNull(noticeListBean).toString() );
//                    Log.e("返回", "onResponse: "+noticeListBean.toString() );
                    List<NoticeListBean.NoticeBean> noticeBeans = noticeListBean.getNotice();
                    for (NoticeListBean.NoticeBean noticeBean : noticeBeans) {
                        Log.d("noticeBean", "onResponse:"+noticeBean.toString());
                    }
                    mNoticeListView.getNoticeListBean(noticeBeans);
                    mNoticeListView.addNotice();

                }
            }

            @Override
            public void onFailure(@NonNull Call<NoticeListBean> call, @NonNull Throwable t) {
                Log.e("通知列表返回错误", "onFailure: "+t );
            }
        });
    }
}
