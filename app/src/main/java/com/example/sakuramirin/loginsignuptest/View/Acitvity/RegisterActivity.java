package com.example.sakuramirin.loginsignuptest.View.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IRegisterPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.RegisterPresenter;
import com.example.sakuramirin.loginsignuptest.R;
import com.example.sakuramirin.loginsignuptest.AddDetailsActivity;
import com.example.sakuramirin.loginsignuptest.View.Interface.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegisterView {

    private IRegisterPresenter mRegisterPresenter;

    @BindView(R.id.register_user_code)
    EditText mCode;

    @BindView(R.id.register_user_password)
    EditText mPassword;

    @BindView(R.id.register_user_password_again)
    EditText mPasswordAgain;

    @BindView(R.id.register_user_name)
    EditText mUserName;

    @BindView(R.id.register_no)
    EditText mNumber;

    @OnClick(R.id.register_button)
    public void Register() {
        String phone = mCode.getText().toString();
        String password = mPassword.getText().toString();
        String passwordAgain = mPasswordAgain.getText().toString();
        String userName = mUserName.getText().toString();
        String number = mNumber.getText().toString();
        mRegisterPresenter.toRegister(phone, password, passwordAgain, userName, number, this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mRegisterPresenter = new RegisterPresenter(this);
//
//        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == mBoy.getId())
//                {
//                    sex = 0;
//                }
//                else
//                {
//                   sex = 1;
//                }
//            }
//        });
    }

    @Override
    public void completeRegister() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void toTeacherDetails(String number,int identity) {
        startActivity(new Intent(this, AddDetailsActivity.class).putExtra("number",number).putExtra("identity", identity));
        this.finish();
    }

    @Override
    public void toStudentDetails(String number,int identity) {
        startActivity(new Intent(this, AddDetailsActivity.class).putExtra("number",number).putExtra("identity", identity));
        this.finish();
    }

}
