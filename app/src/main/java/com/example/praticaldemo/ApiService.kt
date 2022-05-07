package com.example.praticaldemo


import com.example.praticaldemo.data.User
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("homepage")
    fun getHomeData(@Body locationPost: JsonObject): Call<List<User>>?

    companion object {

        var retrofitService: ApiService? = null

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): ApiService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://mobileapp.annabelleme.com/en/rest/V1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }
}
