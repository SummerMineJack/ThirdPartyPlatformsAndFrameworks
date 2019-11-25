package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist;

import com.devbrackets.android.exomedia.listener.OnBufferUpdateListener;
import com.devbrackets.android.exomedia.listener.OnCompletionListener;
import com.devbrackets.android.exomedia.listener.OnErrorListener;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.listener.OnSeekCompletionListener;
import com.devbrackets.android.playlistcore.api.MediaPlayerApi;
import com.devbrackets.android.playlistcore.listener.MediaStatusListener;

public abstract class BaseMediaApi implements MediaPlayerApi, OnPreparedListener, OnCompletionListener, OnErrorListener, OnSeekCompletionListener, OnBufferUpdateListener {
    protected boolean prepared;
    protected int bufferPercent;
    protected MediaStatusListener mediaStatusListener;

    public boolean isPrepared() {
        return prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public int getBufferPercent() {
        return bufferPercent;
    }

    public void setBufferPercent(int bufferPercent) {
        this.bufferPercent = bufferPercent;
    }

    public MediaStatusListener getMediaStatusListener() {
        return mediaStatusListener;
    }

    @Override
    public void setMediaStatusListener(MediaStatusListener mediaStatusListener) {
        this.mediaStatusListener = mediaStatusListener;
    }


    @Override
    public void onCompletion() {
        mediaStatusListener.onSeekComplete(this);
    }

    @Override
    public boolean onError(Exception e) {
        return mediaStatusListener.onError(this) == true;
    }

    @Override
    public void onPrepared() {
        prepared=true;
        mediaStatusListener.onPrepared(this);
    }

    @Override
    public void onSeekComplete() {
        mediaStatusListener.onSeekComplete(this);
    }

    @Override
    public void onBufferingUpdate(int percent) {
        bufferPercent = percent;
        mediaStatusListener.onBufferingUpdate(this, percent);
    }
}
