package com.wordplat.quickstart.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wordplat.quickstart.R;

/**
 * Created by afon on 2017/2/7.
 */

public class Grid3x1Adapter extends RecyclerView.Adapter<Grid3x1ViewHolder> {

    private Activity mActivity;

    public Grid3x1Adapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public Grid3x1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mActivity).inflate(R.layout.item_grid3x1, parent, false);
        return new Grid3x1ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Grid3x1ViewHolder holder, int position) {
        holder.text.setText("position " + position);
        switch (position) {
            case 0:
                holder.text.setBackgroundColor(Color.parseColor("#aa0000"));
                break;

            case 1:
                holder.text.setBackgroundColor(Color.parseColor("#00aa00"));
                break;

            case 2:
                holder.text.setBackgroundColor(Color.parseColor("#0000aa"));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
