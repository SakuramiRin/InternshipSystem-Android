package com.example.sakuramirin.loginsignuptest;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sakuramirin.loginsignuptest.Beans.CourseListBean;
import com.example.sakuramirin.loginsignuptest.Presenter.CoursePresenter;
import com.example.sakuramirin.loginsignuptest.Presenter.Interface.ICoursePresenter;
import com.example.sakuramirin.loginsignuptest.View.Acitvity.BaseActivity;
import com.example.sakuramirin.loginsignuptest.View.Interface.ICourseView;



import butterknife.ButterKnife;
import butterknife.OnClick;


public class CourseActivity extends BaseActivity implements ICourseView{

    private ICoursePresenter iCoursePresenter;

    private String sid;
    //星期几
    private RelativeLayout day;

//    //SQLite Helper类
//    private DataBaseHelper databaseHelper = new DataBaseHelper
//            (this, "database.db", null, 1);

    int currentCoursesNumber = 0;   //确切课程数字
    int maxCoursesNumber = 0;   //最大课程数字？
    //省略成员变量

//    @OnClick(R.id.add_courses)
//    public void addCourses(){
//        Intent intent = new Intent(this, AddCourseActivity.class);
//        intent.putExtra("sid", sid);
//        startActivity(intent);
//
//    }

//    @OnClick(R.id.get_courses)
//    public void getCourses(){
//        iCoursePresenter.getCourseList(sid);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Intent intent = getIntent();
        sid = intent.getStringExtra("sid");


        Toolbar toolbar = findViewById(R.id.course_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        iCoursePresenter = new CoursePresenter(this);
        iCoursePresenter.getCourseList(sid);


//        Button button = findViewById(R.id.add_courses);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 Intent intent = new Intent(CourseActivity.this, AddCourseActivity.class);
//                 intent.putExtra("sid",)
//                startActivityForResult(intent, 0);
//            }
//        });

        //从数据库读取数据
//        loadData();
    }
    //从数据库加载数据
//    private void loadData() {
//        ArrayList<CourseBean> courseList = new ArrayList<>(); //课程列表集合
//        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from courses", null);
//        if (cursor.moveToFirst()) {
//            do {
//                courseList.add(new CourseBean(
//                        cursor.getString(cursor.getColumnIndex("course_name")),
//                        cursor.getString(cursor.getColumnIndex("teacher")),
//                        cursor.getString(cursor.getColumnIndex("class_room")),
//                        cursor.getInt(cursor.getColumnIndex("day")),
//                        cursor.getInt(cursor.getColumnIndex("class_start")),
//                        cursor.getInt(cursor.getColumnIndex("class_end"))));
//            } while(cursor.moveToNext());
//        }
//        cursor.close();
//
//        //使用从数据库读取出来的课程信息来加载课程表视图
//        for (CourseBean course : courseList) {
//            createLeftView(course); //创建课程节数？
//            createCourseView(course);   //创建课程视图
//        }
//    }
    //保存数据到数据库
//    private void saveData(CourseBean course) {
//        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
//        sqLiteDatabase.execSQL("insert into courses(course_name, teacher, class_room, day, class_start, class_end) " +
//                "values(?, ?, ?, ?, ?, ?)", new String[] {course.getCourseName(), course.getTeacher(),
//                course.getClassRoom(), course.getDay()+"", course.getStart()+"", course.getEnd()+""});
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.course_menu_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.add_course_menu:
                Intent intent = new Intent(this, AddCourseActivity.class);
                intent.putExtra("sid", sid);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //创建课程节数视图
    @Override
    public void createLeftView(CourseListBean.CourseBean course) {
        int len = course.getCend(); //结束时间
        if (len > maxCoursesNumber) {
            for (int i = 0; i < len-maxCoursesNumber; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.left_view, null);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(110,180);
                view.setLayoutParams(params);

                TextView text = view.findViewById(R.id.class_number_text);
                text.setText(String.valueOf(++currentCoursesNumber));

                LinearLayout leftViewLayout = findViewById(R.id.left_view_layout);
                Log.d("dasdfsdf", "createLeftView: "+leftViewLayout);
                leftViewLayout.addView(view);
            }
        }
        maxCoursesNumber = len;
    }


    //创建课程视图

    @Override
    public void createCourseView(final CourseListBean.CourseBean course) {
        int height = 180;
        int integer = course.getCday(); //天数
        if ((integer < 1 || integer > 7) || course.getCstart() > course.getCend())
            Toast.makeText(this, "星期几没写对,或课程结束时间比开始时间还早~~", Toast.LENGTH_LONG).show();
        else {
            switch (integer) {
                case 1: day = findViewById(R.id.monday);break;
                case 2: day = findViewById(R.id.tuesday);break;
                case 3: day = findViewById(R.id.wednesday);break;
                case 4: day = findViewById(R.id.thursday);break;
                case 5: day = findViewById(R.id.friday);break;
                case 6: day = findViewById(R.id.saturday);break;
                case 7: day = findViewById(R.id.weekday);break;
            }
            final View view = LayoutInflater.from(this).inflate(R.layout.course_card, null); //加载单个课程布局
            view.setY(height * (course.getCstart()-1)); //设置开始高度,即第几节课开始
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT,(course.getCend()-course.getCstart()+1)*height - 8); //设置布局高度,即跨多少节课
            view.setLayoutParams(params);
            TextView text = view.findViewById(R.id.text_view);
            text.setText(course.getCname() + "\n" + course.getCteacher() + "\n" + course.getCroom()); //显示课程名
            day.addView(view);


            //长按删除课程
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    view.setVisibility(View.GONE);//先隐藏
                    day.removeView(view);//再移除课程视图
//                    SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
////                    sqLiteDatabase.execSQL("delete from courses where course_name = ?", new String[] {course.getCourseName()});
                    iCoursePresenter.deleteCourse(course.getCname(), sid);
                    return true;
                }
            });
        }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 0 && resultCode == 0 && data != null) {
//            CourseBean course = (CourseBean) data.getSerializableExtra("course");
//            //创建课程表左边视图(节数)
//            createLeftView(course);
//            //创建课程表视图
//            createCourseView(course);
//            //存储数据到数据库
//            saveData(course);
//        }
//    }




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_courses:
//                Intent intent = new Intent(this, AddCourseActivity.class);
//                startActivityForResult(intent, 0);
//                break;
////            case R.id.menu_about:
////                Intent intent1 = new Intent(this, AboutActivity.class);
////                startActivity(intent1);
////                break;
//        }
//        return true;
//    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
