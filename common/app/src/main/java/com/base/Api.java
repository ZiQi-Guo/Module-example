package com.base;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：guozq on 2019/11/18 0018 16:11
 * 作用：
 * 说明：
 */
public class Api<T> {

    public Retrofit retrofit;
    public T service;

    public Api getInstance(Class<T> serviceClass) {
        Api api = new Api<>(serviceClass);
        return api;
    }

    public Api(Class<T> serviceClass) {
        build(serviceClass);
    }


    public void build(Class<T> serviceClass) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //日志信息
            }
        });
        //设置级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10 * 1000, TimeUnit.SECONDS)
                .connectTimeout(10 * 1000, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new HttpCookiesInterceptor())
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .build();
        Gson gson = new Gson();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.baidi.com")
                .build();
        service = retrofit.create(serviceClass);

    }

    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //网络拦截器
            //可以设置缓存方式 是否要使用缓存
            //没有拦截信息
            return chain.proceed(chain.request());
        }
    }

    class HttpCookiesInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //Cookies拦截器
            return chain.proceed(chain.request());
        }
    }


}
