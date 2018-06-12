package com.example.sakuramirin.loginsignuptest.View.Acitvity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.Main2Activity;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ILoginPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.LoginPresenter;
import com.example.sakuramirin.loginsignuptest.R;
import com.example.sakuramirin.loginsignuptest.View.Interface.ILoginView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    private ILoginPresenter mLoginPresenter;
    private ProgressDialog progressDialog;

    @BindView(R.id.login_phone)
    EditText mPhoneText;

    @BindView(R.id.login_password)
    EditText mPasswordText;

    @OnClick(R.id.to_register_student)
    public void Register(){
        toRegister();
    }

    @OnClick(R.id.teacher_login)
    public void toTLogin(){
        String phone = mPhoneText.getText().toString();
        String password = mPasswordText.getText().toString();
        mLoginPresenter.toLogin(phone, password, 1, LoginActivity.this);
    }

    @OnClick(R.id.student_login)
    public void toSLogin(){
        String phone = mPhoneText.getText().toString();
        String password = mPasswordText.getText().toString();
        mLoginPresenter.toLogin(phone, password, 2, LoginActivity.this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);//开源框架ButterKnife依赖注入声明

        mLoginPresenter = new LoginPresenter(this);


    }

    @Override
    public void showProgressDialog(String s) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
       progressDialog.setMessage(s);
       progressDialog.setCanceledOnTouchOutside(false);
       progressDialog.show();

    }

    @Override
    public void stopProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity(Serializable o, int identity){
        startActivity(new Intent(this, Main2Activity.class).putExtra("identity",identity).putExtra("data",o));
        finish();
    }

    @Override
    public void toRegister() {
        startActivity(new Intent(this,RegisterActivity.class));
    }



}
