package com.story.happyjie.dailyinformation.ui.joke.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewAdapter;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewHolder;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.databinding.ItemJokeListBinding;

/**
 * Created by llj on 2018/1/3.
 */

public class JokeAdapter extends BaseRecycleViewAdapter<JokeListResult.DataBeanX.Data> {

    private Context context;
    private static String STRING_HEAD = "#搞笑段子#";

    public JokeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeItemHolder(parent, R.layout.item_joke_list);
    }

    private class JokeItemHolder extends BaseRecycleViewHolder<JokeListResult.DataBeanX.Data, ItemJokeListBinding>{

        public JokeItemHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(JokeListResult.DataBeanX.Data object, int position) {
            mViewBinding.setItem(object);
            SpannableString spannableString = new SpannableString(STRING_HEAD + object.getGroup().getText());
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.text_joke_pink_color)),
                    0, STRING_HEAD.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mViewBinding.tvContent.setText(spannableString);
            mViewBinding.executePendingBindings();
        }
    }
}
