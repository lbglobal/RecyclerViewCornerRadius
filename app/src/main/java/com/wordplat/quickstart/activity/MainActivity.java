package com.wordplat.quickstart.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wordplat.quickstart.R;
import com.wordplat.quickstart.adapter.Grid3x1Adapter;
import com.wordplat.quickstart.utils.AppUtils;
import com.wordplat.quickstart.widget.custom.RecyclerViewCornerRadius;
import com.wordplat.quickstart.widget.dialog.CouponDialog;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.grid3x1List) private RecyclerView grid3x1List = null;
    @ViewInject(R.id.dialogBut) private Button dialogBut = null;

    private Grid3x1Adapter grid3x1Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        grid3x1Adapter = new Grid3x1Adapter(mActivity);
        grid3x1List.setLayoutManager(new GridLayoutManager(mActivity, 3));
        grid3x1List.setAdapter(grid3x1Adapter);

        RecyclerViewCornerRadius radiusItemDecoration = new RecyclerViewCornerRadius(grid3x1List);
        radiusItemDecoration.setCornerRadius(AppUtils.dpTopx(mActivity, 15));
        grid3x1List.addItemDecoration(radiusItemDecoration);

        dialogBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CouponDialog.from(mActivity).show();
            }
        });
    }

    /**
     * 点击两次退出
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
