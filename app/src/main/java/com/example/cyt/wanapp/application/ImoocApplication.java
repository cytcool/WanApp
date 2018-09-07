package com.example.cyt.wanapp.application;

import android.app.Application;

/*
* 整个程序的入口
* 初始化工作
* 为整个应用的其他模块提供上下文
*/

public class ImoocApplication extends Application {

    private static ImoocApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ImoocApplication getInstance(){
        return mApplication;
    }
}
