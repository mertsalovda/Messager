package ru.mertsalovda.messager.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.mertsalovda.messager.BuildConfig
import ru.mertsalovda.messager.data.api.ChatServerApi
import toothpick.config.Module
import toothpick.ktp.binding.bind


class NetworkModule : Module() {

    private val okHttpClient: OkHttpClient = provideOkHttpClient()
    private val mapper: ObjectMapper = provideObjectMapper()
    private val retrofit: Retrofit = provideRetrofit()
    init {
        bind(ObjectMapper::class.java).toInstance(mapper)
        bind(OkHttpClient::class.java).toInstance(okHttpClient)
        bind(Retrofit::class.java).toInstance(retrofit)
        bind(ChatServerApi::class).toInstance(provideChatServerApi())
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG){
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return builder.build()
    }
    private fun provideObjectMapper() = ObjectMapper()

    private fun provideChatServerApi(): ChatServerApi = retrofit.create(ChatServerApi::class.java)

    private fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.1.65/")
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}
