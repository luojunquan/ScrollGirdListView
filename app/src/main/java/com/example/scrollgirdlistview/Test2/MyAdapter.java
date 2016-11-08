package com.example.scrollgirdlistview.Test2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scrollgirdlistview.R;


public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private String[] data;
    private int[] img_function;
    public MyAdapter(MainActivity mainActivity, String[] data, int[] img_function) {
        this.mContext = mainActivity;
        this.data = data;
        this.img_function = img_function;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data!=null? data[position]:null;
    }

    @Override
    public long getItemId(int position) {
        return data!=null?position:0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_gridview, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_gridview_imageview);
            holder.textView = (TextView) convertView.findViewById(R.id.item_gridview_textview);
            convertView.setTag(holder);
        } else {
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
