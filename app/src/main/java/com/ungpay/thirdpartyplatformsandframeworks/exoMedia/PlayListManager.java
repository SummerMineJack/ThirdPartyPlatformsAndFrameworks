package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.app.Application;

import com.devbrackets.android.playlistcore.manager.ListPlaylistManager;

import org.jetbrains.annotations.NotNull;

public class PlayListManager extends ListPlaylistManager {
    public PlayListManager(@NotNull Application application, @NotNull Class mediaServiceClass) {
        super(application, mediaServiceClass);
    }

}
