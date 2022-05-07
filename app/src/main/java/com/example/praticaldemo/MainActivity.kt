package com.example.praticaldemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.example.praticaldemo.data.User
import com.example.praticaldemo.util.MainRepository
import com.google.gson.JsonObject


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    //private lateinit var adapter: MainAdapter
    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db =  Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        )
            .fallbackToDestructiveMigration()
            .build()

        //setupUI()
        setupViewModel()
        setupObserver()
    }

//    private fun setupUI() {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = MainAdapter(arrayListOf())
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter
//    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            Log.d("TAG", "movieList: $it")
            val runnable = Runnable {
                //projectDao.updateStatus(projectid, "ACTION");
                db!!.demoDataDao().insertData(it.get(0).data)
            }


            val thread = Thread(runnable)
            thread.start()

        })

//        mainViewModel.errorMessage.observe(this, Observer {
//            Log.d(TAG, "errorMessage: $it")
//        })

        //mainViewModel.getAllMovies()
        }


    private fun renderList(users: List<User>) {
        Log.e("TAG", "renderList:>>> " + users)
//        adapter.addData(users)
//        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        var jsonObject = JsonObject()
        jsonObject
            .addProperty("customer_id", "")
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(MainRepository(ApiService.getInstance(), jsonObject))
        ).get(MainViewModel::class.java)
    }
}