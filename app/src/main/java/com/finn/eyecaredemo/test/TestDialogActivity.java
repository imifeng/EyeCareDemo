package com.finn.eyecaredemo.test;

import android.widget.TextView;

import com.finn.eyecaredemo.R;
import com.finn.eyecaredemo.base.BaseActivity;
import com.finn.eyecaredemo.utils.DialogUtil;

import butterknife.BindView;

/**
 * @author Finn
 * @date 2020
 */
public class TestDialogActivity extends BaseActivity {

    @BindView(R.id.tv_dialog)
    TextView tv_dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_dialog;
    }

    @Override
    protected void onBack() {
        finish();
    }

    @Override
    protected void initView() {
        super.initView();

        String messageStr2 = "Test positionAlertDialog positionAlertDialog =";
        showAlert(messageStr2);
        String messageStr4 = "Test positionAlertDialog positionAlertDialog positionAlertDialog positionAlertDialog positionAlertDialog =";
        showAlert(messageStr4);
        String messageStr3 = "Test positionAlertDialog positionAlertDialog positionAlertDialog =";
        showAlert(messageStr3);
        String messageStr = "Test positionAlertDialog =";
        showAlert(messageStr);

    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    public void showAlert(final String messageStr) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DialogUtil.showAlert(TestDialogActivity.this, messageStr);
            }
        });
    }
}