package com.wordplat.quickstart.adapter;

import android.view.View;
import android.widget.TextView;

import com.wordplat.quickstart.R;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by afon on 2017/2/7.
 */

public class Grid3x1ViewHolder extends BaseViewHolder {

    @ViewInject(R.id.text) TextView text;

    public Grid3x1ViewHolder(View itemView) {
        super(itemView);
    }
}
