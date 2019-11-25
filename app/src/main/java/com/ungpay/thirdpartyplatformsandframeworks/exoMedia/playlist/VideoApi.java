package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist;

import android.net.Uri;

import com.devbrackets.android.exomedia.ui.widget.VideoControls;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.devbrackets.android.playlistcore.data.PlaybackState;
import com.devbrackets.android.playlistcore.listener.PlaylistListener;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.data.MediaItem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VideoApi extends BaseMediaApi implements PlaylistListener {


    private VideoView videoView;

    public VideoApi(VideoView videoView) {
        this.videoView = videoView;
        this.videoView.setOnErrorListener(this);
        this.videoView.setOnPreparedListener(this);
        this.videoView.setOnCompletionListener(this);
        this.videoView.setOnSeekCompletionListener(this);
        this.videoView.setOnBufferUpdateListener(this);
    }

    public VideoView getVideoView() {
        return videoView;
    }

    public void setVideoView(VideoView videoView) {
        this.videoView = videoView;
    }

    @Override
    public int getBufferedPercent() {
        return this.getBufferPercent();
    }

    @Override
    public long getCurrentPosition() {
        return isPrepared() ? videoView.getCurrentPosition() : 0L;
    }

    @Override
    public long getDuration() {
        return isPrepared() ? videoView.getDuration() : 0L;
    }

    @Override
    public boolean getHandlesOwnAudioFocus() {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return videoView.isPlaying();
    }

    public boolean handlesItem(@NotNull MediaItem mediaItem) {
        return mediaItem.getMediaType() == 2;
    }

    @Override
    public void pause() {
        videoView.pause();
    }

    @Override
    public void play() {
        videoView.start();
    }

    public void playItem(@NotNull MediaItem mediaItem) {
        setPrepared(false);
        setBufferPercent(0);
        videoView.setVideoURI(Uri.parse(mediaItem.getDownloaded() ? mediaItem.getDownloadedMediaUri() : mediaItem.getMediaUrl()));
    }

    @Override
    public void release() {
        videoView.suspend();
    }

    @Override
    public void reset() {

    }

    @Override
    public void seekTo(long l) {
        videoView.seekTo((int) l);
    }

    @Override
    public void setVolume(float left, float right) {
        videoView.setVolume((left + right) / (float) 2);
    }

    @Override
    public void stop() {
        videoView.stopPlayback();
    }

    @Override
    public boolean handlesItem(@NotNull PlaylistItem playlistItem) {
        return this.handlesItem((MediaItem) playlistItem);
    }

    @Override
    public void playItem(@NotNull PlaylistItem playlistItem) {
        this.playItem((MediaItem) playlistItem);
    }

    @Override
    public boolean onPlaybackStateChanged(@NotNull PlaybackState playbackState) {
        return false;
    }

    @Override
    public boolean onPlaylistItemChanged(@Nullable PlaylistItem playlistItem, boolean hasNext, boolean hasPrevious) {
        return onPlaylistItemChanged((MediaItem) playlistItem, hasNext, hasPrevious);
    }

    public boolean onPlaylistItemChanged(@Nullable MediaItem mediaItem, boolean hasNext, boolean hasPrevious) {
        VideoControls videoControls = videoView.getVideoControls();
        videoControls.setTitle(mediaItem.getTitle());
        videoControls.setSubTitle(mediaItem.getAlbum());
        videoControls.setDescription(mediaItem.getArtist());
        videoControls.setPreviousButtonEnabled(hasPrevious);
        videoControls.setNextButtonEnabled(hasNext);
        return false;
    }
}
