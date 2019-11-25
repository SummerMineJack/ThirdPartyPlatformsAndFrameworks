package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.service;

import com.devbrackets.android.playlistcore.api.MediaPlayerApi;
import com.devbrackets.android.playlistcore.components.playlisthandler.DefaultPlaylistHandler;
import com.devbrackets.android.playlistcore.components.playlisthandler.PlaylistHandler;
import com.devbrackets.android.playlistcore.manager.BasePlaylistManager;
import com.devbrackets.android.playlistcore.service.BasePlaylistService;
import com.ungpay.thirdpartyplatformsandframeworks.MyApplication;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.manager.PlaylistManager;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist.AudioApi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MediaService extends BasePlaylistService {
    private PlaylistManager playlistManager;

    public MediaService() {
        playlistManager = MyApplication.getInstance().getPlaylistManager();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playlistManager.getMediaPlayers().add(new AudioApi(getApplicationContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ArrayList<MediaPlayerApi> strings = (ArrayList<MediaPlayerApi>) playlistManager.getMediaPlayers();
        for (MediaPlayerApi mediaPlayerApi : strings) {
            mediaPlayerApi.release();
        }
        playlistManager.getMediaPlayers().clear();
    }

    @NotNull
    @Override
    protected BasePlaylistManager getPlaylistManager() {
        return getPlaylistManager();
    }

    @NotNull
    @Override
    public PlaylistHandler newPlaylistHandler() {
        MediaImageProvider mediaImageProvider = new MediaImageProvider(getApplicationContext(), new MediaImageProvider.ImageComplete() {
            @Override
            public void onImageUpdated() {
                getPlaylistHandler().updateMediaControls();
            }
        });
        return (new DefaultPlaylistHandler.Builder(getApplicationContext(), this.getClass(), this.getPlaylistManager(), mediaImageProvider)).build();
    }
}
