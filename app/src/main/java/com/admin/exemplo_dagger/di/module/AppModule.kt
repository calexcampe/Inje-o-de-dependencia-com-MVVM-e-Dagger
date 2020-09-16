package com.admin.exemplo_dagger.di.module

import RequestInterceptor
import com.admin.exemplo_dagger.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



/**
 * O módulo de aplicativo que fornece instâncias amplas de vários componentes
 * */

@Module(includes = [ViewModule::class])
public class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(300000, TimeUnit.SECONDS)
        okHttpClient.readTimeout(300000, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(300000, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(RequestInterceptor())
        okHttpClient.interceptors().add(interceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {

        val retrofit = Retrofit.Builder()
            .baseUrl("BASE_URL: https:www.testeexemplo:3087...")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }


}
