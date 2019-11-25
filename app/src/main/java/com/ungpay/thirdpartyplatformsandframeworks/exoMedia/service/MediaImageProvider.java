package com.ungpay.thirdpartyplatformsandframeworks.exoMedia.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.devbrackets.android.playlistcore.components.image.ImageProvider;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MediaImageProvider implements ImageProvider {

    private Bitmap remoteViewArtwork;
    private Bitmap notificationImage;
    private RequestManager glide;
    private Context context;
    private NotificationImageTarget notificationImageTarget = new NotificationImageTarget();
    private RemoteViewImageTarget remoteViewImageTarget = new RemoteViewImageTarget();
    private ImageComplete imageComplet;


    public MediaImageProvider(Context context, ImageComplete imageComplet) {
        this.context = context;
        glide = Glide.with(context);
    }

    @Nullable
    @Override
    public Bitmap getLargeNotificationImage() {
        return this.notificationImage != null ? this.notificationImage : this.getDefaultNotificationImage();
    }

    public Bitmap getDefaultNotificationImage() {
        return BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    @Override
    public int getNotificationIconRes() {
        return R.mipmap.ic_launcher;
    }

    @Nullable
    @Override
    public Bitmap getRemoteViewArtwork() {
        return remoteViewArtwork;
    }

    @Override
    public int getRemoteViewIconRes() {
        return R.mipmap.ic_launcher;
    }

    @Override
    public void updateImages(@NotNull PlaylistItem playlistItem) {
        glide.asBitmap().load(playlistItem.getThumbnailUrl()).into(notificationImageTarget);
        glide.asBitmap().load(playlistItem.getArtworkUrl()).into(remoteViewImageTarget);
    }

    private class NotificationImageTarget extends SimpleTarget {

        @Override
        public void onResourceReady(@NonNull Object resource, @androidx.annotation.Nullable Transition transition) {
            notificationImage = (Bitmap) resource;
            imageComplet.onImageUpdated();
        }
    }

    private class RemoteViewImageTarget extends SimpleTarget {

        @Override
        public void onResourceReady(@NonNull Object resource, @androidx.annotation.Nullable Transition transition) {
            notificationImage = (Bitmap) resource;
            imageComplet.onImageUpdated();
        }
    }

    protected interface ImageComplete {
        void onImageUpdated();
    }
}
