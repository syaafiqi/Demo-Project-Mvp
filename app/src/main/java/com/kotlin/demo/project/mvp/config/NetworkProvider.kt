package com.kotlin.demo.project.mvp.config

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kotlin.demo.project.mvp.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object NetworkProvider {

    @kotlinx.serialization.UnstableDefault
    fun providesRetrofit(): Retrofit = Retrofit.Builder().apply {
        client(providesHttpClient())
        baseUrl(BuildConfig.BASE_URL)
        addConverterFactory(Json.nonstrict.asConverterFactory(MediaType.get("application/json")))
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
    }.build()

    @kotlinx.serialization.UnstableDefault
    fun providesRetrofitCocktailDB(): Retrofit = Retrofit.Builder().apply {
        client(providesHttpClient())
        baseUrl(BuildConfig.COCKTAIL_DB_BASE_URL)
        addConverterFactory(Json.nonstrict.asConverterFactory(MediaType.get("application/json")))
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
    }.build()

    private fun providesHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(providesHttpClientInterceptor())
            addInterceptor(providesInterceptor())
        }.build()

    private fun providesHttpClientInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }

    private fun providesInterceptor(): Interceptor =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().addHeader(
                    "x-rapidapi-key",
                    "65cc202591msh347c67fb6614d13p1774d5jsn76eb9a15458f"
                ).build()
            )
        }
}