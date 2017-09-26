package com.thinkive.bank.screenfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author: sq
 * @date: 2017/9/25
 * @corporation: 深圳市思迪信息技术股份有限公司
 * @description: 横竖屏切换演示界面
 * Android OS会根据手机系统设置中的方向选项，自动匹配res下的layout文件夹中的资源内容
 */
public class LandPortActivity extends AppCompatActivity implements BlankFragment.onClickCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_port);
    }


    /**
     * 接口回调
     *
     * @param view
     * @param position
     */
    @Override
    public void passOperation(View view, int position) {
        TextView textView = (TextView) findViewById(R.id.fl_content);
        ListView listView = (ListView) view.getParent();
        String item = (String) listView.getAdapter().getItem(position);
        textView.setText(item);
    }
}
