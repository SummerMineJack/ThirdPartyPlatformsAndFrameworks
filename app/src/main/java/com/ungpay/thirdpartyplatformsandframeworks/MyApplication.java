package com.ungpay.thirdpartyplatformsandframeworks;

import android.app.Application;
import android.util.Log;

import com.blankj.utilcode.util.CrashUtils;
import com.lzy.okgo.OkGo;
import com.ungpay.thirdpartyplatformsandframeworks.ui.fonts.TextField;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
        OkGo.getInstance().init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Regular.ttf")
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build());

        CrashUtils.init((crashInfo, e) -> Log.e("~~~", crashInfo));
    }

}
