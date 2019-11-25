package com.ungpay.thirdpartyplatformsandframeworks;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.CrashUtils;
import com.devbrackets.android.exomedia.ExoMedia;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.lzy.okgo.OkGo;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.manager.PlaylistManager;
import com.ungpay.thirdpartyplatformsandframeworks.ui.fonts.TextField;

import java.io.File;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MyApplication extends Application {

    private static MyApplication MY_APPLICATION = null;
    private PlaylistManager playlistManager;

    public PlaylistManager getPlaylistManager() {
        return playlistManager;
    }

    public static MyApplication getInstance() {
        return MY_APPLICATION;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MY_APPLICATION = this;
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
        OkGo.getInstance().init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Regular.ttf")
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build());

        CrashUtils.init(new CrashUtils.OnCrashListener() {
            @Override
            public void onCrash(String crashInfo, Throwable e) {
                Log.e("~~~", crashInfo);
            }
        });
        playlistManager=new PlaylistManager(this);
        setConfigExoMedia();
    }

    /**
     * 设置音频缓存
     */
    private void setConfigExoMedia() {
        ExoMedia.setDataSourceFactoryProvider(new ExoMedia.DataSourceFactoryProvider() {
            private CacheDataSourceFactory cacheDataSourceFactory;

            @NonNull
            @Override
            public DataSource.Factory provide(@NonNull String userAgent, @Nullable TransferListener listener) {

                if (cacheDataSourceFactory == null) {
                    OkHttpDataSourceFactory okHttpDataSourceFactory = new OkHttpDataSourceFactory(new OkHttpClient(), userAgent, listener);
                    SimpleCache simpleCache = new SimpleCache(new File(getCacheDir(), "TestAudioCache"), new LeastRecentlyUsedCacheEvictor(52428800));
                    cacheDataSourceFactory = new CacheDataSourceFactory(simpleCache, okHttpDataSourceFactory);
                }
                return cacheDataSourceFactory;
            }
        });
    }
}
