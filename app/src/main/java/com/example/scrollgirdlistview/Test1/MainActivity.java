package com.example.scrollgirdlistview.Test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.view.*;

import com.example.scrollgirdlistview.R;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ListView listView;
    private MyAdapter mGridViewAdapter;
//    private MyListViewAdapter mListViewAdapter;
    private String[] data = {"设置", "收藏", "消息", "活动", "充值", "兑换", "注单", "更多"};
    private int[] img_function = {R.mipmap.geren_icon_shezhi, R.mipmap.geren_icon_shoucang,
            R.mipmap.geren_icon_xiaoxi,R.mipmap.geren_icon_huodong, R.mipmap.geren_icon_chongzhi,
            R.mipmap.geren_icon_huihuan, R.mipmap.geren_icon_zhudan, R.mipmap.geren_icon_gengduo,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.gridview);
        listView = (ListView) findViewById(R.id.listview);
        mGridViewAdapter = new MyAdapter(this,data,img_function);
        gridView.setAdapter(mGridViewAdapter);
        listView.setAdapter(mGridViewAdapter);
        setListViewHeightBasedOnChildren(gridView);
        getTotalHeightofListView(listView);
    }
//动态设置GridView的高度
    private void setListViewHeightBasedOnChildren(GridView gridView) {
        ListAdapter gridAdapter = gridView.getAdapter();
        if (gridAdapter == null){
            return;
        }
        int col = 4;
        int totalHeight = 0;
        for (int i =0;i < gridAdapter.getCount();i+= col){
            View listItem = gridAdapter.getView(i, null, gridView);
            listItem.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += listItem.getMeasuredHeight();
        }
        // 获取listview的布局参数
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        // 设置高度
        params.height = totalHeight;
        // 设置margin
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        // 设置参数
        gridView.setLayoutParams(params);
    }

    private void getTotalHeightofListView(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null){
            return;
        }
        int totalHeight = 0;
        for (int i = 0;i < adapter.getCount();i++){
            View view = adapter.getView(i,null,listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED));
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
