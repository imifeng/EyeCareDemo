package com.finn.eyecaredemo;

import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

import com.finn.eyecaredemo.base.BaseActivity;
import com.finn.eyecaredemo.test.TestDialogActivity;

import butterknife.BindView;

/**
 * @author Finn
 * @date 2020
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_setting)
    TextView tv_setting;
    @BindView(R.id.tv_dialog)
    TextView tv_dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onBack() {
        finish();
    }

    @Override
    protected void initView() {
        super.initView();
        tv_setting.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_setting.getPaint().setAntiAlias(true);//抗锯齿
        tv_dialog.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_dialog.getPaint().setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        tv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(it);
            }
        });

        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, TestDialogActivity.class);
                startActivity(it);
            }
        });
    }
}