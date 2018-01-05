package com.story.happyjie.dailyinformation.model;

import android.content.Context;

import com.story.happyjie.dailyinformation.model.base.BaseJokeRequestModel;

/**
 * Created by llj on 2018/1/5.
 */

public class JokeCommentRequestModelModel extends BaseJokeRequestModel {

    private long group_id;
    private long item_id;
    private int count = 15;
    private int offset;
    private int enable_image_comment = 1;

    public JokeCommentRequestModelModel(Context context, long group_id, long item_id, int offset) {
        super(context);
        this.group_id = group_id;
        this.item_id = item_id;
        this.offset = offset;
    }


}
