package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.manager;

import android.app.Application;

import com.devbrackets.android.exomedia.listener.VideoControlsButtonListener;
import com.devbrackets.android.exomedia.ui.widget.VideoControls;
import com.devbrackets.android.playlistcore.manager.ListPlaylistManager;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist.VideoApi;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.service.MediaService;

import org.jetbrains.annotations.NotNull;

public class PlaylistManager extends ListPlaylistManager {

    public PlaylistManager(@NotNull Application application) {
        super(application, MediaService.class);
    }

    /**
     * 添加视频
     */
    private void addVideoApi(VideoApi videoApi) {
        getMediaPlayers().add(videoApi);
        updateVideoControls(videoApi);
        registerPlaylistListener(videoApi);
    }

    /**
     * 移除视频
     */
    private void removeVideApi(VideoApi videoApi) {
        videoApi.getVideoView().getVideoControls().setButtonListener(null);
        unRegisterPlaylistListener(videoApi);
        getMediaPlayers().remove(videoApi);
    }

    /**
     * 更新
     */
    private void updateVideoControls(VideoApi videoApi) {
        VideoControls videoControls = videoApi.getVideoView().getVideoControls();
        videoControls.setPreviousButtonRemoved(false);
        videoControls.setNextButtonRemoved(false);
        videoControls.setButtonListener(new ControlsListener());

    }

    private class ControlsListener implements VideoControlsButtonListener {

        @Override
        public boolean onPlayPauseClicked() {
            invokePausePlay();
            return true;
        }

        @Override
        public boolean onPreviousClicked() {
            invokePrevious();
            return false;
        }

        @Override
        public boolean onNextClicked() {
            invokeNext();
            return false;
        }

        @Override
        public boolean onRewindClicked() {
            return false;
        }

        @Override
        public boolean onFastForwardClicked() {
            return false;
        }
    }
}
