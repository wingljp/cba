package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.LoginService;

@Route(path = "/login/LoginActivity")
public class LoginActivity extends AppCompatActivity implements LoginService {
    @Autowired
    String strValue;
    @Autowired
    int intValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ARouter.getInstance().inject(this);
        TextView v = findViewById(R.id.textView);
        v.setOnClickListener(view -> {
                    Intent data = new Intent();
                    data.putExtra("name", "我是AModuleActivity");
                    setResult(321, data);
                    finish();

                }


        );
    }

    @Override
    public void printf() {
        Log.e("成功调用", "login");
    }
}