package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.IPersonalPersenter;
import com.example.sakuramirin.loginsignuptest.Presenter.PersonalPresenter;
import com.example.sakuramirin.loginsignuptest.View.Interface.IPersonalView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalActivity extends AppCompatActivity implements IPersonalView{

    private StudentBean studentBean;
    private IPersonalPersenter iPersonalPersenter;

    @BindView(R.id.per_name)
    EditText perName;

    @BindView(R.id.per_sid)
    EditText perSid;

    @BindView(R.id.per_sex)
    EditText perSex;

    @BindView(R.id.per_qq)
    EditText perQQ;

    @BindView(R.id.per_age)
    EditText perAge;

    @BindView(R.id.per_sdept)
    EditText perSdept;

    @OnClick(R.id.update_student)
    public void updateStudent(){
        Log.e("点击了", "updateStudent: " );
        String sname = perName.getText().toString();
        String ssex_ = perSex.getText().toString();
        Integer ssex = 0;
        if (ssex_.equals("男")) {
             ssex = 0;
        }
        if (ssex_.equals("女")) {
             ssex = 1;
        }
        String sno = perSid.getText().toString();
        String sdept = perSdept.getText().toString();
        String sqq = perQQ.getText().toString();
        String sage = perAge.getText().toString();
        iPersonalPersenter.changeStuPer(sno,sname,sqq,sdept,Integer.parseInt(sage),ssex);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);

        Intent intent = getIntent();
        studentBean = (StudentBean) intent.getSerializableExtra("data");
        Log.e("验证", "onCreate: studentBean"+studentBean );
        studentBean.toString();

        perName.setText(studentBean.getSname());

        perAge.setText(studentBean.getSage()+"");

        perQQ.setText(studentBean.getSqq()+"");

        perSdept.setText(studentBean.getSdept());
        if (studentBean.getSsex() == 0) {

            perSex.setText("男");
        } else {
            perSex.setText("女");
        }

        perSid.setText(studentBean.getSno()+"");
            perSid.setEnabled(false);
//        studentBean.toString();

        iPersonalPersenter = new PersonalPresenter(this);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void backToHome() {
        finish();
    }
}
