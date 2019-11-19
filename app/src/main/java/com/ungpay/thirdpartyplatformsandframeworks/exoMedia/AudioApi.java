package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;

import com.devbrackets.android.exomedia.AudioPlayer;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.google.android.exoplayer2.util.EventLogger;

import org.jetbrains.annotations.NotNull;

public class AudioApi extends BaseMediaApi {
    private AudioPlayer audioPlayer;

    public boolean isPlaying() {
        return this.audioPlayer.isPlaying();
    }

    public boolean getHandlesOwnAudioFocus() {
        return false;
    }

    public long getCurrentPosition() {
        return this.isPrepared() ? this.audioPlayer.getCurrentPosition() : 0L;
    }

    public long getDuration() {
        return this.isPrepared() ? this.audioPlayer.getDuration() : 0L;
    }

    public int getBufferedPercent() {
        return this.getBufferPercent();
    }

    public void play() {
        this.audioPlayer.start();
    }

    public void pause() {
        this.audioPlayer.pause();
    }

    public void stop() {
        this.audioPlayer.stopPlayback();
    }

    public void reset() {
        this.audioPlayer.reset();
    }

    public void release() {
        this.audioPlayer.release();
    }

    public void setVolume(@FloatRange(from = 0.0D, to = 1.0D) float left, @FloatRange(from = 0.0D, to = 1.0D) float right) {
        this.audioPlayer.setVolume(left, right);
    }

    public void seekTo(@IntRange(from = 0L) long milliseconds) {
        this.audioPlayer.seekTo((long) ((int) milliseconds));
    }

    public boolean handlesItem(@NotNull MediaItem item) {
        return item.getMediaType() == 1;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean handlesItem(PlaylistItem var1) {
        return this.handlesItem((MediaItem) var1);
    }

    public void playItem(@NotNull MediaItem item) {
        try {
            this.setPrepared(false);
            this.setBufferPercent(0);
            this.audioPlayer.setDataSource(Uri.parse(item.getDownloaded() ? item.getDownloadedMediaUri() : item.getMediaUrl()));
            this.audioPlayer.prepareAsync();
        } catch (Exception var3) {
        }

    }

    // $FF: synthetic method
    // $FF: bridge method
    public void playItem(PlaylistItem var1) {
        this.playItem((MediaItem) var1);
    }

    public AudioApi(@NotNull Context context) {
        this.audioPlayer = new AudioPlayer(context.getApplicationContext());
        this.audioPlayer.setOnErrorListener(this);
        this.audioPlayer.setOnPreparedListener(this);
        this.audioPlayer.setOnCompletionListener(this);
        this.audioPlayer.setOnSeekCompletionListener(this);
        this.audioPlayer.setOnBufferUpdateListener(this);
        this.audioPlayer.setWakeMode(context, 1);
        this.audioPlayer.setAudioStreamType(3);
        this.audioPlayer.setAnalyticsListener((new EventLogger(null)));
    }
}
