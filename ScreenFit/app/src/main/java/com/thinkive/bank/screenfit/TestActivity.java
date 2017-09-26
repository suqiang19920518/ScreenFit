package com.thinkive.bank.screenfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String content = getIntent().getStringExtra("content");
        ((TextView) findViewById(R.id.tv_test)).setText(content);
    }
}
