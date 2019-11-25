package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

public  class AudioEntity {
    public AudioEntity(String audioTitle, String audioUrl, String audioImage) {
        this.audioTitle = audioTitle;
        this.audioUrl = audioUrl;
        this.audioImage = audioImage;
    }

    private String audioTitle;
    private String audioUrl;
    private String audioImage;


    public String getAudioTitle() {
        return audioTitle;
    }

    public void setAudioTitle(String audioTitle) {
        this.audioTitle = audioTitle;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getAudioImage() {
        return audioImage;
    }

    public void setAudioImage(String audioImage) {
        this.audioImage = audioImage;
    }
}