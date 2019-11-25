package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.service;

import android.graphics.Bitmap;

import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.devbrackets.android.playlistcore.components.image.ImageProvider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MediaImageProvider implements ImageProvider {
    @Nullable
    @Override
    public Bitmap getLargeNotificationImage() {
        return null;
    }

    @Override
    public int getNotificationIconRes() {
        return 0;
    }

    @Nullable
    @Override
    public Bitmap getRemoteViewArtwork() {
        return null;
    }

    @Override
    public int getRemoteViewIconRes() {
        return 0;
    }

    @Override
    public void updateImages(@NotNull PlaylistItem playlistItem) {

    }
}
