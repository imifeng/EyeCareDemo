package com.finn.eyecaredemo.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finn.eyecaredemo.common.Constant;
import com.finn.eyecaredemo.utils.EyeCareColorUtil;

import butterknife.ButterKnife;

/**
 * @author Finn
 * @date 2020
 */
public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout eyeCareView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int view = getLayoutId();
        if (view != 0) {
            setContentView(view);
        }
        ButterKnife.bind(this);

        //添加一层浮层（初始化）
        initEye();

        initView();
        initData();
        initEvent();
    }

    public abstract int getLayoutId();

    protected void initView(){
    }

    protected void initData(){
    }

    protected void initEvent(){
    }

    protected abstract void onBack();

    /**
     * Listen the back key click event
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //onRestart中用来返回到已存在页面时，刷新护眼蒙层色值
        if (Constant.IS_EYE_CARE_OPEN){
            openEye();
        }else {
            closeEye();
        }
    }

    /**
     * 添加护眼模式浮层
     */
    private void initEye() {
        eyeCareView = new FrameLayout(this);
        if (Constant.IS_EYE_CARE_OPEN){
            openEye();
        }else {
            closeEye();
        }
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().addContentView(eyeCareView, params);
    }

    /**
     * 开启护眼模式
     */
    public void openEye() {
        if (eyeCareView != null) {
            eyeCareView.setBackgroundColor(EyeCareColorUtil.getFilterColor(30));
        }
    }

    /**
     * 关闭护眼模式
     */
    public void closeEye() {
        if (eyeCareView != null) {
            eyeCareView.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
