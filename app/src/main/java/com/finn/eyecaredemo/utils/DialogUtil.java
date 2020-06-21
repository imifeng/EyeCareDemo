package com.finn.eyecaredemo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.finn.eyecaredemo.R;
import com.finn.eyecaredemo.common.Constant;

/**
 * @author Finn
 * @date 2020
 */
public class DialogUtil {

    public static void showAlert(Context context, String message) {
        if (message.isEmpty()) {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.dialog_custom_layout, null);

        FrameLayout eye_content = layout.findViewById(R.id.eye_content);
        if (Constant.IS_EYE_CARE_OPEN) {
            eye_content.setBackgroundColor(EyeCareColorUtil.getFilterColor(30));
        } else {
            eye_content.setBackgroundColor(Color.TRANSPARENT);
        }

        TextView tv_title = layout.findViewById(R.id.tv_title);
        TextView tv_message = layout.findViewById(R.id.tv_message);
        TextView tv_ok = layout.findViewById(R.id.tv_ok);
        tv_message.setText(message);
        builder.setView(layout);
        final AlertDialog mAlertDialog = builder.create();

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAlertDialog != null && mAlertDialog.isShowing())
                    mAlertDialog.dismiss();
            }
        });

        mAlertDialog.show();
    }

}
