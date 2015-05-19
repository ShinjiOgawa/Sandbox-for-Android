/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.activity;

import static com.apps.android.sandbox.SandboxApplication.sDisplayMetricsHeightPixels;
import static com.apps.android.sandbox.SandboxApplication.sDisplayMetricsWidthPixels;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.apps.android.sandbox.R;
import com.apps.android.sandbox.log.DLog;

/**
 * 動画再生後画面{@link android.app.Activity}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/28}
 * @see FragmentActivity
 */
public class TopActivity extends FragmentActivity {

    /** ログ出力に使用するタグを表す定数。 */
    private static final String TAG = TopActivity.class.getSimpleName();

    /**
     * {@inheritDoc}
     *
     * @see android.app.Activity#onCreate(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DisplayMetrics metrics = super.getResources().getDisplayMetrics();
        final int displayMetricsDensityDpi = metrics.densityDpi;

        Log.i(TAG, String.format("##### DisplayMetricsDensityDpi is [ %d ].", displayMetricsDensityDpi));

        final int qhdScreenWidth  = 960;
        final int qhdScreenHeight = 540;

        int resId = R.layout.view_video_ended_overlay;
        if (sDisplayMetricsWidthPixels  == qhdScreenWidth &&
            sDisplayMetricsHeightPixels == qhdScreenHeight) {
            DLog.i(TAG, "##### QHD.");
            resId = R.layout.view_video_ended_overlay_qhd;
        } else if (displayMetricsDensityDpi == DisplayMetrics.DENSITY_HIGH) {
            resId = R.layout.view_video_ended_overlay_hdpi;
        }

        super.setContentView(resId);

        super.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                TopActivity.super.finish();
            }
        });
    }
}
