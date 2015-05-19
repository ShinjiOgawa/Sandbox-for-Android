/*
 * Copyright (c) 2015 World Trans System, Inc. All Rights Reserved.
 */
package com.apps.android.sandbox.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.VideoView;

import com.apps.android.sandbox.R;
import com.apps.android.sandbox.log.DLog;

/**
 * 動画再生画面{@link android.app.Activity}クラス。
 *
 * @author {@code WTS} 小川
 * @since {@code 2015/04/28}
 * @see FragmentActivity
 */
public class MovieActivity extends FragmentActivity {

    /** ログ出力に使用するタグを表す定数。 */
    // @SuppressWarnings("unused")
    private static final String TAG = MovieActivity.class.getSimpleName();

    /** {@link VideoView}オブジェクトを保持します。 */
    private VideoView mVideoView;

    /**
     * {@inheritDoc}
     *
     * @see android.app.Activity#onCreate(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_movie);

        mVideoView = (VideoView) super.findViewById(R.id.video_view);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override public void onPrepared(MediaPlayer mp) {
                mp.start();
                // mVideoView.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override public void onCompletion(MediaPlayer mp) {
//                final Intent intent = new Intent(getApplicationContext(), TopActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();
            }
        });
        final String uri = String.format("android.resource://%s/%d", super.getPackageName(), R.raw.movie_splash);
        DLog.d(TAG, String.format("##### URI is [ %s ].", uri) );
        mVideoView.setVideoURI(Uri.parse(uri));
    }

    /**
     * {@inheritDoc}
     *
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * {@inheritDoc}
     *
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
