//package com.example.praticaldemo.util
//
//import com.example.praticaldemo.ApiService
//import com.example.praticaldemo.data.User
//import com.rx2androidnetworking.Rx2AndroidNetworking
//import io.reactivex.Single
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class ApiServiceImpl  : ApiService {
//
//    override fun getHomeData(): Single<List<User>> {
//        return Rx2AndroidNetworking.post("https://mobileapp.annabelleme.com/en/rest/V1/homepage")
//            .build()
//            .getObjectListSingle(User::class.java)
//
////        return Retrofit.Builder()
////            .baseUrl("https://mobileapp.annabelleme.com/en/rest/V1/homepage")
////            .addConverterFactory(GsonConverterFactory.create())
////            //.addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
////            .build()
////            .create(ApiService::class.java)
//    }
//}