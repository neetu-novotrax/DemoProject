package com.example.praticaldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.praticaldemo.util.MainRepository
import com.google.gson.JsonObject

//class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(MainRepository(apiHelper)) as T
//        }
//        throw IllegalArgumentException("Unknown class name")
//    }
//
//}

class ViewModelFactory(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
