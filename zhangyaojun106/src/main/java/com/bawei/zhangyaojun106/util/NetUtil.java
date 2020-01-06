package com.bawei.zhangyaojun106.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bawei.zhangyaojun106.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 张耀军
 * @createTime 2020/1/6 9:10
 * @description 单例封装网络请求工具类
 */
public class NetUtil {

    private final Retrofit retrofit;

    //单例——私有化构造方法
    private NetUtil() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class SingleHolder {
        private static final NetUtil UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return SingleHolder.UTIL;
    }

    public boolean getNetState(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) return info.isConnected();
        return false;
    }

    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
