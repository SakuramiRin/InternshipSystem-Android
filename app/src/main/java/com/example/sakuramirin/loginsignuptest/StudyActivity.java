package com.example.sakuramirin.loginsignuptest;

import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import android.widget.Toast;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

public class StudyActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = findViewById(R.id.download_progress);
//        Button button = findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                download();
//            }
//        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                download();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void download() {
        OkHttpUtils
                .get()
                .url("http://182.32.24.144/1.zip")
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "1.zip")//
                {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(StudyActivity.this, "出现错误！！！！！！！！！！！！！！！！！"+e, Toast.LENGTH_SHORT).show();
                        Log.w("!!!!!!", "onError: "+e );
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        Log.d("保存路径", "onResponse: "+Environment.getExternalStorageDirectory().getAbsolutePath());
                        Toast.makeText(StudyActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                        Log.d("!!!!!", "onResponse: "+ Environment.getExternalStorageDirectory().getAbsolutePath());
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                       mProgressBar.setProgress((int) (100 * progress));
                    }
                });
    }

}
