/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.apps.android.sandbox.R;
import com.apps.android.sandbox.activity.base.BaseActivity;

/**
 * メニュー画面{@link android.app.Activity}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/28}
 * @see BaseActivity
 */
public class MenuActivity extends BaseActivity implements View.OnClickListener {

    /** ログ出力に使用するタグを表す定数。 */
    @SuppressWarnings("unused")
    private static final String TAG = MenuActivity.class.getSimpleName();

    /**
     * {@inheritDoc}
     *
     * @see android.app.Activity#onCreate(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_menu);

        final Toolbar toolBar = (Toolbar) super.findViewById(R.id.tool_bar);
        super.setSupportActionBar(toolBar);

        final Button btn1 = (Button) super.findViewById(R.id.btn_1);
        final Button btn2 = (Button) super.findViewById(R.id.btn_2);
        final Button btn3 = (Button) super.findViewById(R.id.btn_3);
        final Button btn4 = (Button) super.findViewById(R.id.btn_4);
        final Button btn5 = (Button) super.findViewById(R.id.btn_5);
        final Button btn6 = (Button) super.findViewById(R.id.btn_6);
        final Button btn7 = (Button) super.findViewById(R.id.btn_7);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn1.setText(super.getString(R.string.btn_show_movie));
        btn2.setText(super.getString(R.string.btn_show_video_ended_view));
        btn3.setText(super.getString(R.string.btn_exec_crash_application));
        btn4.setText(R.string.btn_show_crosswalk_web_view);
    }

    /**
     * ボタン・タップ時の処理を実行します。
     *
     * @param view {@link View}
     * @see android.view.View.OnClickListener#onClick(View)
     */
    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.btn_1:
                intent = new Intent(super.getApplicationContext(), MovieActivity.class);
                break;
            case R.id.btn_2:
                intent = new Intent(super.getApplicationContext(), TopActivity.class);
                break;
            case R.id.btn_3:
                new ExecuteCrashAppDialog().show(super.getFragmentManager(), null);
                break;
            case R.id.btn_4:
                break;
            case R.id.btn_5:
                break;
            case R.id.btn_6:
                break;
            case R.id.btn_7:
                break;
            default:
                break;
        }

        if (intent != null) super.startActivity(intent);
    }

    /**
     * アプリがクラッシュする処理を実行します。
     *
     * @return {@code int value}
     */
    @SuppressWarnings("all")
    protected int executeCrashApp() {
        return 1 / 0;
    }

    /**
     * アプリクラッシュ処理実行確認{@link DialogFragment}クラス。
     *
     * @see DialogFragment
     */
    public static class ExecuteCrashAppDialog extends DialogFragment {

        /** {@link Dialog}を出力する{@link Activity}を保持します。 */
        private MenuActivity mActivity;

        /**
         * {@inheritDoc}
         *
         * @param activity {@link Activity}
         * @see DialogFragment#onAttach(Activity)
         */
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            if (activity != null && activity instanceof MenuActivity) {
                mActivity = (MenuActivity) activity;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /**
         * {@inheritDoc}
         *
         * @see DialogFragment#onDetach()
         */
        @Override
        public void onDetach() {
            super.onDetach();
            mActivity = null;
        }

        /**
         * {@inheritDoc}
         *
         * @param savedInstanceState {@link Bundle}
         * @return {@link Dialog}
         * @see DialogFragment#onCreate(Bundle)
         */
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
            builder.setTitle(null)
                   .setMessage(super.getString(R.string.msg_exec_crash_application))
                   .setPositiveButton(super.getString(R.string.btn_yes_ja), new DialogInterface.OnClickListener() {
                        @Override public void onClick(DialogInterface dialog, int which) {
                            mActivity.executeCrashApp();
                        }
                    })
                   .setNegativeButton(super.getString(R.string.btn_no_ja), null);

            return builder.create();
        }
    }
}
