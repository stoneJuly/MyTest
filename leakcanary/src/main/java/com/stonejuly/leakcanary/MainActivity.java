package com.stonejuly.leakcanary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Inner mInner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInner = new Inner();
        mInner.setName("stoneJuly");
        mInner.setAge(27);
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, mInner.toString(), Toast.LENGTH_SHORT).show();
        MyApplication.getRefWatcher(this).watch(this);
        super.onDestroy();
    }

    class Inner {
        String name;
        int age;
        void setName(String name) {
            this.name = name;
        }
        void setAge(int age) {
            this.age = age;
        }
        String getName() {
            return this.name;
        }
        int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return "Name=" + this.getName() + ",Age=" + this.getAge();
        }
    }
}
