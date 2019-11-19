package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import com.devbrackets.android.exomedia.listener.OnBufferUpdateListener;
import com.devbrackets.android.exomedia.listener.OnCompletionListener;
import com.devbrackets.android.exomedia.listener.OnErrorListener;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.listener.OnSeekCompletionListener;
import com.devbrackets.android.playlistcore.api.MediaPlayerApi;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.devbrackets.android.playlistcore.listener.MediaStatusListener;

import org.jetbrains.annotations.NotNull;

public class BaseMediaApi implements MediaPlayerApi, OnPreparedListener, OnCompletionListener, OnErrorListener, OnSeekCompletionListener, OnBufferUpdateListener {

    private boolean prepared;
    private int bufferPercent;
    private MediaStatusListener statusListener;

    public MediaStatusListener getStatusListener() {
        return statusListener;
    }

    public void setStatusListener(MediaStatusListener statusListener) {
        this.statusListener = statusListener;
    }

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

    @Override
    public void onBufferingUpdate(int percent) {
        this.bufferPercent = percent;
        MediaStatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            statusListener.onBufferingUpdate(this, percent);
        }

    }

    @Override
    public void onCompletion() {
        MediaStatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            statusListener.onCompletion(this);
        }
    }

    @Override
    public boolean onError(Exception e) {
        MediaStatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            if (statusListener.onError(this)) {
                return true;
            }
            statusListener.onCompletion(this);
        }
        return false;
    }

    @Override
    public void onPrepared() {
        MediaStatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            statusListener.onPrepared(this);
        }
    }

    @Override
    public void onSeekComplete() {
        MediaStatusListener statusListener = this.statusListener;
        if (statusListener != null) {
            statusListener.onSeekComplete(this);
        }

    }

    @Override
    public int getBufferedPercent() {
        return 0;
    }

    @Override
    public long getCurrentPosition() {
        return 0;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public boolean getHandlesOwnAudioFocus() {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public boolean handlesItem(@NotNull PlaylistItem playlistItem) {
        return false;
    }

    @Override
    public void pause() {

    }

    @Override
    public void play() {

    }

    @Override
    public void playItem(@NotNull PlaylistItem playlistItem) {

    }

    @Override
    public void release() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void seekTo(long l) {

    }

    @Override
    public void setMediaStatusListener(@NotNull MediaStatusListener mediaStatusListener) {

    }

    @Override
    public void setVolume(float v, float v1) {

    }

    @Override
    public void stop() {

    }
}
