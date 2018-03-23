package com.example.nestana.infamily.utils

import android.app.Application

class ApplicationClass : Application() {

    var service: ApiService? = null

    override fun onCreate() {
        super.onCreate()
        service = ApiClient.initRetrofit(Const.BASE_URL, this)
    }

}