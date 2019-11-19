package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import com.devbrackets.android.playlistcore.api.PlaylistItem;

import org.jetbrains.annotations.Nullable;

public class MediaItem implements PlaylistItem {
    private  AudioEntity audioEntity;
    private boolean isAudio;

    public MediaItem(AudioEntity audioEntity, boolean isAudio) {
        this.audioEntity = audioEntity;
        this.isAudio = isAudio;
    }

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
        return this.audioEntity.getAudioImage();
    }

    @Override
    public boolean getDownloaded() {
        return false;
    }

    @Nullable
    @Override
    public String getDownloadedMediaUri() {
        return this.audioEntity.getAudioImage();
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public int getMediaType() {
        return 0;
    }

    @Nullable
    @Override
    public String getMediaUrl() {
        return this.audioEntity.getAudioUrl();
    }

    @Nullable
    @Override
    public String getThumbnailUrl() {
        return this.audioEntity.getAudioImage();
    }

    @Nullable
    @Override
    public String getTitle() {
        return this.audioEntity.getAudioTitle();
    }
}
