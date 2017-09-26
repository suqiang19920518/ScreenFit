package com.thinkive.bank.screenfit;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author: sq
 * @date: 2017/9/25
 * @corporation: 深圳市思迪信息技术股份有限公司
 * @description: 横竖屏切换时，动态更新布局
 */
public class BlankFragment extends Fragment {

    private int screenState = -1;
    private onClickCallback callback;

    public interface onClickCallback {
        void passOperation(View view, int position);
    }

    public void setCallback(onClickCallback callback) {
        this.callback = callback;
    }

    /**
     * 当创建碎片实例时，获取到当前屏幕的方式状态
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //根据系统提供的Configuration类，获取当前手机系统中的方向值
        screenState = getResources().getConfiguration().orientation;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) view.findViewById(R.id.list_Fragment);

        final String[] data = new String[]{"123", "456", "789"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //点击ListView中的item时，需要判断当前手机方向是垂直还是水平
                //根据方向，进行不一样逻辑操作
                if (screenState == Configuration.ORIENTATION_LANDSCAPE) {
                    Log.e("TAG", "当前手机处于水平方向，直接在右边占位布局中显示内容");
                    setCallback((onClickCallback) getActivity());
                    if (callback != null) {
                        callback.passOperation(view, position);
                    }
                } else if (screenState == Configuration.ORIENTATION_PORTRAIT) {
                    Log.e("TAG", "当前手机处于垂直方向，需要新启界面显示点击item中的内容");
                    Intent intent = new Intent(getActivity(), TestActivity.class);
                    intent.putExtra("content", data[position]);
                    startActivity(intent);
                }
            }
        });
    }
}
