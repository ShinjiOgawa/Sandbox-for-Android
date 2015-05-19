/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

import com.apps.android.sandbox.exception.AppCrashedException;
import com.apps.android.sandbox.log.DLog;

/**
 * {@code Sandbox} {@link Application}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/21}
 * @see Application
 */
public class SandboxApplication extends Application {

    /** ログ出力に使用するタグを表す定数。 */
    private static final String TAG = SandboxApplication.class.getSimpleName();

    /** 端末の画面{@code width}ピクセルを保持します。 */
    public static int sDisplayMetricsWidthPixels;
    /** 端末の画面{@code height}ピクセルを保持します。 */
    public static int sDisplayMetricsHeightPixels;
    /** 端末の画面{@code density}を保持します。 */
    public static float sDisplayMetricsDensity;
    /** 端末の画面{@code density dpi}を保持します。 */
    public static int sDisplayMetricsDensityDpi;
    /** 端末の画面{@code scaled density}を保持します。 */
    public static float sDisplayMetricsScaledDensity;
    /** 端末の画面{@code X軸dpi}を保持します。 */
    public static float sDisplayMetricsXdpi;
    /** 端末の画面{@code Y軸dpi}を保持します。 */
    public static float sDisplayMetricsYdpi;

    /** 端末の画面{@code width}を保持します。 */
    public static float sDisplayWidth;
    /** 端末の画面{@code height}を保持します。 */
    public static float sDisplayHeight;

    /** アプリケーションの{@link Typeface}を保持します。 */
    public static Typeface sDefaultTypeface = Typeface.DEFAULT;

    /** ハードウェア・メニューキー存在フラグを保持します。 */
    public static boolean sHasPermanentMenuKey;
    /** ナビゲーション・バー{@code (Portrait)}の高さを保持します。 */
    public static int sNavigationBarHeightPortrait;
    /** ナビゲーション・バー{@code (Landscape)}の高さを保持します。 */
    public static int sNavigationBarHeightLandscape;

    /**
     * {@inheritDoc}
     *
     * @see Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();

        initUncaughtExceptionHandler();

        final Resources resources = super.getResources();
        if (Build.VERSION_CODES.JELLY_BEAN <= Build.VERSION.SDK_INT) {
            sNavigationBarHeightPortrait  = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
            sNavigationBarHeightLandscape = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height_landscape", "dimen", "android"));
        }

        final DisplayMetrics metrics = super.getResources().getDisplayMetrics();
        sDisplayMetricsWidthPixels   = metrics.widthPixels;
        sDisplayMetricsHeightPixels  = metrics.heightPixels;
        sDisplayMetricsDensity       = metrics.density;
        sDisplayMetricsDensityDpi    = metrics.densityDpi;
        sDisplayMetricsScaledDensity = metrics.scaledDensity;
        sDisplayMetricsXdpi          = metrics.xdpi;
        sDisplayMetricsYdpi          = metrics.ydpi;
        sHasPermanentMenuKey         = ViewConfiguration.get(super.getApplicationContext()).hasPermanentMenuKey();

        DLog.d(TAG, String.format("#####    sDisplayMetricsWidthPixels is [ %d ]."   , sDisplayMetricsWidthPixels));
        DLog.d(TAG, String.format("#####   sDisplayMetricsHeightPixels is [ %d ]."   , sDisplayMetricsHeightPixels));
        DLog.d(TAG, String.format("#####        sDisplayMetricsDensity is [ %.1f ]." , sDisplayMetricsDensity));
        DLog.d(TAG, String.format("#####     sDisplayMetricsDensityDpi is [ %d ]."   , sDisplayMetricsDensityDpi));
        DLog.d(TAG, String.format("#####  sDisplayMetricsScaledDensity is [ %.1f ]." , sDisplayMetricsScaledDensity));
        DLog.d(TAG, String.format("#####           sDisplayMetricsXdpi is [ %.1f ]." , sDisplayMetricsXdpi));
        DLog.d(TAG, String.format("#####           sDisplayMetricsYdpi is [ %.1f ]." , sDisplayMetricsYdpi));
        DLog.d(TAG, String.format("#####                   VM HeapSize is [ %d ] MB.", ((ActivityManager) super.getApplicationContext().getSystemService(ACTIVITY_SERVICE)).getMemoryClass()));
        DLog.d(TAG, String.format("#####       NativeHeapAllocatedSize is [ %d ]."   , Debug.getNativeHeapAllocatedSize()));
        DLog.d(TAG, String.format("#####                NativeHeapSize is [ %d ]."   , Debug.getNativeHeapSize()));
        DLog.d(TAG, String.format("#####            NativeHeapFreeSize is [ %d ]."   , Debug.getNativeHeapFreeSize()));
        DLog.d(TAG, String.format("#####          RuntimeMaxMemorySize is [ %d ]."   , Runtime.getRuntime().maxMemory()));
        DLog.d(TAG, String.format("#####        RuntimeTotalMemorySize is [ %d ]."   , Runtime.getRuntime().totalMemory()));
        DLog.d(TAG, String.format("#####         RuntimeFreeMemorySize is [ %d ]."   , Runtime.getRuntime().freeMemory()));
        DLog.d(TAG, String.format("#####           HasPermanentMenuKey is [ %b ]."   , sHasPermanentMenuKey));
        DLog.d(TAG, String.format("#####  sNavigationBarHeightPortrait is [ %d ]."   , sNavigationBarHeightPortrait));
        DLog.d(TAG, String.format("##### sNavigationBarHeightLandscape is [ %d ]."   , sNavigationBarHeightLandscape));
    }

    /**
     * 実行時例外処理{@code Handler}の初期化処理を実行します。
     *
     * @see Fabric#with(Context, Kit[])
     */
    private void initUncaughtExceptionHandler() {

        Fabric.with(super.getApplicationContext(), new Crashlytics());

        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(new Runnable() {
            @Override public void run() {
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override public void uncaughtException(Thread thread, Throwable ex) {
                        DLog.e(TAG, "##### Catch an UncaughtException.", ex);
                        Crashlytics.logException(ex);
                        defaultUncaughtExceptionHandler.uncaughtException(thread, new AppCrashedException("##### On crash test.", ex));
                    }
                });
            }
        }, 0, TimeUnit.SECONDS);
    }
}
