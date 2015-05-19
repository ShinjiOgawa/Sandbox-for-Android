/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.log;

import com.apps.android.sandbox.BuildConfig;

/**
 * {@link android.util.Log}拡張クラス。<p />
 *
 * {@code VERBOSE}レベルと{@code DEBUG}レベルのログはデバッグ{@code ver.}でのみロギングします。<br />
 * デバッグ{@code ver.}であるかは{@link BuildConfig#DEBUG}で設定されています。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/02/27}
 * @see android.util.Log
 */
public final class DLog {

    /** デバッグログ出力フラグを表す定数。 */
    private static final boolean IS_ENABLE_DEBUG_LOGGING = BuildConfig.DEBUG;

    /**
     * Send a {@code VERBOSE} log message.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static final int v(final String tag, final String msg) {
        if (IS_ENABLE_DEBUG_LOGGING) {
            return android.util.Log.v(tag, msg);
        } else {
            return 0;
        }
    }

    /**
     * Send a {@code VERBOSE} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static final int v(final String tag, final String msg, final Throwable tr) {
        if (IS_ENABLE_DEBUG_LOGGING) {
            return android.util.Log.v(tag, msg, tr);
        } else {
            return 0;
        }
    }

    /**
     * Send a {@code DEBUG} log message.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static final int d(final String tag, final String msg) {
        if (IS_ENABLE_DEBUG_LOGGING) {
            return android.util.Log.d(tag, msg);
        } else {
            return 0;
        }
    }

    /**
     * Send a {@code DEBUG} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static final int d(final String tag, final String msg, final Throwable tr) {
        if (IS_ENABLE_DEBUG_LOGGING) {
            return android.util.Log.d(tag, msg, tr);
        } else {
            return 0;
        }
    }

    /**
     * Send an {@code INFO} log message.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static final int i(final String tag, final String msg) {
        return android.util.Log.i(tag, msg);
    }

    /**
     * Send a {@code INFO} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static final int i(final String tag, final String msg, final Throwable tr) {
        return android.util.Log.i(tag, msg, tr);
    }

    /**
     * Send a {@code WARN} log message.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static final int w(final String tag, final String msg) {
        return android.util.Log.w(tag, msg);
    }

    /**
     * Send a {@code WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static final int w(final String tag, final String msg, final Throwable tr) {
        return android.util.Log.w(tag, msg, tr);
    }

    /**
     * Send a {@code WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static final int w(final String tag, final Throwable tr) {
        return android.util.Log.w(tag, tr);
    }

    /**
     * Send an {@code ERROR} log message.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static final int e(final String tag, final String msg) {
        return android.util.Log.e(tag, msg);
    }

    /**
     * Send a {@code ERROR} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static final int e(final String tag, final String msg, final Throwable tr) {
        return android.util.Log.e(tag, msg, tr);
    }

    /**
     * What a Terrible Failure:<br />
     * Report a condition that should never happen.<br />
     * The error will always be logged at level ASSERT with the call stack.<br />
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    public static final int wtf(final String tag, final String msg) {
        return android.util.Log.wtf(tag, msg);
    }

    /**
     * What a Terrible Failure:<br />
     * Report an exception that should never happen.<br />
     * Similar to {@link #wtf(String, String)}, with an exception to log.
     *
     * @param tag Used to identify the source of a log message.
     * @param tr An exception to log.
     */
    public static final int wtf(final String tag, final Throwable tr) {
            return android.util.Log.wtf(tag, tr);
    }

    /**
     * What a Terrible Failure:<br />
     * Report an exception that should never happen.<br />
     * Similar to {@link #wtf(String, Throwable)}, with a message as well.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.  May be null.
     */
    public static final int wtf(final String tag, final String msg, final Throwable tr) {
        return android.util.Log.wtf(tag, msg, tr);
    }
}
