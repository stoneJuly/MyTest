package com.stonejuly.myrxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class MainActivity extends AppCompatActivity {
    private Observable mObservable;//被观察者
    private Observer mObserver;//观察者

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
