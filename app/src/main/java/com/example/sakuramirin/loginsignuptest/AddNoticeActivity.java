package com.example.sakuramirin.loginsignuptest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.Presenter.AddNoticePresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddNoticePresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddNoticeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNoticeActivity extends AppCompatActivity implements IAddNoticeView{

    private IAddNoticePresenter iAddNoticePresenter;

    private String tno;

    @BindView(R.id.notice_title)
    EditText etNoticeTitle;
    @BindView(R.id.notice_content)
    EditText etNoticeContent;
    @BindView(R.id.add_notice_button)
    Button addNoticeButton;
    @SuppressLint("SimpleDateFormat")
    @OnClick(R.id.add_notice_button)
    public void init(){
        String noticeTitle = etNoticeTitle.getText().toString();
        String noticeContent = etNoticeContent.getText().toString();
        Log.e("添加通知", "init: "+ noticeTitle + noticeContent +tno);
        iAddNoticePresenter.toAddNotice(noticeTitle, noticeContent,tno);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        Intent intent = getIntent();
       tno = intent.getStringExtra("tno");
        Log.d("tno!!!!!!!", "onCreate: "+tno);

        iAddNoticePresenter = new AddNoticePresenter(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
