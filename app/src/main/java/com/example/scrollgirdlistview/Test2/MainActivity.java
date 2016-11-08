package com.example.scrollgirdlistview.Test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.scrollgirdlistview.R;

public class MainActivity extends AppCompatActivity{
    private CustomGridView mGridView;
    private CustomListView mListView;
    private MyAdapter mGridViewAdapter;
    private String[] data = {"设置", "收藏", "消息", "活动", "充值", "兑换", "注单", "更多"};
    private int[] img_function = {R.mipmap.geren_icon_shezhi, R.mipmap.geren_icon_shoucang, R.mipmap.geren_icon_xiaoxi,
            R.mipmap.geren_icon_huodong, R.mipmap.geren_icon_chongzhi,
            R.mipmap.geren_icon_huihuan, R.mipmap.geren_icon_zhudan, R.mipmap.geren_icon_gengduo,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test2);
        initView();
        setListener();
    }

    private void initView() {
        mGridView = (CustomGridView) findViewById(R.id.gridview);
        mListView = (CustomListView) findViewById(R.id.listview);
        mGridViewAdapter = new MyAdapter(this, data, img_function);
        mGridView.setAdapter(mGridViewAdapter);
        mListView.setAdapter(mGridViewAdapter);
    }
    private void setListener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"点击了"+ position,Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,Test.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,Test2.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,Test.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,Test2.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }
}
