package com.mrlove.lifecycle;

import android.app.Application;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private static final String KEY_DATA = "key_data";

    public MutableLiveData<Long> getElapsedTime(long basetime){
            handle.set(KEY_DATA,SystemClock.elapsedRealtime()-basetime);
        return handle.getLiveData(KEY_DATA);
    }

    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
    }
}
