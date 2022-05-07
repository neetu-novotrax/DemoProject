package com.example.praticaldemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praticaldemo.data.User
import com.example.praticaldemo.util.MainRepository
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val users = MutableLiveData<List<User>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        val response = mainRepository.getHomeData()
        response!!.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.e("TAG", "onResponse: >>>>>>" + response.body())
                users.postValue(response.body())


            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("TAG", "onFailure:>>>>>" + t.message)
                //errorMessage.postValue(t.message)
            }

//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                TODO("Not yet implemented")
//            }
        })
    }


//    private fun fetchUsers() {
//        users.postValue(Resource.loading(null))
//        compositeDisposable.add(
//            mainRepository.getHomeData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ userList ->
//                    users.postValue(Resource.success(userList))
//                }, { throwable ->
//                    users.postValue(Resource.error("Something Went Wrong", null))
//                })
//        )
//    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }
}