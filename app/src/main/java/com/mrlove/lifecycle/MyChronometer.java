package com.mrlove.lifecycle;


import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


public class MyChronometer extends Chronometer implements LifecycleObserver {
    public MyViewModel myViewModel;
    private long elapsedTime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMyViewModel(MyViewModel myViewModel){
        this.myViewModel = myViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)  //Lifecycle支持的监听生命周期的方式
    private void pauseMeter(){
          elapsedTime = myViewModel.getElapsedTime(getBase()).getValue();
          stop();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime()-elapsedTime);
        start();
    }



}
