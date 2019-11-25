package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.service;

import com.devbrackets.android.playlistcore.api.MediaPlayerApi;
import com.devbrackets.android.playlistcore.components.playlisthandler.PlaylistHandler;
import com.devbrackets.android.playlistcore.manager.BasePlaylistManager;
import com.devbrackets.android.playlistcore.service.BasePlaylistService;
import com.ungpay.thirdpartyplatformsandframeworks.MyApplication;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.playlist.AudioApi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MediaService extends BasePlaylistService {


    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.getInstance().getPlaylistManager().getMediaPlayers().add(new AudioApi(getApplicationContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ArrayList<MediaPlayerApi> strings= (ArrayList<MediaPlayerApi>) MyApplication.getInstance().getPlaylistManager().getMediaPlayers();
        for (MediaPlayerApi mediaPlayerApi:strings){
            mediaPlayerApi.release();
        }
        MyApplication.getInstance().getPlaylistManager().getMediaPlayers().clear();
    }

    @NotNull
    @Override
    protected BasePlaylistManager getPlaylistManager() {
        return getPlaylistManager();
    }

    @NotNull
    @Override
    public PlaylistHandler newPlaylistHandler() {
        return null;
    }
}
