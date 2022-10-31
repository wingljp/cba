package com.example.componentbasedapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.alibaba.android.arouter.facade.annotation.Route;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.aroutertest.R;

@Route(path = "/aroutertest/MainActivity")
public class MainActivity extends AppCompatActivity {
    TextView textView;

    //    @Parameter(name = "/login/LoginServiceImpl")
//    LoginService loginService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);

        textView = findViewById(R.id.tvbtn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                loginService.printf();

                // 使用两个参数的navigation方法，可以获取单次跳转的结果
                ARouter.getInstance().build("/login/LoginActivity").navigation(MainActivity.this, 5);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == 321) {
            String name = data.hasExtra("name") ? data.getStringExtra("name") : "";
            textView.setText(name);
        }
    }
}