package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sakuramirin.loginsignuptest.Beans.NoticeListBean;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.INoticeListPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.NoticeListPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.INoticeListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeListActivity extends AppCompatActivity implements INoticeListView{

    private INoticeListPresenter mNoticeListPresenter;
    private LinearLayoutManager mLinearLayoutManager;

    private List<NoticeListBean.NoticeBean> noticeBeans;

    private String tno;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_notice_menu:
                startActivity(new Intent(this,AddNoticeActivity.class).putExtra("tno", tno));
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notice_menu_layout,menu);
        if (tno == null) {
            menu.findItem(R.id.add_notice_menu).setVisible(false);
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);

        Toolbar toolbar = findViewById(R.id.notice_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        findViewById(R.id.homeAsUp).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        Intent intent = getIntent();
        tno = intent.getStringExtra("tno");

        Log.d("通知传递", "onCreate: "+tno);

        ButterKnife.bind(this);

        mNoticeListPresenter = new NoticeListPresenter(this);
        mNoticeListPresenter.loadView();
//
//        INoticeListModel iNoticeListModel = new NoticeListModel();
//        iNoticeListModel.loadNoticeByGet().enqueue(new Callback<NoticeListBean>() {
//            @Override
//            public void onResponse(Call<NoticeListBean> call, Response<NoticeListBean> response) {
//                if (response.isSuccessful()) {
//                    NoticeListBean noticeListBean = response.body();
//                    List<NoticeListBean.NoticeBean> list = noticeListBean.getResponse();
//                    String result = "";
//                    for (NoticeListBean.NoticeBean noticeBean : list) {
//                        result += noticeBean.getTitile();
//                    }
//                    Log.e("通知表", "onResponse: " + result);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NoticeListBean> call, Throwable t) {
//
//            }
//        });

    }

    @Override
    public void addNotice() {
        Log.e("!!!!!!!!!!!", "addNotice: !!!!!!!" );
    }



//    private void initNotice() {
//        Notice notice1 = new Notice("入院通知","2018.5.18","欢迎大家前来实习");
//        noticeBeans.add(notice1);
//        Notice notice2 = new Notice("宿舍安排","2018.5.18","请大家注意宿舍安排，然后拿好宿舍钥匙进行分配");
//        noticeBeans.add(notice2);
//        Notice notice3 = new Notice("测试标题1","测试时间1","测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，");
//        noticeBeans.add(notice3);
//        Notice notice4 = new Notice("测试标题2","测试时间2","测试内容，测试内容，测试内容，测试内容，测试内容，测试内容");
//        noticeBeans.add(notice4);
//        Notice notice5 = new Notice("测试标题3","测试时间3","测试内容，测试内容");
//        noticeBeans.add(notice5);
//        Notice notice6 = new Notice("测试标题4","测试时间4","测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容，测试内容");
//        noticeBeans.add(notice6);
//        Notice notice7 = new Notice("1","131111","664654");
//        noticeBeans.add(notice7);
//        Notice notice8 = new Notice("1","131111","664654");
//        noticeBeans.add(notice8);
//        Notice notice9 = new Notice("1","131111","664654");
//        noticeBeans.add(notice9);
//    }


    @Override
    public void  getNoticeListBean(List<NoticeListBean.NoticeBean> noticeBeans) {
        this.noticeBeans = noticeBeans;
        Log.e("544454", "getNoticeListBean: 已调用get"+noticeBeans );
        Log.e("执行了吗？", "onCreate: "+noticeBeans);
        RecyclerView recyclerView = findViewById(R.id.notice_list);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        NoticeAdapter adapter = new NoticeAdapter(R.layout.item_notice_layout,noticeBeans);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recyclerView.setAdapter(adapter);
    }
}
