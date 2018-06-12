package com.example.sakuramirin.loginsignuptest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sakuramirin.loginsignuptest.Beans.StudentBean;
import com.example.sakuramirin.loginsignuptest.Beans.TeacherBean;

import com.example.sakuramirin.loginsignuptest.View.Acitvity.AboutActivity;
import com.example.sakuramirin.loginsignuptest.View.Acitvity.BaseActivity;
import com.example.sakuramirin.loginsignuptest.View.Acitvity.LoginActivity;


public class Main2Activity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {    //实现了抽屉接口

    private StudentBean studentBean;
    private TeacherBean teacherBean;

    private int identity;

    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar); //设置toolbar顶部
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);   //跟随按钮
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, AddNoticeActivity.class).putExtra("tno", teacherBean.getTno()));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);  //设置抽屉
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);   //具体的抽屉内容
        TextView username = navigationView.getHeaderView(0).findViewById(R.id.text_stu_name);
        TextView userIdentity = navigationView.getHeaderView(0).findViewById(R.id.text_stu_identity);

        ImageView imaView = navigationView.getHeaderView(0).findViewById(R.id.imageView);

        navigationView.setNavigationItemSelectedListener(this);

        LinearLayout leftViewLayout = findViewById(R.id.left_view_layout);
        Log.w("ddddddddddd", "onCreate: " + leftViewLayout);

        WebView webView = findViewById(R.id.web_vview);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.sph.com.cn/");

        final Intent intent = getIntent();
        identity = intent.getIntExtra("identity", 2);
        if (identity == 2) {
            studentBean = (StudentBean) intent.getSerializableExtra("data");
            Log.e("主界面", "onCreate: " + studentBean);
            Log.e("学生实体类", "onCreate: " + studentBean.getSname());
            username.setText(studentBean.getSname());
            userIdentity.setText("学生");
            imaView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("主界面传递", "onClick: " + studentBean);
                    startActivity(new Intent(Main2Activity.this, PersonalActivity.class).putExtra("data", studentBean));
                }
            });
            fab.setVisibility(View.GONE);
        } else if (identity == 1) {
            teacherBean = (TeacherBean) intent.getSerializableExtra("data");
            username.setText(teacherBean.getTname());
            userIdentity.setText("教师");
            Log.e("!!!!!!!!", "onCreate: " + teacherBean);
        }
    }

    //分别对顶部栏，添加通知的跟随按钮，抽屉栏，具体抽屉内容，通知碎片进行注册
    //并根据登录身份选择展示内容


    // 抽屉栏的关闭
    @Override
    public void onBackPressed() {   //返回
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    //菜单按钮注册
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        if (identity == 2) {
            menu.findItem(R.id.action_all_student).setVisible(false);
        }
        else {
            menu.findItem(R.id.action_settings).setVisible(false);
        }
        return true;
    }




    //菜单按钮被选择时触发事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(Main2Activity.this, PersonalActivity.class).putExtra("data", studentBean));
                break;
            case R.id.action_all_student:
                startActivity(new Intent(Main2Activity.this, SelectStuActivity.class));
                break;
            case R.id.test:
                startActivity(new Intent(Main2Activity.this,NoticeListActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }





    //--------------------------------------------
    //抽屉菜单栏
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {    //抽屉内的内容被选择


        int id = item.getItemId();

        if (id == R.id.nav_camera) {    //通知
            if (identity == 1) {
                startActivity(new Intent(this, NoticeListActivity.class).putExtra("tno", teacherBean.getTno()));
            } else {
                startActivity(new Intent(this, NoticeListActivity.class));
            }
        } else if (id == R.id.nav_gallery) {    //课表
            if (identity == 2) {
                Intent intent = new Intent(this, CourseActivity.class);
                intent.putExtra("sid", studentBean.getSno());
                startActivity(intent);
            } else {
                Toast.makeText(this, "教师用户无法使用", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_slideshow) {  //资料
            startActivity(new Intent(this, StudyActivity.class));
        } else if (id == R.id.nav_manage) { //评价
            startActivity(new Intent(Main2Activity.this, SelectStuActivity.class));
        } else if (id == R.id.nav_share) {  //退出
            System.exit(0);
        } else if (id == R.id.nav_send) {   //注销
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //-----------------------------------------------------
    //双击退出程序
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(Main2Activity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
