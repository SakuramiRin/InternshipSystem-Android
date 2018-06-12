package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IAddDetailsPresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.AddDetailsPresent;
import com.example.sakuramirin.loginsignuptest.View.Acitvity.BaseActivity;
import com.example.sakuramirin.loginsignuptest.View.Acitvity.LoginActivity;
import com.example.sakuramirin.loginsignuptest.View.Interface.IAddDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDetailsActivity extends BaseActivity implements IAddDetailsView {
    private IAddDetailsPresenter iStudentDetailsPresenter;
    private String sno;
    private int ssex;
    private int identity;

    @BindView(R.id.sname)
    EditText mName;

    @BindView(R.id.sqq)
    EditText mqq;

    @BindView(R.id.sdept)
    EditText mdept;

    @BindView(R.id.sage)
    EditText mage;

    @BindView(R.id.group)
    RadioGroup mGroup;

    @BindView(R.id.boy)
    RadioButton mBoy;

    @BindView(R.id.girl)
    RadioButton mGirl;

    @OnClick(R.id.end_button)
    public void finish(){
        if (identity ==2 ) {
            String sname = mName.getText().toString();
            String sqq = mqq.getText().toString();
            String sdept = mdept.getText().toString();
            String age = mage.getText().toString();
            Integer sage = 0;
            if (!age.equals("")) {
                sage = Integer.parseInt(age);
            }
            iStudentDetailsPresenter.doStudentDetails(sno, sname, sqq, sdept, sage, ssex);
        }
        if (identity == 1 ){
            String sname = mName.getText().toString();
            String sqq = mqq.getText().toString();
            iStudentDetailsPresenter.doTeacherDetails(sno,sname,sqq,ssex);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        sno = intent.getStringExtra("number");
        identity = intent.getIntExtra("identity",0);
        if (identity == 1) {
            findViewById(R.id.linear_age).setVisibility(View.GONE);
            findViewById(R.id.linear_major).setVisibility(View.GONE);
        }

        iStudentDetailsPresenter = new AddDetailsPresent(this);

        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == mBoy.getId()){
                    ssex = 0;
                }
                else{
                   ssex = 1;
                }
            }
        });
    }

    @Override
    public void backToLogin() {
        startActivity(new Intent(AddDetailsActivity.this, LoginActivity.class));
        finish();

    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
