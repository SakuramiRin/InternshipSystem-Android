package com.example.sakuramirin.loginsignuptest.View.Acitvity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.ActivityCollector;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity{
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


    public void showProgressDialog(String message) {
        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(this);

        }
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setMessage(message);
            mProgressDialog.show();

    }

    public void stopProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public void showToast(String s){
        Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
    }
}