package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.export_user.UserServiceUtil;
import com.example.module_user.UserInfoServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(view -> {
            ARouter.getInstance()
                    .build("/home/homepageActivity")
                    .navigation();
        });

        findViewById(R.id.btn_user).setOnClickListener(view -> {
            UserServiceUtil.navigateUserPage("123");
        });

        Button btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(view -> {
            btnInfo.setText(UserServiceUtil.getUserInfo().toString());
        });
    }
}