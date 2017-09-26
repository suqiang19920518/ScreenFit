package com.thinkive.bank.screenfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author: sq
 * @date: 2017/9/25
 * @corporation: 深圳市思迪信息技术股份有限公司
 * @description: 控件属性、布局适配策略
 * 尽量使用match_parent、wrap_content、layout_weight属性，避免具体宽高数值，如20dp
 * 尽量使用LinearLayout布局、RelativeLayout布局、TableLayout布局，ImageView的scaleType尽量使用centerCrop
 */
public class PropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
    }
}
