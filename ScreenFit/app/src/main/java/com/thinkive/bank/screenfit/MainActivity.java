package com.thinkive.bank.screenfit;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Locale;

/**
 * @author: sq
 * @date: 2017/9/25
 * @corporation: 深圳市思迪信息技术股份有限公司
 * @description:
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_language:  //语言适配
                changeLocal();  //改变应用语言配置，进行语言适配
                break;
            case R.id.tv_landPort:  //横竖屏适配
                startActivity(new Intent(this, LandPortActivity.class));
                break;
            case R.id.tv_property:  //布局、控件属性适配
                startActivity(new Intent(this, PropertyActivity.class));
                break;
            case R.id.tv_percent_frame:  //百分比帧布局适配
                startActivity(new Intent(this, PercentFrameActivity.class));
                break;
            case R.id.tv_percent_relative:  //百分比相对布局适配
                startActivity(new Intent(this, PercentRelativeActivity.class));
                break;
            case R.id.tv_percent_linear:  //百分比线性布局适配
                startActivity(new Intent(this, PercentLinearActivity.class));
                break;

        }
    }

    /**
     * 手动改变应用语言配置，进行语言适配
     * 如果要程序自动适应系统语言进行转变，可以在res下添加相应的语言文件夹
     * 如：添加中文，则文件夹命名为values-zh-rCN
     * 如果不清楚需要的名字可以参考：E:\android-sdk-windows\platforms\android-8\data\res
     */
    private void changeLocal() {
        Configuration config = getResources().getConfiguration();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        Locale locale = config.locale;
        String country = locale.getCountry();
        String language = locale.getLanguage();
        Log.e("local", "country:" + country + "=========language:" + language);
        if (country.equals("CN")) {
            config.locale = Locale.ENGLISH;//英文
        } else {
            config.locale = Locale.CHINA;//中文
//            locale = Locale.getDefault();//默认为中文

        }
        getBaseContext().getResources().updateConfiguration(config, dm);

        /**
         * 语言设置完成后，应用并不会自动刷新当前已经打开的Activity
         * 所以为了刷新整个应用，需要重新启动一下应用
         */
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }
}
