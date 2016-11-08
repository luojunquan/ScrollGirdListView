package com.example.scrollgirdlistview.Test2;

import android.widget.GridView;

/**
 * gridView和scollView冲突,自定义gridView
 */

public class CustomGridView extends GridView {
    CustomGridView gridView;
    public CustomGridView(android.content.Context context,
                          android.util.AttributeSet attrs) {
        super(context, attrs);
    }
    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
