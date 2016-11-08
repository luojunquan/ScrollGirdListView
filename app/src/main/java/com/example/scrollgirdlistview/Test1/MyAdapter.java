package com.example.scrollgirdlistview.Test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scrollgirdlistview.R;

/**
 * Created by：赖上罗小贱 on 2016/11/8
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private String[] data;
    private int[] img_function;

    public MyAdapter(Context context, String[] data, int[] img_function) {
        this.context = context;
        this.data = data;
        this.img_function = img_function;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview,null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_gridview_imageview);
            holder.textView = (TextView) convertView.findViewById(R.id.item_gridview_textview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setBackgroundResource(img_function[position]);
        holder.textView.setText(data[position]);
        return convertView;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
