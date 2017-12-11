package com.lib.llj.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.llj.commonlib.R;

/**
 * Created by llj on 2017/12/11.
 */

public class MenuItemView extends RelativeLayout {
    private ImageView ivIcon;
    private TextView tvMenuTitle;
    private ImageView ivNextArrow;
    private ImageView ivRedPoint;


    public MenuItemView(Context context) {
        super(context);
        initView(context, null);
    }

    public MenuItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MenuItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    /**
     * 初始化操作
     *
     * @param context
     */
    private void initView(Context context, AttributeSet attributeSet) {
        View.inflate(context, R.layout.layout_menu_item_view, this);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        ivNextArrow = (ImageView) findViewById(R.id.iv_next_arrow);
        ivRedPoint = (ImageView) findViewById(R.id.iv_red_point);
        tvMenuTitle = (TextView) findViewById(R.id.tv_menu_title);

        if (attributeSet == null) {
            return;
        }

        TypedArray typeArr = context.obtainStyledAttributes(attributeSet, R.styleable.MenuItemView);
        String title = typeArr.getString(R.styleable.MenuItemView_menu_title);
        int textColor = typeArr.getColor(R.styleable.MenuItemView_text_color, Color.parseColor("#333333"));
        float textSize = typeArr.getDimension(R.styleable.MenuItemView_text_size, 14);

        final int defaultIconWidth = getResources().getDimensionPixelSize(R.dimen.default_menu_icon_width);

        int iconWidth = typeArr.getDimensionPixelSize(R.styleable.MenuItemView_icon_width, defaultIconWidth);
        int iconHeight = typeArr.getDimensionPixelSize(R.styleable.MenuItemView_icon_height, defaultIconWidth);

        int iconResId = typeArr.getResourceId(R.styleable.MenuItemView_icon_res_id, -1);
        boolean isShowIcon = typeArr.getBoolean(R.styleable.MenuItemView_is_show_icon, true);
        boolean isShowNextArrow = typeArr.getBoolean(R.styleable.MenuItemView_is_show_next_arrow, false);
        typeArr.recycle();

        if(isShowIcon) {
//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams();
//            ivIcon.setLayoutParams(layoutParams);

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ivIcon.getLayoutParams();
            layoutParams.width = iconWidth;
            layoutParams.height = iconHeight;
            ivIcon.requestLayout();

            ivIcon.setImageResource(iconResId);
            ivIcon.setVisibility(View.VISIBLE);
        } else {
            ivIcon.setVisibility(View.GONE);
        }

        tvMenuTitle.setTextSize(textSize);
        tvMenuTitle.setTextColor(textColor);
        tvMenuTitle.setText(title);

        ivNextArrow.setVisibility(isShowNextArrow ? View.VISIBLE : View.GONE);
    }

    public void setRedPointVisible(boolean visible){
        ivRedPoint.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public CharSequence getMenuTitle() {
        return tvMenuTitle.getText();
    }
}
