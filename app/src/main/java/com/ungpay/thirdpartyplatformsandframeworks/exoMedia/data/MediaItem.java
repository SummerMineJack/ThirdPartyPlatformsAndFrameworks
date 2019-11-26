package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.data;

import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.AudioEntity;

import org.jetbrains.annotations.Nullable;

public class MediaItem implements PlaylistItem {

    private AudioEntity audioEntity;
    private boolean isAudio;


    @Nullable
    @Override
    public String getAlbum() {
        return "PlaylistCore Demo";
    }

    @Nullable
    @Override
    public String getArtist() {
        return "Unknown Artist";
    }

    @Nullable
    @Override
    public String getArtworkUrl() {
        return audioEntity.getAudioImage();
    }

    @Override
    public boolean getDownloaded() {
        return false;
    }

    @Nullable
    @Override
    public String getDownloadedMediaUri() {
        return null;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public int getMediaType() {
        return isAudio ? 1 : 2;
    }

    @Nullable
    @Override
    public String getMediaUrl() {
        return audioEntity.getAudioUrl();
    }

    @Nullable
    @Override
    public String getThumbnailUrl()    {
        return audioEntity.getAudioImage();
    }

    @Nullable
    @Override
    public String getTitle() {
        return audioEntity.getAudioTitle();
    }
}
