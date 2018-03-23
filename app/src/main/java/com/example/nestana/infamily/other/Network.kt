package com.example.nestana.infamily.other

import com.example.nestana.infamily.other.Const.REQUEST_TIME
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by nestana on 24.03.2018.
 */
@Suppress("DEPRECATION")
class Network {

    companion object {
        fun initService(baseURL: String): ForumService {
            return Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(initGson())
                    .client(getClient()).build().create(ForumService::class.java)
        }

        private fun getClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .writeTimeout(REQUEST_TIME, TimeUnit.MINUTES)
                    .readTimeout(REQUEST_TIME, TimeUnit.MINUTES)
                    .connectTimeout(REQUEST_TIME, TimeUnit.MINUTES)
                    .build()
        }

        private fun initGson(): GsonConverterFactory {
            return GsonConverterFactory.create(GsonBuilder().create())
        }

    }
}