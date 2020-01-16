package com.mrlove.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.mrlove.lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding.myChronometer.setMyViewModel(myViewModel);
        binding.setData(myViewModel);
        getLifecycle().addObserver(binding.myChronometer); //通过此方法设置myChronometer的观察者
    }
}
