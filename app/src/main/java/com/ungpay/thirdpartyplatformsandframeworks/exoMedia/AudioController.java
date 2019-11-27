package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class AudioController {
    private static AudioController audioController = null;
    private MediaPlayer mediaPlayer;

    private AudioController() {

    }

    public synchronized static AudioController getInstance() {
        if (audioController == null) {
            audioController = new AudioController();
        }
        return audioController;
    }

    public void initMediaPlayer(Context context, String audioUrl) {
        mediaPlayer = MediaPlayer.create(context, Uri.parse(audioUrl));
        mediaPlayer.start();
    }

    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    public void releaseMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }


}
