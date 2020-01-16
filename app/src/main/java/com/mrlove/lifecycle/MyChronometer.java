package com.mrlove.lifecycle;


import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


public class MyChronometer extends Chronometer implements LifecycleObserver {
    public MyViewModel myViewModel;
    private long elapsedTime;

    private final static String TAG = "MyChronometer";

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMyViewModel(MyViewModel myViewModel){
        this.myViewModel = myViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        Log.d(TAG,"getBase:"+String.valueOf(getBase()));
          elapsedTime = myViewModel.getElapsedTime(getBase()).getValue();
        Log.d(TAG,"pasueMeter:"+String.valueOf(elapsedTime));
          stop();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime()-elapsedTime);
        Log.d(TAG,"resumeMeter:"+String.valueOf(elapsedTime));
        Log.d(TAG,"resumeMeter:"+String.valueOf(SystemClock.elapsedRealtime()-elapsedTime));
        start();
    }



}
