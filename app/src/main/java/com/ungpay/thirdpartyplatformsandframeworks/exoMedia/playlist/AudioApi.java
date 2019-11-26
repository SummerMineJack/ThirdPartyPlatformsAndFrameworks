package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist;

import android.content.Context;
import android.net.Uri;

import com.devbrackets.android.exomedia.AudioPlayer;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.google.android.exoplayer2.util.EventLogger;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.data.MediaItem;

import org.jetbrains.annotations.NotNull;

public class AudioApi extends BaseMediaApi {

    private AudioPlayer audioPlayer;

    public AudioApi(Context context) {
        this.audioPlayer = new AudioPlayer(context);
        this.audioPlayer.setOnErrorListener(this);
        this.audioPlayer.setOnPreparedListener(this);
        this.audioPlayer.setOnCompletionListener(this);
        this.audioPlayer.setOnSeekCompletionListener(this);
        this.audioPlayer.setOnBufferUpdateListener(this);
        this.audioPlayer.setWakeMode(context, 1);
        this.audioPlayer.setAudioStreamType(3);
        this.audioPlayer.setAnalyticsListener((new EventLogger(null)));
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public int getBufferedPercent() {
        return getBufferPercent();
    }

    @Override
    public long getCurrentPosition() {
        return isPrepared() ? audioPlayer.getCurrentPosition() : 0L;
    }

    @Override
    public long getDuration() {
        return isPrepared() ? audioPlayer.getDuration() : 0L;
    }

    @Override
    public boolean getHandlesOwnAudioFocus() {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return audioPlayer.isPlaying();
    }

    @Override
    public boolean handlesItem(@NotNull PlaylistItem playlistItem) {
        return handlesItem((MediaItem) playlistItem);
    }

    public boolean handlesItem(@NotNull MediaItem mediaItem) {
        return mediaItem.getMediaType() == 1;
    }

    @Override
    public void pause() {
        audioPlayer.pause();
    }

    @Override
    public void play() {
        audioPlayer.start();
    }

    @Override
    public void playItem(@NotNull PlaylistItem playlistItem) {
        playItem((MediaItem) playlistItem);
    }

    public void playItem(@NotNull MediaItem mediaItem) {
        setPrepared(false);
        setBufferPercent(0);
        audioPlayer.setDataSource(Uri.parse(mediaItem.getDownloaded() ? mediaItem.getDownloadedMediaUri() : mediaItem.getMediaUrl()));
        audioPlayer.prepareAsync();
    }

    @Override
    public void release() {
        audioPlayer.release();
    }

    @Override
    public void reset() {
        audioPlayer.reset();

    }

    @Override
    public void seekTo(long l) {
        audioPlayer.seekTo(l);
    }

    @Override
    public void setVolume(float left, float right) {
        audioPlayer.setVolume(left, right);
    }

    @Override
    public void stop() {
        audioPlayer.stopPlayback();
    }
}
