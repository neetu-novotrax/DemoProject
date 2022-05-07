package com.example.praticaldemo.util

import com.example.praticaldemo.ApiService
import com.google.gson.JsonObject


class MainRepository constructor(private val retrofitService: ApiService,val jsonObject: JsonObject) {

        fun getHomeData( ) = retrofitService.getHomeData(jsonObject)
    }

