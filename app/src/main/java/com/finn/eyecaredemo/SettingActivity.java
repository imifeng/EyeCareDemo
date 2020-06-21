package com.finn.eyecaredemo;

import android.widget.CompoundButton;
import android.widget.Switch;

import com.finn.eyecaredemo.base.BaseActivity;
import com.finn.eyecaredemo.common.Constant;

import butterknife.BindView;

/**
 * @author Finn
 * @date 2020
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.switch_eye_care)
    Switch switch_eye_care;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onBack() {
        finish();
    }

    @Override
    protected void initView() {
        super.initView();
        switch_eye_care.setChecked(Constant.IS_EYE_CARE_OPEN);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        switch_eye_care.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 每次 setChecked 时会触发onCheckedChanged 监听回调，而有时我们在设置setChecked后不想去自动触发 onCheckedChanged 里的具体操作, 即想屏蔽掉onCheckedChanged;加上此判断
                if (buttonView.isPressed()) {
                    if (isChecked){
                        openEye();
                    }else {
                        closeEye();
                    }
                    Constant.IS_EYE_CARE_OPEN = isChecked;
                }
            }
        });

    }
}