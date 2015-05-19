/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.exception;

/**
 * アプリ・クラッシュ{@link java.lang.Exception}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/28}
 * @see RuntimeException
 */
public class AppCrashedException extends RuntimeException {

    /** シリアル･バージョン{@code UID}を表す定数。 */
    private static final long serialVersionUID = 8893492691904492161L;

    /**
     * This field holds the exception ex if the {@link #AppCrashedException(String, Throwable)}
     * constructor was used to instantiate the object.
     *
     * @serial
     */
    private Throwable mThrowable;

    /**
     * Constructs a {@link AppCrashedException} with no detail message.
     */
    public AppCrashedException() {
        super((Throwable) null); // Disallow initCause.
    }

    /**
     * Constructs a {@link AppCrashedException} with the specified detail message.
     *
     * @param detailMessage the detail message.
     */
    public AppCrashedException(String detailMessage) {
        super(detailMessage, null); // Disallow initCause.
    }

    /**
     * Constructs a {@link AppCrashedException} with the specified detail message
     * and optional exception that was raised while loading the class.
     *
     * @param detailMessage the detail message.
     * @param throwable the exception that was raised while loading the class.
     */
    public AppCrashedException(String detailMessage, Throwable throwable) {
        super(detailMessage, null); // Disallow initCause.
        mThrowable = throwable;
    }

    /**
     * Returns the exception that was raised if an error occurred while attempting to load the class.
     * Otherwise, returns {@code null}.<p />
     *
     * This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of obtaining this information.
     *
     * @return the {@link Exception} that was raised while loading a class.
     */
    public Throwable getException() {
        return mThrowable;
    }

    /**
     * Returns the cause of this exception
     * (the exception that was raised if an error occurred while attempting to load the class;
     * otherwise {@code null}).
     *
     * @return the cause of this exception.
     */
    @Override
    public Throwable getCause() {
        return mThrowable;
    }
}
