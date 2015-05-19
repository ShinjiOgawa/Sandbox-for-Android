package com.apps.android.sandbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * オーバースクロールでバウンスする{@link ScrollView}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/17}
 * @see ScrollView
 */
public class BounceScrollView extends ScrollView {

    /** オーバースクロールの距離を表す定数。 */
    private static final int OVERSCROLL_DISTANCE = 200;

    /**
     * 指定した条件で初期化した{@link BounceScrollView}インスタンスを生成します。
     *
     * @param context {@link Context}
     */
    public BounceScrollView(Context context) {
        super(context);
    }

    /**
     * 指定した条件で初期化した{@link BounceScrollView}インスタンスを生成します。
     *
     * @param context {@link Context}
     * @param attrs {@link AttributeSet}
     */
    public BounceScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 指定した条件で初期化した{@link BounceScrollView}インスタンスを生成します。
     *
     * @param context {@link Context}
     * @param attrs {@link AttributeSet}
     * @param defStyleAttr {@code int}
     */
    public BounceScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * {@inheritDoc}
     *
     * @see android.view.View#overScrollBy(int, int, int, int, int, int, int, int, boolean)
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, OVERSCROLL_DISTANCE, isTouchEvent);
    }

    /**
     * {@inheritDoc}
     *
     * @see ScrollView#onOverScrolled(int, int, boolean, boolean)
     */
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }
}
