/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.activity.base;

import android.support.v7.app.AppCompatActivity;

/**
 * {@link android.app.Activity}の基底となる{@link AppCompatActivity}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/28}
 * @see AppCompatActivity
 */
public class BaseActivity extends AppCompatActivity {

    /** ログ出力に使用するタグを表す定数。 */
    @SuppressWarnings("unused")
    private static final String TAG = BaseActivity.class.getSimpleName();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
//        executor.schedule(new Runnable() {
//            @Override public void run() {
//                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
//                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                    @Override public void uncaughtException(Thread thread, Throwable ex) {
//                        DLog.e(TAG, "##### Catch an UncaughtException.", ex);
//                        defaultUncaughtExceptionHandler.uncaughtException(thread, new AppCrashedException("On crash test.", ex));
//                        finish();
//                        Process.killProcess(Process.myPid());
//                    }
//                });
//            }
//        }, 0, TimeUnit.SECONDS);
//    }
}
