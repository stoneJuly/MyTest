package com.stonejuly.androidstudiotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private TextView mTextView;
    //logt 生成日志标签
    private static final String TAG = "DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logd logi 日志级别
        Log.d(TAG, "onCreate: ");
        //logm 日志输出方法参数
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");

        //command+option+T 代码包裹选项
        if (true) {
            System.out.print("if语句执行");
        }
        //command+j 模版代码
        //command+option+L 格式化代码

        //shift+command+up/down 整行移动
        //command+D 整行删除
        //command+delete 整行删除
        //command+left/right 光标定位到行首行尾
        //option+left/right 光标以单词为步长移动
        //shift+option+left/right 选中单词
        //command+option+{／} 光标定位到方法花括号位置
        System.out.print("hello as");
        System.out.print("hello as");

        //command+O 查找类
        //shift+command+O 查找类，资源文件
        //command+B 查找变量声明
        //control+O 重写父类方法
        mTextView.setText("hello as");

        //control+H 查看当前类结构
        //command+U 查看父类
        //control+option+H 查看方法调用
        //command+option+left 代码查看返回
        //command+F12 查看当前类的方法，变量
        printMethodCall();

        //command+minus/plus 代码折叠展开
        //command+1 项目结构面板的显示隐藏

        //

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void printMethodCall() {
        Log.d(TAG, "printMethodCall: ");

    }

    private void printPersons(List<String> list) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
